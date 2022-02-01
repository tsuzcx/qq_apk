package android.support.v7.view.menu;

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
import android.support.v4.a.a.a;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h
  implements a
{
  private static final int[] aga = { 1, 4, 5, 3, 2, 0 };
  private boolean agb;
  private boolean agc;
  public a agd;
  private ArrayList<j> age;
  private boolean agf;
  public ArrayList<j> agg;
  private ArrayList<j> agh;
  private boolean agi;
  public int agj = 0;
  private ContextMenu.ContextMenuInfo agk;
  CharSequence agl;
  Drawable agm;
  View agn;
  private boolean ago = false;
  private boolean agp = false;
  private boolean agq = false;
  boolean agr = false;
  private boolean ags = false;
  private ArrayList<j> agt = new ArrayList();
  private CopyOnWriteArrayList<WeakReference<o>> agu = new CopyOnWriteArrayList();
  j agv;
  private boolean agw = false;
  public boolean agx;
  protected final Context mContext;
  ArrayList<j> mItems;
  private final Resources mResources;
  
  public h(Context paramContext)
  {
    this.mContext = paramContext;
    this.mResources = paramContext.getResources();
    this.mItems = new ArrayList();
    this.age = new ArrayList();
    this.agf = true;
    this.agg = new ArrayList();
    this.agh = new ArrayList();
    this.agi = true;
    if ((this.mResources.getConfiguration().keyboard != 1) && (android.support.v4.view.u.d(ViewConfiguration.get(this.mContext), this.mContext))) {}
    for (;;)
    {
      this.agc = bool;
      return;
      bool = false;
    }
  }
  
  private j a(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = this.agt;
    localArrayList.clear();
    a(localArrayList, paramInt, paramKeyEvent);
    if (localArrayList.isEmpty())
    {
      paramKeyEvent = null;
      return paramKeyEvent;
    }
    int k = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    paramKeyEvent.getKeyData(localKeyData);
    int m = localArrayList.size();
    if (m == 1) {
      return (j)localArrayList.get(0);
    }
    boolean bool = hP();
    int i = 0;
    label84:
    if (i < m)
    {
      j localj = (j)localArrayList.get(i);
      if (bool) {}
      for (int j = localj.getAlphabeticShortcut();; j = localj.getNumericShortcut())
      {
        if (j == localKeyData.meta[0])
        {
          paramKeyEvent = localj;
          if ((k & 0x2) == 0) {
            break;
          }
        }
        if (j == localKeyData.meta[2])
        {
          paramKeyEvent = localj;
          if ((k & 0x2) != 0) {
            break;
          }
        }
        if ((bool) && (j == 8))
        {
          paramKeyEvent = localj;
          if (paramInt == 67) {
            break;
          }
        }
        i += 1;
        break label84;
      }
    }
    return null;
  }
  
  private void a(List<j> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = hP();
    int m = paramKeyEvent.getModifiers();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67)) {
      return;
    }
    int n = this.mItems.size();
    int i = 0;
    label49:
    j localj;
    int j;
    if (i < n)
    {
      localj = (j)this.mItems.get(i);
      if (localj.hasSubMenu()) {
        ((h)localj.getSubMenu()).a(paramList, paramInt, paramKeyEvent);
      }
      if (!bool) {
        break label210;
      }
      j = localj.getAlphabeticShortcut();
      label104:
      if (!bool) {
        break label220;
      }
      k = localj.getAlphabeticModifiers();
      label116:
      if ((m & 0x1100F) != (k & 0x1100F)) {
        break label230;
      }
    }
    label210:
    label220:
    label230:
    for (int k = 1;; k = 0)
    {
      if ((k != 0) && (j != 0) && ((j == localKeyData.meta[0]) || (j == localKeyData.meta[2]) || ((bool) && (j == 8) && (paramInt == 67))) && (localj.isEnabled())) {
        paramList.add(localj);
      }
      i += 1;
      break label49;
      break;
      j = localj.getNumericShortcut();
      break label104;
      k = localj.getNumericModifiers();
      break label116;
    }
  }
  
  private boolean a(u paramu, o paramo)
  {
    boolean bool = false;
    if (this.agu.isEmpty()) {
      return false;
    }
    if (paramo != null) {
      bool = paramo.a(paramu);
    }
    paramo = this.agu.iterator();
    while (paramo.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramo.next();
      o localo = (o)localWeakReference.get();
      if (localo == null)
      {
        this.agu.remove(localWeakReference);
      }
      else
      {
        if (bool) {
          break label100;
        }
        bool = localo.a(paramu);
      }
    }
    label100:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  private static int b(ArrayList<j> paramArrayList, int paramInt)
  {
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      if (((j)paramArrayList.get(i)).aet <= paramInt) {
        return i + 1;
      }
      i -= 1;
    }
    return 0;
  }
  
  private void dispatchSaveInstanceState(Bundle paramBundle)
  {
    if (this.agu.isEmpty()) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    Iterator localIterator = this.agu.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      o localo = (o)((WeakReference)localObject).get();
      if (localo == null)
      {
        this.agu.remove(localObject);
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
  
  private void g(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= this.mItems.size())) {}
    do
    {
      return;
      this.mItems.remove(paramInt);
    } while (!paramBoolean);
    r(true);
  }
  
  protected MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i = (0xFFFF0000 & paramInt3) >> 16;
    if ((i < 0) || (i >= aga.length)) {
      throw new IllegalArgumentException("order does not contain a valid category.");
    }
    i = aga[i] << 16 | 0xFFFF & paramInt3;
    paramCharSequence = new j(this, paramInt1, paramInt2, paramInt3, i, paramCharSequence, this.agj);
    if (this.agk != null) {
      paramCharSequence.agI = this.agk;
    }
    this.mItems.add(b(this.mItems, i), paramCharSequence);
    r(true);
    return paramCharSequence;
  }
  
  final void a(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    Resources localResources = this.mResources;
    if (paramView != null)
    {
      this.agn = paramView;
      this.agl = null;
      this.agm = null;
      r(false);
      return;
    }
    if (paramInt1 > 0)
    {
      this.agl = localResources.getText(paramInt1);
      label47:
      if (paramInt2 <= 0) {
        break label83;
      }
      this.agm = android.support.v4.content.b.l(this.mContext, paramInt2);
    }
    for (;;)
    {
      this.agn = null;
      break;
      if (paramCharSequence == null) {
        break label47;
      }
      this.agl = paramCharSequence;
      break label47;
      label83:
      if (paramDrawable != null) {
        this.agm = paramDrawable;
      }
    }
  }
  
  public void a(a parama)
  {
    this.agd = parama;
  }
  
  public final void a(o paramo)
  {
    a(paramo, this.mContext);
  }
  
  public final void a(o paramo, Context paramContext)
  {
    this.agu.add(new WeakReference(paramo));
    paramo.a(paramContext, this);
    this.agi = true;
  }
  
  public final boolean a(MenuItem paramMenuItem, o paramo, int paramInt)
  {
    boolean bool2 = false;
    Object localObject = (j)paramMenuItem;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (((j)localObject).isEnabled()) {
        break label33;
      }
      bool1 = bool2;
    }
    label33:
    label101:
    do
    {
      return bool1;
      bool1 = ((j)localObject).hZ();
      paramMenuItem = ((j)localObject).agF;
      if ((paramMenuItem != null) && (paramMenuItem.hasSubMenu())) {}
      for (int i = 1;; i = 0)
      {
        if (!((j)localObject).ij()) {
          break label101;
        }
        bool2 = ((j)localObject).expandActionView() | bool1;
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        ab(true);
        return bool2;
      }
      if ((!((j)localObject).hasSubMenu()) && (i == 0)) {
        break;
      }
      if ((paramInt & 0x4) == 0) {
        ab(false);
      }
      if (!((j)localObject).hasSubMenu()) {
        ((j)localObject).b(new u(this.mContext, this, (j)localObject));
      }
      localObject = (u)((j)localObject).getSubMenu();
      if (i != 0) {
        paramMenuItem.onPrepareSubMenu((SubMenu)localObject);
      }
      bool2 = a((u)localObject, paramo) | bool1;
      bool1 = bool2;
    } while (bool2);
    ab(true);
    return bool2;
    if ((paramInt & 0x1) == 0) {
      ab(true);
    }
    return bool1;
  }
  
  public final void ab(boolean paramBoolean)
  {
    if (this.ags) {
      return;
    }
    this.ags = true;
    Iterator localIterator = this.agu.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if (localo == null) {
        this.agu.remove(localWeakReference);
      } else {
        localo.a(this, paramBoolean);
      }
    }
    this.ags = false;
  }
  
  public MenuItem add(int paramInt)
  {
    return a(0, 0, 0, this.mResources.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, this.mResources.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return a(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = this.mContext.getPackageManager();
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i;
    label52:
    ResolveInfo localResolveInfo;
    if (localList != null)
    {
      i = localList.size();
      if ((paramInt4 & 0x1) == 0) {
        removeGroup(paramInt1);
      }
      paramInt4 = 0;
      if (paramInt4 >= i) {
        break label214;
      }
      localResolveInfo = (ResolveInfo)localList.get(paramInt4);
      if (localResolveInfo.specificIndex >= 0) {
        break label201;
      }
    }
    label201:
    for (paramComponentName = paramIntent;; paramComponentName = paramArrayOfIntent[localResolveInfo.specificIndex])
    {
      paramComponentName = new Intent(paramComponentName);
      paramComponentName.setComponent(new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name));
      paramComponentName = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(paramComponentName);
      if ((paramArrayOfMenuItem != null) && (localResolveInfo.specificIndex >= 0)) {
        paramArrayOfMenuItem[localResolveInfo.specificIndex] = paramComponentName;
      }
      paramInt4 += 1;
      break label52;
      i = 0;
      break;
    }
    label214:
    return i;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, this.mResources.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, this.mResources.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = (j)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    u localu = new u(this.mContext, this, paramCharSequence);
    paramCharSequence.b(localu);
    return localu;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  public final void b(o paramo)
  {
    Iterator localIterator = this.agu.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if ((localo == null) || (localo == paramo)) {
        this.agu.remove(localWeakReference);
      }
    }
  }
  
  public void clear()
  {
    if (this.agv != null) {
      h(this.agv);
    }
    this.mItems.clear();
    r(true);
  }
  
  public void clearHeader()
  {
    this.agm = null;
    this.agl = null;
    this.agn = null;
    r(false);
  }
  
  public void close()
  {
    ab(true);
  }
  
  boolean d(h paramh, MenuItem paramMenuItem)
  {
    return (this.agd != null) && (this.agd.a(paramh, paramMenuItem));
  }
  
  public final void dispatchRestoreInstanceState(Bundle paramBundle)
  {
    paramBundle = paramBundle.getSparseParcelableArray("android:menu:presenters");
    if ((paramBundle == null) || (this.agu.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.agu.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        o localo = (o)((WeakReference)localObject).get();
        if (localo == null)
        {
          this.agu.remove(localObject);
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
    }
  }
  
  public final void e(Bundle paramBundle)
  {
    dispatchSaveInstanceState(paramBundle);
  }
  
  public final void f(Bundle paramBundle)
  {
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
        ((u)localMenuItem.getSubMenu()).f(paramBundle);
      }
      i += 1;
      localObject1 = localObject3;
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(hN(), localObject1);
    }
  }
  
  public MenuItem findItem(int paramInt)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (j)this.mItems.get(i);
      if (((j)localObject).getItemId() == paramInt) {}
      MenuItem localMenuItem;
      do
      {
        return localObject;
        if (!((j)localObject).hasSubMenu()) {
          break;
        }
        localMenuItem = ((j)localObject).getSubMenu().findItem(paramInt);
        localObject = localMenuItem;
      } while (localMenuItem != null);
      i += 1;
    }
    return null;
  }
  
  public final void g(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      int i;
      do
      {
        return;
        SparseArray localSparseArray = paramBundle.getSparseParcelableArray(hN());
        int j = size();
        i = 0;
        while (i < j)
        {
          MenuItem localMenuItem = getItem(i);
          View localView = localMenuItem.getActionView();
          if ((localView != null) && (localView.getId() != -1)) {
            localView.restoreHierarchyState(localSparseArray);
          }
          if (localMenuItem.hasSubMenu()) {
            ((u)localMenuItem.getSubMenu()).g(paramBundle);
          }
          i += 1;
        }
        i = paramBundle.getInt("android:menu:expandedactionview");
      } while (i <= 0);
      paramBundle = findItem(i);
    } while (paramBundle == null);
    paramBundle.expandActionView();
  }
  
  public boolean g(j paramj)
  {
    boolean bool2 = false;
    if (this.agu.isEmpty()) {
      return bool2;
    }
    hR();
    Iterator localIterator = this.agu.iterator();
    boolean bool1 = false;
    for (;;)
    {
      label29:
      if (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        o localo = (o)localWeakReference.get();
        if (localo == null)
        {
          this.agu.remove(localWeakReference);
        }
        else
        {
          bool1 = localo.b(paramj);
          if (!bool1) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      hS();
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.agv = paramj;
      return bool1;
      break label29;
    }
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.mItems.get(paramInt);
  }
  
  public boolean h(j paramj)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!this.agu.isEmpty())
    {
      if (this.agv != paramj) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    hR();
    Iterator localIterator = this.agu.iterator();
    bool1 = false;
    for (;;)
    {
      label41:
      if (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        o localo = (o)localWeakReference.get();
        if (localo == null)
        {
          this.agu.remove(localWeakReference);
        }
        else
        {
          bool1 = localo.c(paramj);
          if (!bool1) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      hS();
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.agv = null;
      return bool1;
      break label41;
    }
  }
  
  protected String hN()
  {
    return "android:menu:actionviewstates";
  }
  
  public boolean hO()
  {
    return this.agw;
  }
  
  boolean hP()
  {
    return this.agb;
  }
  
  public boolean hQ()
  {
    return this.agc;
  }
  
  public final void hR()
  {
    if (!this.ago)
    {
      this.ago = true;
      this.agp = false;
      this.agq = false;
    }
  }
  
  public final void hS()
  {
    this.ago = false;
    if (this.agp)
    {
      this.agp = false;
      r(this.agq);
    }
  }
  
  final void hT()
  {
    this.agf = true;
    r(true);
  }
  
  final void hU()
  {
    this.agi = true;
    r(true);
  }
  
  public final ArrayList<j> hV()
  {
    if (!this.agf) {
      return this.age;
    }
    this.age.clear();
    int j = this.mItems.size();
    int i = 0;
    while (i < j)
    {
      j localj = (j)this.mItems.get(i);
      if (localj.isVisible()) {
        this.age.add(localj);
      }
      i += 1;
    }
    this.agf = false;
    this.agi = true;
    return this.age;
  }
  
  public final void hW()
  {
    ArrayList localArrayList = hV();
    if (!this.agi) {
      return;
    }
    Object localObject = this.agu.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      o localo = (o)localWeakReference.get();
      if (localo == null) {
        this.agu.remove(localWeakReference);
      } else {
        i = localo.bD() | i;
      }
    }
    if (i != 0)
    {
      this.agg.clear();
      this.agh.clear();
      int k = localArrayList.size();
      i = 0;
      if (i < k)
      {
        localObject = (j)localArrayList.get(i);
        if (((j)localObject).jdMethod_if()) {
          this.agg.add(localObject);
        }
        for (;;)
        {
          int j;
          i += 1;
          break;
          this.agh.add(localObject);
        }
      }
    }
    else
    {
      this.agg.clear();
      this.agh.clear();
      this.agh.addAll(hV());
    }
    this.agi = false;
  }
  
  public final ArrayList<j> hX()
  {
    hW();
    return this.agh;
  }
  
  public h hY()
  {
    return this;
  }
  
  public boolean hasVisibleItems()
  {
    if (this.agx) {
      return true;
    }
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (((j)this.mItems.get(i)).isVisible()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return a(paramInt, paramKeyEvent) != null;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return a(findItem(paramInt1), null, paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    paramKeyEvent = a(paramInt1, paramKeyEvent);
    boolean bool = false;
    if (paramKeyEvent != null) {
      bool = a(paramKeyEvent, null, paramInt2);
    }
    if ((paramInt2 & 0x2) != 0) {
      ab(true);
    }
    return bool;
  }
  
  public void r(boolean paramBoolean)
  {
    if (!this.ago)
    {
      if (paramBoolean)
      {
        this.agf = true;
        this.agi = true;
      }
      if (!this.agu.isEmpty())
      {
        hR();
        Iterator localIterator = this.agu.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          o localo = (o)localWeakReference.get();
          if (localo == null) {
            this.agu.remove(localWeakReference);
          } else {
            localo.p(paramBoolean);
          }
        }
        hS();
      }
    }
    do
    {
      return;
      this.agp = true;
    } while (!paramBoolean);
    this.agq = true;
  }
  
  public void removeGroup(int paramInt)
  {
    int j = size();
    int i = 0;
    if (i < j) {
      if (((j)this.mItems.get(i)).getGroupId() != paramInt) {}
    }
    for (;;)
    {
      label30:
      if (i >= 0)
      {
        int k = this.mItems.size();
        j = 0;
        for (;;)
        {
          if ((j < k - i) && (((j)this.mItems.get(i)).getGroupId() == paramInt))
          {
            g(i, false);
            j += 1;
            continue;
            i += 1;
            break;
            i = -1;
            break label30;
          }
        }
        r(true);
      }
    }
  }
  
  public void removeItem(int paramInt)
  {
    int j = size();
    int i = 0;
    if (i < j) {
      if (((j)this.mItems.get(i)).getItemId() != paramInt) {}
    }
    for (;;)
    {
      g(i, true);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = this.mItems.size();
    int i = 0;
    while (i < j)
    {
      j localj = (j)this.mItems.get(i);
      if (localj.getGroupId() == paramInt)
      {
        localj.ac(paramBoolean2);
        localj.setCheckable(paramBoolean1);
      }
      i += 1;
    }
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    this.agw = paramBoolean;
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
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
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int k = this.mItems.size();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      j localj = (j)this.mItems.get(j);
      if ((localj.getGroupId() != paramInt) || (!localj.ae(paramBoolean))) {
        break label74;
      }
      i = 1;
    }
    label74:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0) {
        r(true);
      }
      return;
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.agb = paramBoolean;
    r(false);
  }
  
  public int size()
  {
    return this.mItems.size();
  }
  
  public static abstract interface a
  {
    public abstract boolean a(h paramh, MenuItem paramMenuItem);
    
    public abstract void b(h paramh);
  }
  
  public static abstract interface b
  {
    public abstract boolean f(j paramj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.h
 * JD-Core Version:    0.7.0.1
 */