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
import androidx.core.g.aa;
import androidx.core.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h
  implements androidx.core.a.a.a
{
  private static final int[] nw = { 1, 4, 5, 3, 2, 0 };
  protected final Context mContext;
  ArrayList<j> mItems;
  private final Resources mResources;
  private ArrayList<j> nA;
  private boolean nB;
  public ArrayList<j> nC;
  private ArrayList<j> nD;
  private boolean nE;
  public int nF;
  private ContextMenu.ContextMenuInfo nG;
  CharSequence nH;
  Drawable nI;
  View nJ;
  private boolean nK;
  private boolean nL;
  private boolean nM;
  boolean nN;
  private boolean nO;
  private ArrayList<j> nP;
  private CopyOnWriteArrayList<WeakReference<o>> nQ;
  j nR;
  private boolean nS;
  public boolean nT;
  private boolean nx;
  private boolean ny;
  public a nz;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(201013);
    this.nF = 0;
    this.nK = false;
    this.nL = false;
    this.nM = false;
    this.nN = false;
    this.nO = false;
    this.nP = new ArrayList();
    this.nQ = new CopyOnWriteArrayList();
    this.nS = false;
    this.mContext = paramContext;
    this.mResources = paramContext.getResources();
    this.mItems = new ArrayList();
    this.nA = new ArrayList();
    this.nB = true;
    this.nC = new ArrayList();
    this.nD = new ArrayList();
    this.nE = true;
    if ((this.mResources.getConfiguration().keyboard != 1) && (aa.d(ViewConfiguration.get(this.mContext), this.mContext))) {}
    for (;;)
    {
      this.ny = bool;
      AppMethodBeat.o(201013);
      return;
      bool = false;
    }
  }
  
  private static int a(ArrayList<j> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(201044);
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      if (((j)paramArrayList.get(i)).lK <= paramInt)
      {
        AppMethodBeat.o(201044);
        return i + 1;
      }
      i -= 1;
    }
    AppMethodBeat.o(201044);
    return 0;
  }
  
  private j a(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(201068);
    ArrayList localArrayList = this.nP;
    localArrayList.clear();
    a(localArrayList, paramInt, paramKeyEvent);
    if (localArrayList.isEmpty())
    {
      AppMethodBeat.o(201068);
      return null;
    }
    int k = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    paramKeyEvent.getKeyData(localKeyData);
    int m = localArrayList.size();
    if (m == 1)
    {
      paramKeyEvent = (j)localArrayList.get(0);
      AppMethodBeat.o(201068);
      return paramKeyEvent;
    }
    boolean bool = cV();
    int i = 0;
    while (i < m)
    {
      paramKeyEvent = (j)localArrayList.get(i);
      if (bool) {}
      for (int j = paramKeyEvent.getAlphabeticShortcut(); ((j == localKeyData.meta[0]) && ((k & 0x2) == 0)) || ((j == localKeyData.meta[2]) && ((k & 0x2) != 0)) || ((bool) && (j == 8) && (paramInt == 67)); j = paramKeyEvent.getNumericShortcut())
      {
        AppMethodBeat.o(201068);
        return paramKeyEvent;
      }
      i += 1;
    }
    AppMethodBeat.o(201068);
    return null;
  }
  
  private void a(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    AppMethodBeat.i(201073);
    Resources localResources = this.mResources;
    if (paramView != null)
    {
      this.nJ = paramView;
      this.nH = null;
      this.nI = null;
      L(false);
      AppMethodBeat.o(201073);
      return;
    }
    if (paramInt1 > 0)
    {
      this.nH = localResources.getText(paramInt1);
      label57:
      if (paramInt2 <= 0) {
        break label93;
      }
      this.nI = androidx.core.content.a.m(this.mContext, paramInt2);
    }
    for (;;)
    {
      this.nJ = null;
      break;
      if (paramCharSequence == null) {
        break label57;
      }
      this.nH = paramCharSequence;
      break label57;
      label93:
      if (paramDrawable != null) {
        this.nI = paramDrawable;
      }
    }
  }
  
  private void a(List<j> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(201057);
    boolean bool = cV();
    int m = paramKeyEvent.getModifiers();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67))
    {
      AppMethodBeat.o(201057);
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
    AppMethodBeat.o(201057);
  }
  
  private boolean a(u paramu, o paramo)
  {
    boolean bool = false;
    AppMethodBeat.i(201026);
    if (this.nQ.isEmpty())
    {
      AppMethodBeat.o(201026);
      return false;
    }
    if (paramo != null) {
      bool = paramo.a(paramu);
    }
    paramo = this.nQ.iterator();
    while (paramo.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramo.next();
      o localo = (o)localWeakReference.get();
      if (localo == null)
      {
        this.nQ.remove(localWeakReference);
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
      AppMethodBeat.o(201026);
      return bool;
    }
  }
  
  private void l(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(201038);
    if ((paramInt < 0) || (paramInt >= this.mItems.size()))
    {
      AppMethodBeat.o(201038);
      return;
    }
    this.mItems.remove(paramInt);
    if (paramBoolean) {
      L(true);
    }
    AppMethodBeat.o(201038);
  }
  
  public final void K(boolean paramBoolean)
  {
    AppMethodBeat.i(201410);
    if (this.nO)
    {
      AppMethodBeat.o(201410);
      return;
    }
    this.nO = true;
    Iterator localIterator = this.nQ.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if (localo == null) {
        this.nQ.remove(localWeakReference);
      } else {
        localo.a(this, paramBoolean);
      }
    }
    this.nO = false;
    AppMethodBeat.o(201410);
  }
  
  public void L(boolean paramBoolean)
  {
    AppMethodBeat.i(201424);
    if (!this.nK)
    {
      if (paramBoolean)
      {
        this.nB = true;
        this.nE = true;
      }
      if (!this.nQ.isEmpty())
      {
        cX();
        Iterator localIterator = this.nQ.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          o localo = (o)localWeakReference.get();
          if (localo == null) {
            this.nQ.remove(localWeakReference);
          } else {
            localo.J(paramBoolean);
          }
        }
        cY();
      }
      AppMethodBeat.o(201424);
      return;
    }
    this.nL = true;
    if (paramBoolean) {
      this.nM = true;
    }
    AppMethodBeat.o(201424);
  }
  
  protected MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201162);
    int i = (0xFFFF0000 & paramInt3) >> 16;
    if ((i < 0) || (i >= nw.length))
    {
      paramCharSequence = new IllegalArgumentException("order does not contain a valid category.");
      AppMethodBeat.o(201162);
      throw paramCharSequence;
    }
    i = nw[i] << 16 | 0xFFFF & paramInt3;
    paramCharSequence = new j(this, paramInt1, paramInt2, paramInt3, i, paramCharSequence, this.nF);
    if (this.nG != null) {
      paramCharSequence.oe = this.nG;
    }
    this.mItems.add(a(this.mItems, i), paramCharSequence);
    L(true);
    AppMethodBeat.o(201162);
    return paramCharSequence;
  }
  
  public void a(a parama)
  {
    this.nz = parama;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(201085);
    a(paramo, this.mContext);
    AppMethodBeat.o(201085);
  }
  
  public final void a(o paramo, Context paramContext)
  {
    AppMethodBeat.i(201090);
    this.nQ.add(new WeakReference(paramo));
    paramo.a(paramContext, this);
    this.nE = true;
    AppMethodBeat.o(201090);
  }
  
  public final boolean a(MenuItem paramMenuItem, o paramo, int paramInt)
  {
    AppMethodBeat.i(201407);
    Object localObject = (j)paramMenuItem;
    if ((localObject == null) || (!((j)localObject).isEnabled()))
    {
      AppMethodBeat.o(201407);
      return false;
    }
    boolean bool1 = ((j)localObject).df();
    paramMenuItem = ((j)localObject).ob;
    int i;
    boolean bool2;
    if ((paramMenuItem != null) && (paramMenuItem.hasSubMenu()))
    {
      i = 1;
      if (!((j)localObject).dn()) {
        break label111;
      }
      bool2 = ((j)localObject).expandActionView() | bool1;
      bool1 = bool2;
      if (bool2)
      {
        K(true);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(201407);
      return bool1;
      i = 0;
      break;
      label111:
      if ((((j)localObject).hasSubMenu()) || (i != 0))
      {
        if ((paramInt & 0x4) == 0) {
          K(false);
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
          K(true);
          bool1 = bool2;
        }
      }
      else if ((paramInt & 0x1) == 0)
      {
        K(true);
      }
    }
  }
  
  public MenuItem add(int paramInt)
  {
    AppMethodBeat.i(201177);
    MenuItem localMenuItem = a(0, 0, 0, this.mResources.getString(paramInt));
    AppMethodBeat.o(201177);
    return localMenuItem;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(201197);
    MenuItem localMenuItem = a(paramInt1, paramInt2, paramInt3, this.mResources.getString(paramInt4));
    AppMethodBeat.o(201197);
    return localMenuItem;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201187);
    paramCharSequence = a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    AppMethodBeat.o(201187);
    return paramCharSequence;
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201171);
    paramCharSequence = a(0, 0, 0, paramCharSequence);
    AppMethodBeat.o(201171);
    return paramCharSequence;
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    AppMethodBeat.i(201257);
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
    AppMethodBeat.o(201257);
    return i;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    AppMethodBeat.i(201211);
    SubMenu localSubMenu = addSubMenu(0, 0, 0, this.mResources.getString(paramInt));
    AppMethodBeat.o(201211);
    return localSubMenu;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(201225);
    SubMenu localSubMenu = addSubMenu(paramInt1, paramInt2, paramInt3, this.mResources.getString(paramInt4));
    AppMethodBeat.o(201225);
    return localSubMenu;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201217);
    paramCharSequence = (j)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    u localu = new u(this.mContext, this, paramCharSequence);
    paramCharSequence.b(localu);
    AppMethodBeat.o(201217);
    return localu;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201203);
    paramCharSequence = addSubMenu(0, 0, 0, paramCharSequence);
    AppMethodBeat.o(201203);
    return paramCharSequence;
  }
  
  protected final h ah(int paramInt)
  {
    AppMethodBeat.i(201498);
    a(paramInt, null, 0, null, null);
    AppMethodBeat.o(201498);
    return this;
  }
  
  protected final h ai(int paramInt)
  {
    AppMethodBeat.i(201515);
    a(0, null, paramInt, null, null);
    AppMethodBeat.o(201515);
    return this;
  }
  
  public final void b(o paramo)
  {
    AppMethodBeat.i(201097);
    Iterator localIterator = this.nQ.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if ((localo == null) || (localo == paramo)) {
        this.nQ.remove(localWeakReference);
      }
    }
    AppMethodBeat.o(201097);
  }
  
  protected String cT()
  {
    return "android:menu:actionviewstates";
  }
  
  public boolean cU()
  {
    return this.nS;
  }
  
  boolean cV()
  {
    return this.nx;
  }
  
  public boolean cW()
  {
    return this.ny;
  }
  
  public final void cX()
  {
    if (!this.nK)
    {
      this.nK = true;
      this.nL = false;
      this.nM = false;
    }
  }
  
  public final void cY()
  {
    AppMethodBeat.i(201437);
    this.nK = false;
    if (this.nL)
    {
      this.nL = false;
      L(this.nM);
    }
    AppMethodBeat.o(201437);
  }
  
  final void cZ()
  {
    AppMethodBeat.i(201443);
    this.nB = true;
    L(true);
    AppMethodBeat.o(201443);
  }
  
  public void clear()
  {
    AppMethodBeat.i(201289);
    if (this.nR != null) {
      g(this.nR);
    }
    this.mItems.clear();
    L(true);
    AppMethodBeat.o(201289);
  }
  
  public void clearHeader()
  {
    AppMethodBeat.i(201483);
    this.nI = null;
    this.nH = null;
    this.nJ = null;
    L(false);
    AppMethodBeat.o(201483);
  }
  
  public void close()
  {
    AppMethodBeat.i(201417);
    K(true);
    AppMethodBeat.o(201417);
  }
  
  protected final h d(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201491);
    a(0, paramCharSequence, 0, null, null);
    AppMethodBeat.o(201491);
    return this;
  }
  
  boolean d(h paramh, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(201381);
    if ((this.nz != null) && (this.nz.a(paramh, paramMenuItem)))
    {
      AppMethodBeat.o(201381);
      return true;
    }
    AppMethodBeat.o(201381);
    return false;
  }
  
  final void da()
  {
    AppMethodBeat.i(201449);
    this.nE = true;
    L(true);
    AppMethodBeat.o(201449);
  }
  
  public final ArrayList<j> db()
  {
    AppMethodBeat.i(201457);
    if (!this.nB)
    {
      localObject = this.nA;
      AppMethodBeat.o(201457);
      return localObject;
    }
    this.nA.clear();
    int j = this.mItems.size();
    int i = 0;
    while (i < j)
    {
      localObject = (j)this.mItems.get(i);
      if (((j)localObject).isVisible()) {
        this.nA.add(localObject);
      }
      i += 1;
    }
    this.nB = false;
    this.nE = true;
    Object localObject = this.nA;
    AppMethodBeat.o(201457);
    return localObject;
  }
  
  public final void dc()
  {
    AppMethodBeat.i(201466);
    ArrayList localArrayList = db();
    if (!this.nE)
    {
      AppMethodBeat.o(201466);
      return;
    }
    Object localObject = this.nQ.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      o localo = (o)localWeakReference.get();
      if (localo == null) {
        this.nQ.remove(localWeakReference);
      } else {
        i = localo.cL() | i;
      }
    }
    if (i != 0)
    {
      this.nC.clear();
      this.nD.clear();
      int k = localArrayList.size();
      i = 0;
      if (i < k)
      {
        localObject = (j)localArrayList.get(i);
        if (((j)localObject).dj()) {
          this.nC.add(localObject);
        }
        for (;;)
        {
          int j;
          i += 1;
          break;
          this.nD.add(localObject);
        }
      }
    }
    else
    {
      this.nC.clear();
      this.nD.clear();
      this.nD.addAll(db());
    }
    this.nE = false;
    AppMethodBeat.o(201466);
  }
  
  public final ArrayList<j> dd()
  {
    AppMethodBeat.i(201472);
    dc();
    ArrayList localArrayList = this.nD;
    AppMethodBeat.o(201472);
    return localArrayList;
  }
  
  public h de()
  {
    return this;
  }
  
  protected final h e(Drawable paramDrawable)
  {
    AppMethodBeat.i(201507);
    a(0, null, 0, paramDrawable, null);
    AppMethodBeat.o(201507);
    return this;
  }
  
  public final void f(Bundle paramBundle)
  {
    AppMethodBeat.i(201105);
    if (!this.nQ.isEmpty())
    {
      SparseArray localSparseArray = new SparseArray();
      Iterator localIterator = this.nQ.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        o localo = (o)((WeakReference)localObject).get();
        if (localo == null)
        {
          this.nQ.remove(localObject);
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
    AppMethodBeat.o(201105);
  }
  
  public boolean f(j paramj)
  {
    AppMethodBeat.i(201539);
    if (this.nQ.isEmpty())
    {
      AppMethodBeat.o(201539);
      return false;
    }
    cX();
    Iterator localIterator = this.nQ.iterator();
    boolean bool = false;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        o localo = (o)localWeakReference.get();
        if (localo == null)
        {
          this.nQ.remove(localWeakReference);
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
      cY();
      if (bool) {
        this.nR = paramj;
      }
      AppMethodBeat.o(201539);
      return bool;
      break;
    }
  }
  
  public MenuItem findItem(int paramInt)
  {
    AppMethodBeat.i(201329);
    int j = size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (j)this.mItems.get(i);
      if (((j)localObject).getItemId() == paramInt)
      {
        AppMethodBeat.o(201329);
        return localObject;
      }
      if (((j)localObject).hasSubMenu())
      {
        localObject = ((j)localObject).getSubMenu().findItem(paramInt);
        if (localObject != null)
        {
          AppMethodBeat.o(201329);
          return localObject;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(201329);
    return null;
  }
  
  public final void g(Bundle paramBundle)
  {
    AppMethodBeat.i(201115);
    paramBundle = paramBundle.getSparseParcelableArray("android:menu:presenters");
    if ((paramBundle == null) || (this.nQ.isEmpty()))
    {
      AppMethodBeat.o(201115);
      return;
    }
    Iterator localIterator = this.nQ.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      o localo = (o)((WeakReference)localObject).get();
      if (localo == null)
      {
        this.nQ.remove(localObject);
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
    AppMethodBeat.o(201115);
  }
  
  public boolean g(j paramj)
  {
    AppMethodBeat.i(201545);
    if ((this.nQ.isEmpty()) || (this.nR != paramj))
    {
      AppMethodBeat.o(201545);
      return false;
    }
    cX();
    Iterator localIterator = this.nQ.iterator();
    boolean bool = false;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        o localo = (o)localWeakReference.get();
        if (localo == null)
        {
          this.nQ.remove(localWeakReference);
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
      cY();
      if (bool) {
        this.nR = null;
      }
      AppMethodBeat.o(201545);
      return bool;
      break;
    }
  }
  
  public MenuItem getItem(int paramInt)
  {
    AppMethodBeat.i(201346);
    MenuItem localMenuItem = (MenuItem)this.mItems.get(paramInt);
    AppMethodBeat.o(201346);
    return localMenuItem;
  }
  
  public final void h(Bundle paramBundle)
  {
    AppMethodBeat.i(201124);
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
        ((u)localMenuItem.getSubMenu()).h(paramBundle);
      }
      i += 1;
      localObject1 = localObject3;
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(cT(), localObject1);
    }
    AppMethodBeat.o(201124);
  }
  
  public boolean hasVisibleItems()
  {
    AppMethodBeat.i(201320);
    if (this.nT)
    {
      AppMethodBeat.o(201320);
      return true;
    }
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (((j)this.mItems.get(i)).isVisible())
      {
        AppMethodBeat.o(201320);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(201320);
    return false;
  }
  
  protected final h i(View paramView)
  {
    AppMethodBeat.i(201525);
    a(0, null, 0, null, paramView);
    AppMethodBeat.o(201525);
    return this;
  }
  
  public final void i(Bundle paramBundle)
  {
    AppMethodBeat.i(201137);
    if (paramBundle == null)
    {
      AppMethodBeat.o(201137);
      return;
    }
    SparseArray localSparseArray = paramBundle.getSparseParcelableArray(cT());
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
        ((u)localMenuItem.getSubMenu()).i(paramBundle);
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
    AppMethodBeat.o(201137);
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(201354);
    if (a(paramInt, paramKeyEvent) != null)
    {
      AppMethodBeat.o(201354);
      return true;
    }
    AppMethodBeat.o(201354);
    return false;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201398);
    boolean bool = a(findItem(paramInt1), null, paramInt2);
    AppMethodBeat.o(201398);
    return bool;
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    AppMethodBeat.i(201389);
    paramKeyEvent = a(paramInt1, paramKeyEvent);
    boolean bool = false;
    if (paramKeyEvent != null) {
      bool = a(paramKeyEvent, null, paramInt2);
    }
    if ((paramInt2 & 0x2) != 0) {
      K(true);
    }
    AppMethodBeat.o(201389);
    return bool;
  }
  
  public void removeGroup(int paramInt)
  {
    AppMethodBeat.i(201279);
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
            l(i, false);
            j += 1;
            continue;
            i += 1;
            break;
            i = -1;
            break label36;
          }
        }
        L(true);
      }
    }
    AppMethodBeat.o(201279);
  }
  
  public void removeItem(int paramInt)
  {
    AppMethodBeat.i(201267);
    int j = size();
    int i = 0;
    if (i < j) {
      if (((j)this.mItems.get(i)).getItemId() != paramInt) {}
    }
    for (;;)
    {
      l(i, true);
      AppMethodBeat.o(201267);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(201296);
    int j = this.mItems.size();
    int i = 0;
    while (i < j)
    {
      j localj = (j)this.mItems.get(i);
      if (localj.getGroupId() == paramInt)
      {
        localj.M(paramBoolean2);
        localj.setCheckable(paramBoolean1);
      }
      i += 1;
    }
    AppMethodBeat.o(201296);
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    this.nS = paramBoolean;
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(201314);
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
    AppMethodBeat.o(201314);
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(201305);
    int k = this.mItems.size();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      j localj = (j)this.mItems.get(j);
      if ((localj.getGroupId() != paramInt) || (!localj.O(paramBoolean))) {
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
        L(true);
      }
      AppMethodBeat.o(201305);
      return;
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    AppMethodBeat.i(201361);
    this.nx = paramBoolean;
    L(false);
    AppMethodBeat.o(201361);
  }
  
  public int size()
  {
    AppMethodBeat.i(201339);
    int i = this.mItems.size();
    AppMethodBeat.o(201339);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.h
 * JD-Core Version:    0.7.0.1
 */