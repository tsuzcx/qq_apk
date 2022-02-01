package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Toast;
import com.tencent.luggage.h.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mm.plugin.appbrand.widget.dialog.o.a;>;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController;", "context", "Landroid/content/Context;", "mUserAvatarInfo", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "scope", "", "mListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;)V", "START_CREATE_AVATAR_UI_REQUEST_CODE", "", "currentCheckedAvatarId", "Ljava/util/concurrent/atomic/AtomicInteger;", "deleteAvatarTaskCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "getDeleteAvatarTaskCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "setDeleteAvatarTaskCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;)V", "mCurrentItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "mmPopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "getScope", "()Ljava/lang/String;", "deleteUser", "", "itemIndex", "callback", "dismissPopWindow", "genDialogItem", "", "mmUserAvatarInfo", "goAddUserPage", "activity", "Landroid/app/Activity;", "appId", "handleAfterCreateUser", "data", "Landroid/content/Intent;", "notifyUserInfoItemChanged", "item", "onItemChecked", "onItemLongClick", "view", "Landroid/view/View;", "index", "touchX", "touchY", "showPopWindow", "Companion", "DeleteUserTask", "WxaUserInfoEventListener", "plugin-appbrand-integration_release"})
public final class b
  implements a
{
  public static final b.a kAe;
  final Context context;
  public a.a kAa;
  public com.tencent.mm.ui.widget.b.a kAb;
  private final MMUserAvatarInfo kAc;
  private final c kAd;
  final ArrayList<o.a> kzX;
  final AtomicInteger kzY;
  final int kzZ;
  private final String scope;
  
  static
  {
    AppMethodBeat.i(180472);
    kAe = new b.a((byte)0);
    AppMethodBeat.o(180472);
  }
  
  public b(Context paramContext, MMUserAvatarInfo paramMMUserAvatarInfo, String paramString, c paramc)
  {
    AppMethodBeat.i(180471);
    this.context = paramContext;
    this.kAc = paramMMUserAvatarInfo;
    this.scope = paramString;
    this.kAd = paramc;
    this.kzX = new ArrayList();
    this.kzY = new AtomicInteger(this.kAc.kzR);
    this.kzZ = com.tencent.luggage.sdk.g.a.aC(this);
    this.kzX.addAll((Collection)a(this.scope, this.kAc));
    w(this.kzX);
    AppMethodBeat.o(180471);
  }
  
  private static List<o.a> a(String paramString, MMUserAvatarInfo paramMMUserAvatarInfo)
  {
    AppMethodBeat.i(180470);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramMMUserAvatarInfo.kzO;
    int j = localArrayList2.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = localArrayList2.get(i);
      p.g(localObject, "avatar_list[i]");
      localObject = (MMUserAvatarInfo.MMUserAvatarItem)localObject;
      String str1 = ((MMUserAvatarInfo.MMUserAvatarItem)localObject).nickname;
      String str2 = ((MMUserAvatarInfo.MMUserAvatarItem)localObject).desc;
      if (paramMMUserAvatarInfo.kzR == ((MMUserAvatarInfo.MMUserAvatarItem)localObject).id) {}
      for (boolean bool = true;; bool = false)
      {
        localArrayList1.add(new o.a(str1, str2, paramString, bool, ((MMUserAvatarInfo.MMUserAvatarItem)localObject).kzW, ((MMUserAvatarInfo.MMUserAvatarItem)localObject).id));
        i += 1;
        break;
      }
    }
    paramString = (List)localArrayList1;
    AppMethodBeat.o(180470);
    return paramString;
  }
  
  private final void b(View paramView, final int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(180469);
    this.kAb = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(180469);
      return;
    }
    com.tencent.mm.ui.widget.b.a locala = this.kAb;
    if (locala == null) {
      p.gfZ();
    }
    locala.a(paramView, paramInt1, 0L, (View.OnCreateContextMenuListener)new b.i(paramView), (n.e)new j(this, paramInt1), paramInt2, paramInt3);
    AppMethodBeat.o(180469);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(180467);
    p.h(paramView, "view");
    b(paramView, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(180467);
  }
  
  public final void b(o.a parama)
  {
    AppMethodBeat.i(180468);
    p.h(parama, "item");
    this.kzY.set(parama.kzo);
    AppMethodBeat.o(180468);
  }
  
  final void w(ArrayList<o.a> paramArrayList)
  {
    AppMethodBeat.i(180466);
    this.kAd.bl((List)paramArrayList);
    c localc = this.kAd;
    boolean bool2 = this.kAc.kzP;
    if (this.kAc.kzQ <= paramArrayList.size()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Object localObject = this.kAc.kzV;
      paramArrayList = (ArrayList<o.a>)localObject;
      if (localObject == null) {
        paramArrayList = "";
      }
      String str = this.kAc.kzU;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localc.a(bool2, bool1, paramArrayList, (String)localObject, (m)new h(this));
      AppMethodBeat.o(180466);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "", "onItemListChanged", "", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "updateAddNewAvatarEntry", "isBan", "", "reachMaxCount", "limitWording", "", "avatarWording", "goAddUserPage", "Lkotlin/Function2;", "Landroid/app/Activity;", "Lkotlin/ParameterName;", "name", "activity", "appId", "plugin-appbrand-integration_release"})
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, m<? super Activity, ? super String, z> paramm);
    
    public abstract void bl(List<o.a> paramList);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(180458);
      a.a locala = this.kAh;
      if (locala != null)
      {
        locala.onStart();
        AppMethodBeat.o(180458);
        return;
      }
      AppMethodBeat.o(180458);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class e<T>
    implements d<ResultType>
  {
    e(b paramb, int paramInt, ArrayList paramArrayList, a.a parama) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$goAddUserPage$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
  public static final class f
    implements MMActivity.a
  {
    public final void c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(180461);
      if (b.b(this.kAi) == paramInt1) {
        b.a(this.kAi, paramIntent);
      }
      AppMethodBeat.o(180461);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
  static final class g
    implements e.c
  {
    g(b paramb) {}
    
    public final boolean b(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(180462);
      if (b.b(this.kAi) == paramInt1)
      {
        b.a(this.kAi, paramIntent);
        AppMethodBeat.o(180462);
        return true;
      }
      AppMethodBeat.o(180462);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "activity", "Landroid/app/Activity;", "appId", "", "invoke"})
  static final class h
    extends q
    implements m<Activity, String, z>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class j
    implements n.e
  {
    j(b paramb, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(180465);
      paramMenuItem = this.kAi;
      paramInt = paramInt1;
      a.a locala = this.kAi.kAa;
      ad.i("WxaUserInfoListOperationController", "[deleteUser] index=".concat(String.valueOf(paramInt)));
      if (!ay.isConnected(aj.getContext()))
      {
        t.makeText(paramMenuItem.context, (CharSequence)paramMenuItem.context.getResources().getString(2131756043), 1).show();
        if (locala != null) {
          locala.onStart();
        }
        if (locala != null)
        {
          locala.biU();
          AppMethodBeat.o(180465);
          return;
        }
        AppMethodBeat.o(180465);
        return;
      }
      ArrayList localArrayList = new ArrayList((Collection)paramMenuItem.kzX);
      localArrayList.remove(paramInt);
      Object localObject = paramMenuItem.kzX.get(paramInt);
      p.g(localObject, "mCurrentItems[itemIndex]");
      localObject = (o.a)localObject;
      if (((o.a)localObject).kzo == paramMenuItem.kzY.get()) {
        ((o.a)localArrayList.get(0)).iDC = true;
      }
      ((o.a)localObject).iDC = false;
      paramMenuItem.w(localArrayList);
      aq.f((Runnable)new b.d(locala));
      h.a("com.tencent.mm", (Parcelable)new IPCInteger(((o.a)localObject).kzo), b.b.class, (d)new b.e(paramMenuItem, paramInt, localArrayList, locala));
      AppMethodBeat.o(180465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b
 * JD-Core Version:    0.7.0.1
 */