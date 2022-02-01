package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.g.b;
import androidx.core.g.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h
  implements androidx.core.a.a.a
{
  private static final int[] mx = { 1, 4, 5, 3, 2, 0 };
  public a mA;
  private ArrayList<j> mB;
  private boolean mC;
  protected final Context mContext;
  public ArrayList<j> mD;
  private ArrayList<j> mE;
  private boolean mF;
  public int mG;
  private ContextMenu.ContextMenuInfo mI;
  ArrayList<j> mItems;
  CharSequence mJ;
  Drawable mK;
  View mL;
  private boolean mM;
  private boolean mN;
  private boolean mO;
  boolean mP;
  private boolean mQ;
  private ArrayList<j> mR;
  private final Resources mResources;
  private CopyOnWriteArrayList<WeakReference<o>> mS;
  j mT;
  private boolean mU;
  public boolean mV;
  private boolean my;
  private boolean mz;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(239343);
    this.mG = 0;
    this.mM = false;
    this.mN = false;
    this.mO = false;
    this.mP = false;
    this.mQ = false;
    this.mR = new ArrayList();
    this.mS = new CopyOnWriteArrayList();
    this.mU = false;
    this.mContext = paramContext;
    this.mResources = paramContext.getResources();
    this.mItems = new ArrayList();
    this.mB = new ArrayList();
    this.mC = true;
    this.mD = new ArrayList();
    this.mE = new ArrayList();
    this.mF = true;
    if ((this.mResources.getConfiguration().keyboard != 1) && (x.d(ViewConfiguration.get(this.mContext), this.mContext))) {}
    for (;;)
    {
      this.mz = bool;
      AppMethodBeat.o(239343);
      return;
      bool = false;
    }
  }
  
  private static int a(ArrayList<j> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(239410);
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      if (((j)paramArrayList.get(i)).kO <= paramInt)
      {
        AppMethodBeat.o(239410);
        return i + 1;
      }
      i -= 1;
    }
    AppMethodBeat.o(239410);
    return 0;
  }
  
  private j a(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(239414);
    ArrayList localArrayList = this.mR;
    localArrayList.clear();
    a(localArrayList, paramInt, paramKeyEvent);
    if (localArrayList.isEmpty())
    {
      AppMethodBeat.o(239414);
      return null;
    }
    int k = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    paramKeyEvent.getKeyData(localKeyData);
    int m = localArrayList.size();
    if (m == 1)
    {
      paramKeyEvent = (j)localArrayList.get(0);
      AppMethodBeat.o(239414);
      return paramKeyEvent;
    }
    boolean bool = cc();
    int i = 0;
    while (i < m)
    {
      paramKeyEvent = (j)localArrayList.get(i);
      if (bool) {}
      for (int j = paramKeyEvent.getAlphabeticShortcut(); ((j == localKeyData.meta[0]) && ((k & 0x2) == 0)) || ((j == localKeyData.meta[2]) && ((k & 0x2) != 0)) || ((bool) && (j == 8) && (paramInt == 67)); j = paramKeyEvent.getNumericShortcut())
      {
        AppMethodBeat.o(239414);
        return paramKeyEvent;
      }
      i += 1;
    }
    AppMethodBeat.o(239414);
    return null;
  }
  
  private void a(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    AppMethodBeat.i(239433);
    Resources localResources = this.mResources;
    if (paramView != null)
    {
      this.mL = paramView;
      this.mJ = null;
      this.mK = null;
      H(false);
      AppMethodBeat.o(239433);
      return;
    }
    if (paramInt1 > 0)
    {
      this.mJ = localResources.getText(paramInt1);
      label57:
      if (paramInt2 <= 0) {
        break label93;
      }
      this.mK = androidx.core.content.a.m(this.mContext, paramInt2);
    }
    for (;;)
    {
      this.mL = null;
      break;
      if (paramCharSequence == null) {
        break label57;
      }
      this.mJ = paramCharSequence;
      break label57;
      label93:
      if (paramDrawable != null) {
        this.mK = paramDrawable;
      }
    }
  }
  
  private void a(List<j> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(239413);
    boolean bool = cc();
    int m = paramKeyEvent.getModifiers();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67))
    {
      AppMethodBeat.o(239413);
      return;
    }
    int n = this.mItems.size();
    int i = 0;
    if (i < n)
    {
      j localj = (j)this.mItems.get(i);
      if (localj.hasSubMenu()) {
        ((h)localj.getSubMenu()).a(paramList, paramInt, paramKeyEvent);
      }
      int j;
      if (bool)
      {
        j = localj.getAlphabeticShortcut();
        label114:
        if (!bool) {
          break label230;
        }
        k = localj.getAlphabeticModifiers();
        label126:
        if ((0x1100F & m) != (k & 0x1100F)) {
          break label240;
        }
      }
      label230:
      label240:
      for (int k = 1;; k = 0)
      {
        if ((k != 0) && (j != 0) && ((j == localKeyData.meta[0]) || (j == localKeyData.meta[2]) || ((bool) && (j == 8) && (paramInt == 67))) && (localj.isEnabled())) {
          paramList.add(localj);
        }
        i += 1;
        break;
        j = localj.getNumericShortcut();
        break label114;
        k = localj.getNumericModifiers();
        break label126;
      }
    }
    AppMethodBeat.o(239413);
  }
  
  private boolean a(u paramu, o paramo)
  {
    boolean bool = false;
    AppMethodBeat.i(239350);
    if (this.mS.isEmpty())
    {
      AppMethodBeat.o(239350);
      return false;
    }
    if (paramo != null) {
      bool = paramo.a(paramu);
    }
    paramo = this.mS.iterator();
    while (paramo.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramo.next();
      o localo = (o)localWeakReference.get();
      if (localo == null)
      {
        this.mS.remove(localWeakReference);
      }
      else
      {
        if (bool) {
          break label115;
        }
        bool = localo.a(paramu);
      }
    }
    label115:
    for (;;)
    {
      break;
      AppMethodBeat.o(239350);
      return bool;
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(239388);
    if ((paramInt < 0) || (paramInt >= this.mItems.size()))
    {
      AppMethodBeat.o(239388);
      return;
    }
    this.mItems.remove(paramInt);
    if (paramBoolean) {
      H(true);
    }
    AppMethodBeat.o(239388);
  }
  
  public final void G(boolean paramBoolean)
  {
    AppMethodBeat.i(239418);
    if (this.mQ)
    {
      AppMethodBeat.o(239418);
      return;
    }
    this.mQ = true;
    Iterator localIterator = this.mS.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if (localo == null) {
        this.mS.remove(localWeakReference);
      } else {
        localo.a(this, paramBoolean);
      }
    }
    this.mQ = false;
    AppMethodBeat.o(239418);
  }
  
  public void H(boolean paramBoolean)
  {
    AppMethodBeat.i(239421);
    if (!this.mM)
    {
      if (paramBoolean)
      {
        this.mC = true;
        this.mF = true;
      }
      if (!this.mS.isEmpty())
      {
        ce();
        Iterator localIterator = this.mS.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          o localo = (o)localWeakReference.get();
          if (localo == null) {
            this.mS.remove(localWeakReference);
          } else {
            localo.F(paramBoolean);
          }
        }
        cf();
      }
      AppMethodBeat.o(239421);
      return;
    }
    this.mN = true;
    if (paramBoolean) {
      this.mO = true;
    }
    AppMethodBeat.o(239421);
  }
  
  protected MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239362);
    int i = (0xFFFF0000 & paramInt3) >> 16;
    if ((i < 0) || (i >= mx.length))
    {
      paramCharSequence = new IllegalArgumentException("order does not contain a valid category.");
      AppMethodBeat.o(239362);
      throw paramCharSequence;
    }
    i = mx[i] << 16 | 0xFFFF & paramInt3;
    paramCharSequence = new j(this, paramInt1, paramInt2, paramInt3, i, paramCharSequence, this.mG);
    if (this.mI != null) {
      paramCharSequence.ni = this.mI;
    }
    this.mItems.add(a(this.mItems, i), paramCharSequence);
    H(true);
    AppMethodBeat.o(239362);
    return paramCharSequence;
  }
  
  public void a(a parama)
  {
    this.mA = parama;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(239345);
    a(paramo, this.mContext);
    AppMethodBeat.o(239345);
  }
  
  public final void a(o paramo, Context paramContext)
  {
    AppMethodBeat.i(239347);
    this.mS.add(new WeakReference(paramo));
    paramo.a(paramContext, this);
    this.mF = true;
    AppMethodBeat.o(239347);
  }
  
  public final boolean a(MenuItem paramMenuItem, o paramo, int paramInt)
  {
    AppMethodBeat.i(239416);
    Object localObject = (j)paramMenuItem;
    if ((localObject == null) || (!((j)localObject).isEnabled()))
    {
      AppMethodBeat.o(239416);
      return false;
    }
    boolean bool1 = ((j)localObject).cm();
    paramMenuItem = ((j)localObject).nf;
    int i;
    boolean bool2;
    if ((paramMenuItem != null) && (paramMenuItem.hasSubMenu()))
    {
      i = 1;
      if (!((j)localObject).cu()) {
        break label111;
      }
      bool2 = ((j)localObject).expandActionView() | bool1;
      bool1 = bool2;
      if (bool2)
      {
        G(true);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(239416);
      return bool1;
      i = 0;
      break;
      label111:
      if ((((j)localObject).hasSubMenu()) || (i != 0))
      {
        if ((paramInt & 0x4) == 0) {
          G(false);
        }
        if (!((j)localObject).hasSubMenu()) {
          ((j)localObject).b(new u(this.mContext, this, (j)localObject));
        }
        localObject = (u)((j)localObject).getSubMenu();
        if (i != 0) {
          paramMenuItem.b((SubMenu)localObject);
        }
        bool2 = a((u)localObject, paramo) | bool1;
        bool1 = bool2;
        if (!bool2)
        {
          G(true);
          bool1 = bool2;
        }
      }
      else if ((paramInt & 0x1) == 0)
      {
        G(true);
      }
    }
  }
  
  public MenuItem add(int paramInt)
  {
    AppMethodBeat.i(239367);
    MenuItem localMenuItem = a(0, 0, 0, this.mResources.getString(paramInt));
    AppMethodBeat.o(239367);
    return localMenuItem;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(239373);
    MenuItem localMenuItem = a(paramInt1, paramInt2, paramInt3, this.mResources.getString(paramInt4));
    AppMethodBeat.o(239373);
    return localMenuItem;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239370);
    paramCharSequence = a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    AppMethodBeat.o(239370);
    return paramCharSequence;
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239365);
    paramCharSequence = a(0, 0, 0, paramCharSequence);
    AppMethodBeat.o(239365);
    return paramCharSequence;
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    AppMethodBeat.i(239384);
    PackageManager localPackageManager = this.mContext.getPackageManager();
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i;
    label58:
    ResolveInfo localResolveInfo;
    if (localList != null)
    {
      i = localList.size();
      if ((paramInt4 & 0x1) == 0) {
        removeGroup(paramInt1);
      }
      paramInt4 = 0;
      if (paramInt4 >= i) {
        break label220;
      }
      localResolveInfo = (ResolveInfo)localList.get(paramInt4);
      if (localResolveInfo.specificIndex >= 0) {
        break label207;
      }
    }
    label207:
    for (paramComponentName = paramIntent;; paramComponentName = paramArrayOfIntent[localResolveInfo.specificIndex])
    {
      paramComponentName = new Intent(paramComponentName);
      paramComponentName.setComponent(new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name));
      paramComponentName = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(paramComponentName);
      if ((paramArrayOfMenuItem != null) && (localResolveInfo.specificIndex >= 0)) {
        paramArrayOfMenuItem[localResolveInfo.specificIndex] = paramComponentName;
      }
      paramInt4 += 1;
      break label58;
      i = 0;
      break;
    }
    label220:
    AppMethodBeat.o(239384);
    return i;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    AppMethodBeat.i(239378);
    SubMenu localSubMenu = addSubMenu(0, 0, 0, this.mResources.getString(paramInt));
    AppMethodBeat.o(239378);
    return localSubMenu;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(239381);
    SubMenu localSubMenu = addSubMenu(paramInt1, paramInt2, paramInt3, this.mResources.getString(paramInt4));
    AppMethodBeat.o(239381);
    return localSubMenu;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239379);
    paramCharSequence = (j)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    u localu = new u(this.mContext, this, paramCharSequence);
    paramCharSequence.b(localu);
    AppMethodBeat.o(239379);
    return localu;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239375);
    paramCharSequence = addSubMenu(0, 0, 0, paramCharSequence);
    AppMethodBeat.o(239375);
    return paramCharSequence;
  }
  
  protected final h aj(int paramInt)
  {
    AppMethodBeat.i(239437);
    a(paramInt, null, 0, null, null);
    AppMethodBeat.o(239437);
    return this;
  }
  
  protected final h ak(int paramInt)
  {
    AppMethodBeat.i(239440);
    a(0, null, paramInt, null, null);
    AppMethodBeat.o(239440);
    return this;
  }
  
  public final void b(o paramo)
  {
    AppMethodBeat.i(239348);
    Iterator localIterator = this.mS.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if ((localo == null) || (localo == paramo)) {
        this.mS.remove(localWeakReference);
      }
    }
    AppMethodBeat.o(239348);
  }
  
  protected String ca()
  {
    return "android:menu:actionviewstates";
  }
  
  public boolean cb()
  {
    return this.mU;
  }
  
  boolean cc()
  {
    return this.my;
  }
  
  public boolean cd()
  {
    return this.mz;
  }
  
  public final void ce()
  {
    if (!this.mM)
    {
      this.mM = true;
      this.mN = false;
      this.mO = false;
    }
  }
  
  public final void cf()
  {
    AppMethodBeat.i(239423);
    this.mM = false;
    if (this.mN)
    {
      this.mN = false;
      H(this.mO);
    }
    AppMethodBeat.o(239423);
  }
  
  final void cg()
  {
    AppMethodBeat.i(239424);
    this.mC = true;
    H(true);
    AppMethodBeat.o(239424);
  }
  
  final void ch()
  {
    AppMethodBeat.i(239425);
    this.mF = true;
    H(true);
    AppMethodBeat.o(239425);
  }
  
  public final ArrayList<j> ci()
  {
    AppMethodBeat.i(239426);
    if (!this.mC)
    {
      localObject = this.mB;
      AppMethodBeat.o(239426);
      return localObject;
    }
    this.mB.clear();
    int j = this.mItems.size();
    int i = 0;
    while (i < j)
    {
      localObject = (j)this.mItems.get(i);
      if (((j)localObject).isVisible()) {
        this.mB.add(localObject);
      }
      i += 1;
    }
    this.mC = false;
    this.mF = true;
    Object localObject = this.mB;
    AppMethodBeat.o(239426);
    return localObject;
  }
  
  public final void cj()
  {
    AppMethodBeat.i(239428);
    ArrayList localArrayList = ci();
    if (!this.mF)
    {
      AppMethodBeat.o(239428);
      return;
    }
    Object localObject = this.mS.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      o localo = (o)localWeakReference.get();
      if (localo == null) {
        this.mS.remove(localWeakReference);
      } else {
        i = localo.bS() | i;
      }
    }
    if (i != 0)
    {
      this.mD.clear();
      this.mE.clear();
      int k = localArrayList.size();
      i = 0;
      if (i < k)
      {
        localObject = (j)localArrayList.get(i);
        if (((j)localObject).cq()) {
          this.mD.add(localObject);
        }
        for (;;)
        {
          int j;
          i += 1;
          break;
          this.mE.add(localObject);
        }
      }
    }
    else
    {
      this.mD.clear();
      this.mE.clear();
      this.mE.addAll(ci());
    }
    this.mF = false;
    AppMethodBeat.o(239428);
  }
  
  public final ArrayList<j> ck()
  {
    AppMethodBeat.i(239430);
    cj();
    ArrayList localArrayList = this.mE;
    AppMethodBeat.o(239430);
    return localArrayList;
  }
  
  public h cl()
  {
    return this;
  }
  
  public void clear()
  {
    AppMethodBeat.i(239390);
    if (this.mT != null) {
      g(this.mT);
    }
    this.mItems.clear();
    H(true);
    AppMethodBeat.o(239390);
  }
  
  public void clearHeader()
  {
    AppMethodBeat.i(239432);
    this.mK = null;
    this.mJ = null;
    this.mL = null;
    H(false);
    AppMethodBeat.o(239432);
  }
  
  public void close()
  {
    AppMethodBeat.i(239420);
    G(true);
    AppMethodBeat.o(239420);
  }
  
  protected final h d(Drawable paramDrawable)
  {
    AppMethodBeat.i(239439);
    a(0, null, 0, paramDrawable, null);
    AppMethodBeat.o(239439);
    return this;
  }
  
  protected final h d(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239435);
    a(0, paramCharSequence, 0, null, null);
    AppMethodBeat.o(239435);
    return this;
  }
  
  boolean d(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(239408);
    if ((this.mA != null) && (this.mA.a(paramh, paramMenuItem)))
    {
      AppMethodBeat.o(239408);
      return true;
    }
    AppMethodBeat.o(239408);
    return false;
  }
  
  public final void e(Bundle paramBundle)
  {
    AppMethodBeat.i(239351);
    if (!this.mS.isEmpty())
    {
      SparseArray localSparseArray = new SparseArray();
      Iterator localIterator = this.mS.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        o localo = (o)((WeakReference)localObject).get();
        if (localo == null)
        {
          this.mS.remove(localObject);
        }
        else
        {
          int i = localo.getId();
          if (i > 0)
          {
            localObject = localo.onSaveInstanceState();
            if (localObject != null) {
              localSparseArray.put(i, localObject);
            }
          }
        }
      }
      paramBundle.putSparseParcelableArray("android:menu:presenters", localSparseArray);
    }
    AppMethodBeat.o(239351);
  }
  
  public final void f(Bundle paramBundle)
  {
    AppMethodBeat.i(239354);
    paramBundle = paramBundle.getSparseParcelableArray("android:menu:presenters");
    if ((paramBundle == null) || (this.mS.isEmpty()))
    {
      AppMethodBeat.o(239354);
      return;
    }
    Iterator localIterator = this.mS.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      o localo = (o)((WeakReference)localObject).get();
      if (localo == null)
      {
        this.mS.remove(localObject);
      }
      else
      {
        int i = localo.getId();
        if (i > 0)
        {
          localObject = (Parcelable)paramBundle.get(i);
          if (localObject != null) {
            localo.onRestoreInstanceState((Parcelable)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(239354);
  }
  
  public boolean f(j paramj)
  {
    AppMethodBeat.i(239445);
    if (this.mS.isEmpty())
    {
      AppMethodBeat.o(239445);
      return false;
    }
    ce();
    Iterator localIterator = this.mS.iterator();
    boolean bool = false;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        o localo = (o)localWeakReference.get();
        if (localo == null)
        {
          this.mS.remove(localWeakReference);
        }
        else
        {
          bool = localo.c(paramj);
          if (!bool) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      cf();
      if (bool) {
        this.mT = paramj;
      }
      AppMethodBeat.o(239445);
      return bool;
      break;
    }
  }
  
  public MenuItem findItem(int paramInt)
  {
    AppMethodBeat.i(239399);
    int j = size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (j)this.mItems.get(i);
      if (((j)localObject).getItemId() == paramInt)
      {
        AppMethodBeat.o(239399);
        return localObject;
      }
      if (((j)localObject).hasSubMenu())
      {
        localObject = ((j)localObject).getSubMenu().findItem(paramInt);
        if (localObject != null)
        {
          AppMethodBeat.o(239399);
          return localObject;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(239399);
    return null;
  }
  
  public final void g(Bundle paramBundle)
  {
    AppMethodBeat.i(239355);
    Object localObject1 = null;
    int j = size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = getItem(i);
      View localView = localMenuItem.getActionView();
      Object localObject3 = localObject1;
      if (localView != null)
      {
        localObject3 = localObject1;
        if (localView.getId() != -1)
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new SparseArray();
          }
          localView.saveHierarchyState((SparseArray)localObject2);
          localObject3 = localObject2;
          if (localMenuItem.isActionViewExpanded())
          {
            paramBundle.putInt("android:menu:expandedactionview", localMenuItem.getItemId());
            localObject3 = localObject2;
          }
        }
      }
      if (localMenuItem.hasSubMenu()) {
        ((u)localMenuItem.getSubMenu()).g(paramBundle);
      }
      i += 1;
      localObject1 = localObject3;
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(ca(), localObject1);
    }
    AppMethodBeat.o(239355);
  }
  
  public boolean g(j paramj)
  {
    AppMethodBeat.i(239446);
    if ((this.mS.isEmpty()) || (this.mT != paramj))
    {
      AppMethodBeat.o(239446);
      return false;
    }
    ce();
    Iterator localIterator = this.mS.iterator();
    boolean bool = false;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        o localo = (o)localWeakReference.get();
        if (localo == null)
        {
          this.mS.remove(localWeakReference);
        }
        else
        {
          bool = localo.d(paramj);
          if (!bool) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      cf();
      if (bool) {
        this.mT = null;
      }
      AppMethodBeat.o(239446);
      return bool;
      break;
    }
  }
  
  public MenuItem getItem(int paramInt)
  {
    AppMethodBeat.i(239403);
    MenuItem localMenuItem = (MenuItem)this.mItems.get(paramInt);
    AppMethodBeat.o(239403);
    return localMenuItem;
  }
  
  public final void h(Bundle paramBundle)
  {
    AppMethodBeat.i(239357);
    if (paramBundle == null)
    {
      AppMethodBeat.o(239357);
      return;
    }
    SparseArray localSparseArray = paramBundle.getSparseParcelableArray(ca());
    int j = size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = getItem(i);
      View localView = localMenuItem.getActionView();
      if ((localView != null) && (localView.getId() != -1)) {
        localView.restoreHierarchyState(localSparseArray);
      }
      if (localMenuItem.hasSubMenu()) {
        ((u)localMenuItem.getSubMenu()).h(paramBundle);
      }
      i += 1;
    }
    i = paramBundle.getInt("android:menu:expandedactionview");
    if (i > 0)
    {
      paramBundle = findItem(i);
      if (paramBundle != null) {
        paramBundle.expandActionView();
      }
    }
    AppMethodBeat.o(239357);
  }
  
  public boolean hasVisibleItems()
  {
    AppMethodBeat.i(239397);
    if (this.mV)
    {
      AppMethodBeat.o(239397);
      return true;
    }
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (((j)this.mItems.get(i)).isVisible())
      {
        AppMethodBeat.o(239397);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(239397);
    return false;
  }
  
  protected final h i(View paramView)
  {
    AppMethodBeat.i(239442);
    a(0, null, 0, null, paramView);
    AppMethodBeat.o(239442);
    return this;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(239405);
    if (a(paramInt, paramKeyEvent) != null)
    {
      AppMethodBeat.o(239405);
      return true;
    }
    AppMethodBeat.o(239405);
    return false;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239415);
    boolean bool = a(findItem(paramInt1), null, paramInt2);
    AppMethodBeat.o(239415);
    return bool;
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    AppMethodBeat.i(239412);
    paramKeyEvent = a(paramInt1, paramKeyEvent);
    boolean bool = false;
    if (paramKeyEvent != null) {
      bool = a(paramKeyEvent, null, paramInt2);
    }
    if ((paramInt2 & 0x2) != 0) {
      G(true);
    }
    AppMethodBeat.o(239412);
    return bool;
  }
  
  public void removeGroup(int paramInt)
  {
    AppMethodBeat.i(239386);
    int j = size();
    int i = 0;
    if (i < j) {
      if (((j)this.mItems.get(i)).getGroupId() != paramInt) {}
    }
    for (;;)
    {
      label36:
      if (i >= 0)
      {
        int k = this.mItems.size();
        j = 0;
        for (;;)
        {
          if ((j < k - i) && (((j)this.mItems.get(i)).getGroupId() == paramInt))
          {
            b(i, false);
            j += 1;
            continue;
            i += 1;
            break;
            i = -1;
            break label36;
          }
        }
        H(true);
      }
    }
    AppMethodBeat.o(239386);
  }
  
  public void removeItem(int paramInt)
  {
    AppMethodBeat.i(239385);
    int j = size();
    int i = 0;
    if (i < j) {
      if (((j)this.mItems.get(i)).getItemId() != paramInt) {}
    }
    for (;;)
    {
      b(i, true);
      AppMethodBeat.o(239385);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(239392);
    int j = this.mItems.size();
    int i = 0;
    while (i < j)
    {
      j localj = (j)this.mItems.get(i);
      if (localj.getGroupId() == paramInt)
      {
        localj.I(paramBoolean2);
        localj.setCheckable(paramBoolean1);
      }
      i += 1;
    }
    AppMethodBeat.o(239392);
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    this.mU = paramBoolean;
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(239395);
    int j = this.mItems.size();
    int i = 0;
    while (i < j)
    {
      j localj = (j)this.mItems.get(i);
      if (localj.getGroupId() == paramInt) {
        localj.setEnabled(paramBoolean);
      }
      i += 1;
    }
    AppMethodBeat.o(239395);
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(239393);
    int k = this.mItems.size();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      j localj = (j)this.mItems.get(j);
      if ((localj.getGroupId() != paramInt) || (!localj.K(paramBoolean))) {
        break label86;
      }
      i = 1;
    }
    label86:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0) {
        H(true);
      }
      AppMethodBeat.o(239393);
      return;
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    AppMethodBeat.i(239406);
    this.my = paramBoolean;
    H(false);
    AppMethodBeat.o(239406);
  }
  
  public int size()
  {
    AppMethodBeat.i(239402);
    int i = this.mItems.size();
    AppMethodBeat.o(239402);
    return i;
  }
  
  public static abstract interface a
  {
    public abstract void a(h paramh);
    
    public abstract boolean a(h paramh, MenuItem paramMenuItem);
  }
  
  public static abstract interface b
  {
    public abstract boolean e(j paramj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.h
 * JD-Core Version:    0.7.0.1
 */