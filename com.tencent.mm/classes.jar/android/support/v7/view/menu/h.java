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
import android.support.v4.b.a.a;
import android.support.v7.a.a.b;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h
  implements a
{
  private static final int[] Vu = { 1, 4, 5, 3, 2, 0 };
  public ArrayList<j> VA;
  private ArrayList<j> VB;
  private boolean VC;
  public int VD = 0;
  private ContextMenu.ContextMenuInfo VE;
  CharSequence VF;
  Drawable VG;
  View VH;
  private boolean VI = false;
  private boolean VJ = false;
  private boolean VK = false;
  boolean VL = false;
  private boolean VM = false;
  private ArrayList<j> VN = new ArrayList();
  private CopyOnWriteArrayList<WeakReference<o>> VO = new CopyOnWriteArrayList();
  j VP;
  public boolean VQ;
  private boolean Vv;
  private boolean Vw;
  public a Vx;
  private ArrayList<j> Vy;
  private boolean Vz;
  ArrayList<j> dU;
  public final Context mContext;
  private final Resources mResources;
  
  public h(Context paramContext)
  {
    this.mContext = paramContext;
    this.mResources = paramContext.getResources();
    this.dU = new ArrayList();
    this.Vy = new ArrayList();
    this.Vz = true;
    this.VA = new ArrayList();
    this.VB = new ArrayList();
    this.VC = true;
    if ((this.mResources.getConfiguration().keyboard != 1) && (this.mResources.getBoolean(a.b.abc_config_showMenuShortcutsWhenKeyboardPresent))) {}
    for (;;)
    {
      this.Vw = bool;
      return;
      bool = false;
    }
  }
  
  private j a(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = this.VN;
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
    boolean bool = ff();
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
    boolean bool = ff();
    int m = paramKeyEvent.getModifiers();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67)) {
      return;
    }
    int n = this.dU.size();
    int i = 0;
    label49:
    j localj;
    int j;
    if (i < n)
    {
      localj = (j)this.dU.get(i);
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
  
  private static int b(ArrayList<j> paramArrayList, int paramInt)
  {
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      if (((j)paramArrayList.get(i)).TU <= paramInt) {
        return i + 1;
      }
      i -= 1;
    }
    return 0;
  }
  
  private void n(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= this.dU.size())) {}
    do
    {
      return;
      this.dU.remove(paramInt);
    } while (!paramBoolean);
    q(true);
  }
  
  public final void T(boolean paramBoolean)
  {
    if (this.VM) {
      return;
    }
    this.VM = true;
    Iterator localIterator = this.VO.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if (localo == null) {
        this.VO.remove(localWeakReference);
      } else {
        localo.a(this, paramBoolean);
      }
    }
    this.VM = false;
  }
  
  public MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i = (0xFFFF0000 & paramInt3) >> 16;
    if ((i < 0) || (i >= Vu.length)) {
      throw new IllegalArgumentException("order does not contain a valid category.");
    }
    i = Vu[i] << 16 | 0xFFFF & paramInt3;
    paramCharSequence = new j(this, paramInt1, paramInt2, paramInt3, i, paramCharSequence, this.VD);
    if (this.VE != null) {
      paramCharSequence.Wb = this.VE;
    }
    this.dU.add(b(this.dU, i), paramCharSequence);
    q(true);
    return paramCharSequence;
  }
  
  final void a(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    Resources localResources = this.mResources;
    if (paramView != null)
    {
      this.VH = paramView;
      this.VF = null;
      this.VG = null;
      q(false);
      return;
    }
    if (paramInt1 > 0)
    {
      this.VF = localResources.getText(paramInt1);
      label47:
      if (paramInt2 <= 0) {
        break label83;
      }
      this.VG = android.support.v4.content.b.g(this.mContext, paramInt2);
    }
    for (;;)
    {
      this.VH = null;
      break;
      if (paramCharSequence == null) {
        break label47;
      }
      this.VF = paramCharSequence;
      break label47;
      label83:
      if (paramDrawable != null) {
        this.VG = paramDrawable;
      }
    }
  }
  
  public void a(a parama)
  {
    this.Vx = parama;
  }
  
  public final void a(o paramo)
  {
    a(paramo, this.mContext);
  }
  
  public final void a(o paramo, Context paramContext)
  {
    this.VO.add(new WeakReference(paramo));
    paramo.a(paramContext, this);
    this.VC = true;
  }
  
  public final boolean a(MenuItem paramMenuItem, o paramo, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    paramMenuItem = (j)paramMenuItem;
    if ((paramMenuItem == null) || (!paramMenuItem.isEnabled())) {
      bool1 = false;
    }
    boolean bool3;
    Object localObject;
    label95:
    do
    {
      return bool1;
      bool3 = paramMenuItem.fp();
      localObject = paramMenuItem.VY;
      if ((localObject != null) && (((android.support.v4.view.b)localObject).hasSubMenu())) {}
      for (int i = 1;; i = 0)
      {
        if (!paramMenuItem.fw()) {
          break label95;
        }
        bool2 = paramMenuItem.expandActionView() | bool3;
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        T(true);
        return bool2;
      }
      if ((!paramMenuItem.hasSubMenu()) && (i == 0)) {
        break label289;
      }
      if ((paramInt & 0x4) == 0) {
        T(false);
      }
      if (!paramMenuItem.hasSubMenu()) {
        paramMenuItem.b(new u(this.mContext, this, paramMenuItem));
      }
      paramMenuItem = (u)paramMenuItem.getSubMenu();
      if (i != 0) {
        ((android.support.v4.view.b)localObject).onPrepareSubMenu(paramMenuItem);
      }
      if (!this.VO.isEmpty()) {
        break;
      }
      bool2 = bool3 | bool1;
      bool1 = bool2;
    } while (bool2);
    T(true);
    return bool2;
    bool1 = bool2;
    if (paramo != null) {
      bool1 = paramo.a(paramMenuItem);
    }
    paramo = this.VO.iterator();
    label220:
    while (paramo.hasNext())
    {
      localObject = (WeakReference)paramo.next();
      o localo = (o)((WeakReference)localObject).get();
      if (localo == null)
      {
        this.VO.remove(localObject);
      }
      else
      {
        if (bool1) {
          break label303;
        }
        bool1 = localo.a(paramMenuItem);
      }
    }
    label289:
    label303:
    for (;;)
    {
      break label220;
      break;
      if ((paramInt & 0x1) == 0) {
        T(true);
      }
      return bool3;
    }
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
    Iterator localIterator = this.VO.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      o localo = (o)localWeakReference.get();
      if ((localo == null) || (localo == paramo)) {
        this.VO.remove(localWeakReference);
      }
    }
  }
  
  public final void c(Bundle paramBundle)
  {
    if (!this.VO.isEmpty())
    {
      SparseArray localSparseArray = new SparseArray();
      Iterator localIterator = this.VO.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        o localo = (o)((WeakReference)localObject).get();
        if (localo == null)
        {
          this.VO.remove(localObject);
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
  }
  
  public void clear()
  {
    if (this.VP != null) {
      h(this.VP);
    }
    this.dU.clear();
    q(true);
  }
  
  public void clearHeader()
  {
    this.VG = null;
    this.VF = null;
    this.VH = null;
    q(false);
  }
  
  public void close()
  {
    T(true);
  }
  
  public final void d(Bundle paramBundle)
  {
    paramBundle = paramBundle.getSparseParcelableArray("android:menu:presenters");
    if ((paramBundle == null) || (this.VO.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.VO.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        o localo = (o)((WeakReference)localObject).get();
        if (localo == null)
        {
          this.VO.remove(localObject);
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
  
  boolean d(h paramh, MenuItem paramMenuItem)
  {
    return (this.Vx != null) && (this.Vx.a(paramh, paramMenuItem));
  }
  
  public final void e(Bundle paramBundle)
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
        ((u)localMenuItem.getSubMenu()).e(paramBundle);
      }
      i += 1;
      localObject1 = localObject3;
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(fe(), localObject1);
    }
  }
  
  public final void f(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      int i;
      do
      {
        return;
        SparseArray localSparseArray = paramBundle.getSparseParcelableArray(fe());
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
            ((u)localMenuItem.getSubMenu()).f(paramBundle);
          }
          i += 1;
        }
        i = paramBundle.getInt("android:menu:expandedactionview");
      } while (i <= 0);
      paramBundle = findItem(i);
    } while (paramBundle == null);
    paramBundle.expandActionView();
  }
  
  protected String fe()
  {
    return "android:menu:actionviewstates";
  }
  
  boolean ff()
  {
    return this.Vv;
  }
  
  public boolean fg()
  {
    return this.Vw;
  }
  
  public final void fh()
  {
    if (!this.VI)
    {
      this.VI = true;
      this.VJ = false;
      this.VK = false;
    }
  }
  
  public final void fi()
  {
    this.VI = false;
    if (this.VJ)
    {
      this.VJ = false;
      q(this.VK);
    }
  }
  
  public MenuItem findItem(int paramInt)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (j)this.dU.get(i);
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
  
  final void fj()
  {
    this.Vz = true;
    q(true);
  }
  
  final void fk()
  {
    this.VC = true;
    q(true);
  }
  
  public final ArrayList<j> fl()
  {
    if (!this.Vz) {
      return this.Vy;
    }
    this.Vy.clear();
    int j = this.dU.size();
    int i = 0;
    while (i < j)
    {
      j localj = (j)this.dU.get(i);
      if (localj.isVisible()) {
        this.Vy.add(localj);
      }
      i += 1;
    }
    this.Vz = false;
    this.VC = true;
    return this.Vy;
  }
  
  public final void fm()
  {
    ArrayList localArrayList = fl();
    if (!this.VC) {
      return;
    }
    Object localObject = this.VO.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      o localo = (o)localWeakReference.get();
      if (localo == null) {
        this.VO.remove(localWeakReference);
      } else {
        i = localo.V() | i;
      }
    }
    if (i != 0)
    {
      this.VA.clear();
      this.VB.clear();
      int k = localArrayList.size();
      i = 0;
      if (i < k)
      {
        localObject = (j)localArrayList.get(i);
        if (((j)localObject).ft()) {
          this.VA.add(localObject);
        }
        for (;;)
        {
          int j;
          i += 1;
          break;
          this.VB.add(localObject);
        }
      }
    }
    else
    {
      this.VA.clear();
      this.VB.clear();
      this.VB.addAll(fl());
    }
    this.VC = false;
  }
  
  public final ArrayList<j> fn()
  {
    fm();
    return this.VB;
  }
  
  public h fo()
  {
    return this;
  }
  
  public boolean g(j paramj)
  {
    boolean bool2 = false;
    if (this.VO.isEmpty()) {
      return bool2;
    }
    fh();
    Iterator localIterator = this.VO.iterator();
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
          this.VO.remove(localWeakReference);
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
      fi();
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.VP = paramj;
      return bool1;
      break label29;
    }
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.dU.get(paramInt);
  }
  
  public boolean h(j paramj)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!this.VO.isEmpty())
    {
      if (this.VP != paramj) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    fh();
    Iterator localIterator = this.VO.iterator();
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
          this.VO.remove(localWeakReference);
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
      fi();
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.VP = null;
      return bool1;
      break label41;
    }
  }
  
  public boolean hasVisibleItems()
  {
    if (this.VQ) {
      return true;
    }
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (((j)this.dU.get(i)).isVisible()) {
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
      T(true);
    }
    return bool;
  }
  
  public void q(boolean paramBoolean)
  {
    if (!this.VI)
    {
      if (paramBoolean)
      {
        this.Vz = true;
        this.VC = true;
      }
      if (!this.VO.isEmpty())
      {
        fh();
        Iterator localIterator = this.VO.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          o localo = (o)localWeakReference.get();
          if (localo == null) {
            this.VO.remove(localWeakReference);
          } else {
            localo.o(paramBoolean);
          }
        }
        fi();
      }
    }
    do
    {
      return;
      this.VJ = true;
    } while (!paramBoolean);
    this.VK = true;
  }
  
  public void removeGroup(int paramInt)
  {
    int j = size();
    int i = 0;
    if (i < j) {
      if (((j)this.dU.get(i)).getGroupId() != paramInt) {}
    }
    for (;;)
    {
      label30:
      if (i >= 0)
      {
        int k = this.dU.size();
        j = 0;
        for (;;)
        {
          if ((j < k - i) && (((j)this.dU.get(i)).getGroupId() == paramInt))
          {
            n(i, false);
            j += 1;
            continue;
            i += 1;
            break;
            i = -1;
            break label30;
          }
        }
        q(true);
      }
    }
  }
  
  public void removeItem(int paramInt)
  {
    int j = size();
    int i = 0;
    if (i < j) {
      if (((j)this.dU.get(i)).getItemId() != paramInt) {}
    }
    for (;;)
    {
      n(i, true);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = this.dU.size();
    int i = 0;
    while (i < j)
    {
      j localj = (j)this.dU.get(i);
      if (localj.getGroupId() == paramInt)
      {
        localj.U(paramBoolean2);
        localj.setCheckable(paramBoolean1);
      }
      i += 1;
    }
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int j = this.dU.size();
    int i = 0;
    while (i < j)
    {
      j localj = (j)this.dU.get(i);
      if (localj.getGroupId() == paramInt) {
        localj.setEnabled(paramBoolean);
      }
      i += 1;
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int k = this.dU.size();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      j localj = (j)this.dU.get(j);
      if ((localj.getGroupId() != paramInt) || (!localj.W(paramBoolean))) {
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
        q(true);
      }
      return;
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.Vv = paramBoolean;
    q(false);
  }
  
  public int size()
  {
    return this.dU.size();
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