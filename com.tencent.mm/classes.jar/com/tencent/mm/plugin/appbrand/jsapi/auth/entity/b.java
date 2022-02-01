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
import com.tencent.luggage.k.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mm.plugin.appbrand.widget.dialog.h.a;>;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController;", "context", "Landroid/content/Context;", "mUserAvatarInfo", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "scope", "", "mListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;)V", "START_CREATE_AVATAR_UI_REQUEST_CODE", "", "currentCheckedAvatarId", "Ljava/util/concurrent/atomic/AtomicInteger;", "deleteAvatarTaskCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "getDeleteAvatarTaskCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "setDeleteAvatarTaskCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;)V", "mCurrentItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mmPopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "getScope", "()Ljava/lang/String;", "deleteUser", "", "itemIndex", "callback", "dismissPopWindow", "genDialogItem", "", "mmUserAvatarInfo", "goAddUserPage", "activity", "Landroid/app/Activity;", "appId", "handleAfterCreateUser", "data", "Landroid/content/Intent;", "notifyUserInfoItemChanged", "item", "onItemChecked", "onItemLongClick", "view", "Landroid/view/View;", "index", "touchX", "touchY", "showPopWindow", "Companion", "DeleteUserTask", "WxaUserInfoEventListener", "plugin-appbrand-integration_release"})
public final class b
  implements a
{
  public static final b.a oEd;
  final Context context;
  final ArrayList<h.a> oDW;
  final AtomicInteger oDX;
  final int oDY;
  public a.a oDZ;
  public com.tencent.mm.ui.widget.b.a oEa;
  private final MMUserAvatarInfo oEb;
  final c oEc;
  private final String scope;
  
  static
  {
    AppMethodBeat.i(180472);
    oEd = new b.a((byte)0);
    AppMethodBeat.o(180472);
  }
  
  public b(Context paramContext, MMUserAvatarInfo paramMMUserAvatarInfo, String paramString, c paramc)
  {
    AppMethodBeat.i(180471);
    this.context = paramContext;
    this.oEb = paramMMUserAvatarInfo;
    this.scope = paramString;
    this.oEc = paramc;
    this.oDW = new ArrayList();
    this.oDX = new AtomicInteger(this.oEb.oDQ);
    this.oDY = com.tencent.luggage.sdk.h.a.aI(this);
    this.oDW.addAll((Collection)a(this.scope, this.oEb));
    C(this.oDW);
    this.oEc.a(b.c.a.oEg);
    AppMethodBeat.o(180471);
  }
  
  private static List<h.a> a(String paramString, MMUserAvatarInfo paramMMUserAvatarInfo)
  {
    AppMethodBeat.i(180470);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramMMUserAvatarInfo.oDN;
    int j = localArrayList2.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = localArrayList2.get(i);
      p.j(localObject, "avatar_list[i]");
      localObject = (MMUserAvatarInfo.MMUserAvatarItem)localObject;
      String str1 = ((MMUserAvatarInfo.MMUserAvatarItem)localObject).nickname;
      String str2 = ((MMUserAvatarInfo.MMUserAvatarItem)localObject).desc;
      if (paramMMUserAvatarInfo.oDQ == ((MMUserAvatarInfo.MMUserAvatarItem)localObject).id) {}
      for (boolean bool = true;; bool = false)
      {
        localArrayList1.add(new h.a(str1, str2, paramString, bool, ((MMUserAvatarInfo.MMUserAvatarItem)localObject).oDV, ((MMUserAvatarInfo.MMUserAvatarItem)localObject).id));
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
    this.oEa = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(180469);
      return;
    }
    com.tencent.mm.ui.widget.b.a locala = this.oEa;
    if (locala == null) {
      p.iCn();
    }
    locala.a(paramView, paramInt1, 0L, (View.OnCreateContextMenuListener)new b.i(paramView), (q.g)new j(this, paramInt1), paramInt2, paramInt3);
    AppMethodBeat.o(180469);
  }
  
  final void C(ArrayList<h.a> paramArrayList)
  {
    AppMethodBeat.i(180466);
    this.oEc.bx((List)paramArrayList);
    c localc = this.oEc;
    boolean bool2 = this.oEb.oDO;
    if (this.oEb.oDP <= paramArrayList.size()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Object localObject = this.oEb.oDU;
      paramArrayList = (ArrayList<h.a>)localObject;
      if (localObject == null) {
        paramArrayList = "";
      }
      String str = this.oEb.oDT;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localc.a(bool2, bool1, paramArrayList, (String)localObject, (m)new h(this));
      AppMethodBeat.o(180466);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(180467);
    p.k(paramView, "view");
    b(paramView, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(180467);
  }
  
  public final void b(h.a parama)
  {
    AppMethodBeat.i(268186);
    p.k(parama, "item");
    this.oDX.set(parama.oCE);
    AppMethodBeat.o(268186);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "", "onCreateUserActionUpdate", "", "action", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener$CreateUserAction;", "onItemListChanged", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "updateAddNewAvatarEntry", "isBan", "", "reachMaxCount", "limitWording", "", "avatarWording", "goAddUserPage", "Lkotlin/Function2;", "Landroid/app/Activity;", "Lkotlin/ParameterName;", "name", "activity", "appId", "CreateUserAction", "plugin-appbrand-integration_release"})
  public static abstract interface c
  {
    public abstract void a(b.c.a parama);
    
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, m<? super Activity, ? super String, x> paramm);
    
    public abstract void bx(List<h.a> paramList);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(180458);
      a.a locala = this.oEl;
      if (locala != null)
      {
        locala.onStart();
        AppMethodBeat.o(180458);
        return;
      }
      AppMethodBeat.o(180458);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class e<T>
    implements f<ResultType>
  {
    e(b paramb, int paramInt, ArrayList paramArrayList, a.a parama) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$goAddUserPage$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
  public static final class f
    implements MMActivity.a
  {
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(180461);
      if (b.b(this.oEm) == paramInt1) {
        b.a(this.oEm, paramIntent);
      }
      AppMethodBeat.o(180461);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
  static final class g
    implements f.c
  {
    g(b paramb) {}
    
    public final boolean c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(180462);
      if (b.b(this.oEm) == paramInt1)
      {
        b.a(this.oEm, paramIntent);
        AppMethodBeat.o(180462);
        return true;
      }
      AppMethodBeat.o(180462);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "activity", "Landroid/app/Activity;", "appId", "", "invoke"})
  static final class h
    extends q
    implements m<Activity, String, x>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class j
    implements q.g
  {
    j(b paramb, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(180465);
      paramMenuItem = this.oEm;
      paramInt = paramInt1;
      a.a locala = this.oEm.oDZ;
      Log.i("WxaUserInfoListOperationController", "[deleteUser] index=".concat(String.valueOf(paramInt)));
      if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
      {
        w.makeText(paramMenuItem.context, (CharSequence)paramMenuItem.context.getResources().getString(au.i.appbrand_setting_network_fail), 1).show();
        if (locala != null) {
          locala.onStart();
        }
        if (locala != null)
        {
          locala.bQw();
          AppMethodBeat.o(180465);
          return;
        }
        AppMethodBeat.o(180465);
        return;
      }
      ArrayList localArrayList = new ArrayList((Collection)paramMenuItem.oDW);
      localArrayList.remove(paramInt);
      Object localObject = paramMenuItem.oDW.get(paramInt);
      p.j(localObject, "mCurrentItems[itemIndex]");
      localObject = (h.a)localObject;
      if (((h.a)localObject).oCE == paramMenuItem.oDX.get()) {
        ((h.a)localArrayList.get(0)).msB = true;
      }
      ((h.a)localObject).msB = false;
      paramMenuItem.C(localArrayList);
      MMHandlerThread.postToMainThread((Runnable)new b.d(locala));
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCInteger(((h.a)localObject).oCE), b.b.class, (f)new b.e(paramMenuItem, paramInt, localArrayList, locala));
      AppMethodBeat.o(180465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b
 * JD-Core Version:    0.7.0.1
 */