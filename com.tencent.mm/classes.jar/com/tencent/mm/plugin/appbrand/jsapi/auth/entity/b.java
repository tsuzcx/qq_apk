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
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import d.g.a.m;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mm.plugin.appbrand.widget.dialog.o.a;>;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController;", "context", "Landroid/content/Context;", "mUserAvatarInfo", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "scope", "", "mListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;)V", "START_CREATE_AVATAR_UI_REQUEST_CODE", "", "currentCheckedAvatarId", "Ljava/util/concurrent/atomic/AtomicInteger;", "deleteAvatarTaskCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "getDeleteAvatarTaskCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "setDeleteAvatarTaskCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;)V", "mCurrentItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "mmPopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "getScope", "()Ljava/lang/String;", "deleteUser", "", "itemIndex", "callback", "dismissPopWindow", "genDialogItem", "", "mmUserAvatarInfo", "goAddUserPage", "activity", "Landroid/app/Activity;", "appId", "handleAfterCreateUser", "data", "Landroid/content/Intent;", "notifyUserInfoItemChanged", "item", "onItemChecked", "onItemLongClick", "view", "Landroid/view/View;", "index", "touchX", "touchY", "showPopWindow", "Companion", "DeleteUserTask", "WxaUserInfoEventListener", "plugin-appbrand-integration_release"})
public final class b
  implements a
{
  public static final a kfq;
  final Context context;
  final ArrayList<o.a> kfj;
  final AtomicInteger kfk;
  final int kfl;
  public a.a kfm;
  public com.tencent.mm.ui.widget.b.a kfn;
  private final MMUserAvatarInfo kfo;
  private final c kfp;
  private final String scope;
  
  static
  {
    AppMethodBeat.i(180472);
    kfq = new a((byte)0);
    AppMethodBeat.o(180472);
  }
  
  public b(Context paramContext, MMUserAvatarInfo paramMMUserAvatarInfo, String paramString, c paramc)
  {
    AppMethodBeat.i(180471);
    this.context = paramContext;
    this.kfo = paramMMUserAvatarInfo;
    this.scope = paramString;
    this.kfp = paramc;
    this.kfj = new ArrayList();
    this.kfk = new AtomicInteger(this.kfo.kfd);
    this.kfl = com.tencent.luggage.sdk.g.a.aA(this);
    this.kfj.addAll((Collection)a(this.scope, this.kfo));
    w(this.kfj);
    AppMethodBeat.o(180471);
  }
  
  private static List<o.a> a(String paramString, MMUserAvatarInfo paramMMUserAvatarInfo)
  {
    AppMethodBeat.i(180470);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramMMUserAvatarInfo.kfa;
    int j = localArrayList2.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = localArrayList2.get(i);
      k.g(localObject, "avatar_list[i]");
      localObject = (MMUserAvatarInfo.MMUserAvatarItem)localObject;
      String str1 = ((MMUserAvatarInfo.MMUserAvatarItem)localObject).nickname;
      String str2 = ((MMUserAvatarInfo.MMUserAvatarItem)localObject).desc;
      if (paramMMUserAvatarInfo.kfd == ((MMUserAvatarInfo.MMUserAvatarItem)localObject).id) {}
      for (boolean bool = true;; bool = false)
      {
        localArrayList1.add(new o.a(str1, str2, paramString, bool, ((MMUserAvatarInfo.MMUserAvatarItem)localObject).kfi, ((MMUserAvatarInfo.MMUserAvatarItem)localObject).id));
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
    this.kfn = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(180469);
      return;
    }
    com.tencent.mm.ui.widget.b.a locala = this.kfn;
    if (locala == null) {
      k.fOy();
    }
    locala.a(paramView, paramInt1, 0L, (View.OnCreateContextMenuListener)new b.i(paramView), (n.d)new j(this, paramInt1), paramInt2, paramInt3);
    AppMethodBeat.o(180469);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(180467);
    k.h(paramView, "view");
    b(paramView, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(180467);
  }
  
  public final void b(o.a parama)
  {
    AppMethodBeat.i(180468);
    k.h(parama, "item");
    this.kfk.set(parama.keF);
    AppMethodBeat.o(180468);
  }
  
  final void w(ArrayList<o.a> paramArrayList)
  {
    AppMethodBeat.i(180466);
    this.kfp.bj((List)paramArrayList);
    c localc = this.kfp;
    boolean bool2 = this.kfo.kfb;
    if (this.kfo.kfc <= paramArrayList.size()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Object localObject = this.kfo.kfh;
      paramArrayList = (ArrayList<o.a>)localObject;
      if (localObject == null) {
        paramArrayList = "";
      }
      String str = this.kfo.kfg;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localc.a(bool2, bool1, paramArrayList, (String)localObject, (m)new h(this));
      AppMethodBeat.o(180466);
      return;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$DeleteUserTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class b
    implements com.tencent.mm.ipcinvoker.b<IPCInteger, IPCBoolean>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$DeleteUserTask$invoke$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-appbrand-integration_release"})
    public static final class a
      implements com.tencent.mm.ak.g
    {
      a(d paramd, com.tencent.mm.modelsimple.g paramg) {}
      
      public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, n paramn)
      {
        AppMethodBeat.i(180456);
        ap.f((Runnable)new a(this, paramInt1, paramInt2));
        com.tencent.mm.kernel.g.agi().b(this.kfr.getType(), (com.tencent.mm.ak.g)this);
        AppMethodBeat.o(180456);
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(b.b.a parama, int paramInt1, int paramInt2) {}
        
        public final void run()
        {
          AppMethodBeat.i(180455);
          d locald = this.kfs.jjU;
          if (locald != null)
          {
            if ((paramInt1 == 0) && (paramInt2 == 0)) {}
            for (boolean bool = true;; bool = false)
            {
              locald.bc(new IPCBoolean(bool));
              AppMethodBeat.o(180455);
              return;
            }
          }
          AppMethodBeat.o(180455);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "", "onItemListChanged", "", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "updateAddNewAvatarEntry", "isBan", "", "reachMaxCount", "limitWording", "", "avatarWording", "goAddUserPage", "Lkotlin/Function2;", "Landroid/app/Activity;", "Lkotlin/ParameterName;", "name", "activity", "appId", "plugin-appbrand-integration_release"})
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, m<? super Activity, ? super String, y> paramm);
    
    public abstract void bj(List<o.a> paramList);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(180458);
      a.a locala = this.kft;
      if (locala != null)
      {
        locala.onStart();
        AppMethodBeat.o(180458);
        return;
      }
      AppMethodBeat.o(180458);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class e<T>
    implements d<ResultType>
  {
    e(b paramb, int paramInt, ArrayList paramArrayList, a.a parama) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$goAddUserPage$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
  public static final class f
    implements MMActivity.a
  {
    public final void c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(180461);
      if (b.b(this.kfu) == paramInt1) {
        b.a(this.kfu, paramIntent);
      }
      AppMethodBeat.o(180461);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
  static final class g
    implements e.b
  {
    g(b paramb) {}
    
    public final boolean b(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(180462);
      if (b.b(this.kfu) == paramInt1)
      {
        b.a(this.kfu, paramIntent);
        AppMethodBeat.o(180462);
        return true;
      }
      AppMethodBeat.o(180462);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "activity", "Landroid/app/Activity;", "appId", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements m<Activity, String, y>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class j
    implements n.d
  {
    j(b paramb, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(180465);
      paramMenuItem = this.kfu;
      paramInt = paramInt1;
      a.a locala = this.kfu.kfm;
      ac.i("WxaUserInfoListOperationController", "[deleteUser] index=".concat(String.valueOf(paramInt)));
      if (!ax.isConnected(ai.getContext()))
      {
        t.makeText(paramMenuItem.context, (CharSequence)paramMenuItem.context.getResources().getString(2131756043), 1).show();
        if (locala != null) {
          locala.onStart();
        }
        if (locala != null)
        {
          locala.bfr();
          AppMethodBeat.o(180465);
          return;
        }
        AppMethodBeat.o(180465);
        return;
      }
      ArrayList localArrayList = new ArrayList((Collection)paramMenuItem.kfj);
      localArrayList.remove(paramInt);
      Object localObject = paramMenuItem.kfj.get(paramInt);
      k.g(localObject, "mCurrentItems[itemIndex]");
      localObject = (o.a)localObject;
      if (((o.a)localObject).keF == paramMenuItem.kfk.get()) {
        ((o.a)localArrayList.get(0)).ikl = true;
      }
      ((o.a)localObject).ikl = false;
      paramMenuItem.w(localArrayList);
      ap.f((Runnable)new b.d(locala));
      h.a("com.tencent.mm", (Parcelable)new IPCInteger(((o.a)localObject).keF), b.b.class, (d)new b.e(paramMenuItem, paramInt, localArrayList, locala));
      AppMethodBeat.o(180465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b
 * JD-Core Version:    0.7.0.1
 */