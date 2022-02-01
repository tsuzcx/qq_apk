package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.luggage.l.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.aa;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mm.plugin.appbrand.widget.dialog.k.a;>;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController;", "context", "Landroid/content/Context;", "mUserAvatarInfo", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "scope", "", "mListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;)V", "START_CREATE_AVATAR_UI_REQUEST_CODE", "", "currentCheckedAvatarId", "Ljava/util/concurrent/atomic/AtomicInteger;", "deleteAvatarTaskCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "getDeleteAvatarTaskCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "setDeleteAvatarTaskCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;)V", "mCurrentItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mmPopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "getScope", "()Ljava/lang/String;", "deleteUser", "", "itemIndex", "callback", "dismissPopWindow", "genDialogItem", "", "mmUserAvatarInfo", "goAddUserPage", "activity", "Landroid/app/Activity;", "appId", "handleAfterCreateUser", "data", "Landroid/content/Intent;", "notifyUserInfoItemChanged", "item", "onItemChecked", "onItemLongClick", "view", "Landroid/view/View;", "index", "touchX", "touchY", "showPopWindow", "Companion", "DeleteUserTask", "WxaUserInfoEventListener", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  public static final b.a rHl;
  private final Context context;
  private final MMUserAvatarInfo rHm;
  private final b.c rHn;
  private final ArrayList<k.a> rHo;
  private final AtomicInteger rHp;
  private final int rHq;
  public a.a rHr;
  private com.tencent.mm.ui.widget.b.a rHs;
  private final String scope;
  
  static
  {
    AppMethodBeat.i(180472);
    rHl = new b.a((byte)0);
    AppMethodBeat.o(180472);
  }
  
  public b(Context paramContext, MMUserAvatarInfo paramMMUserAvatarInfo, String paramString, b.c paramc)
  {
    AppMethodBeat.i(180471);
    this.context = paramContext;
    this.rHm = paramMMUserAvatarInfo;
    this.scope = paramString;
    this.rHn = paramc;
    this.rHo = new ArrayList();
    this.rHp = new AtomicInteger(this.rHm.rHa);
    this.rHq = com.tencent.luggage.sdk.h.a.ce(this);
    this.rHo.addAll((Collection)a(this.scope, this.rHm));
    F(this.rHo);
    this.rHn.a(b.c.a.rHv);
    AppMethodBeat.o(180471);
  }
  
  private final void F(ArrayList<k.a> paramArrayList)
  {
    AppMethodBeat.i(180466);
    this.rHn.di((List)paramArrayList);
    b.c localc = this.rHn;
    boolean bool2 = this.rHm.rGY;
    if (this.rHm.rGZ <= paramArrayList.size()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Object localObject = this.rHm.rHe;
      paramArrayList = (ArrayList<k.a>)localObject;
      if (localObject == null) {
        paramArrayList = "";
      }
      String str = this.rHm.rHd;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localc.a(bool2, bool1, paramArrayList, (String)localObject, (m)new e(this));
      AppMethodBeat.o(180466);
      return;
    }
  }
  
  private final void G(Intent paramIntent)
  {
    AppMethodBeat.i(326991);
    if (paramIntent == null)
    {
      AppMethodBeat.o(326991);
      return;
    }
    int i = paramIntent.getIntExtra("id", -1);
    String str1 = paramIntent.getStringExtra("nickname");
    paramIntent = paramIntent.getStringExtra("avatarurl");
    Object localObject = this.rHo.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((k.a)((Iterator)localObject).next()).plZ = false;
    }
    localObject = this.rHo;
    String str2 = this.scope;
    s.checkNotNull(paramIntent);
    ((ArrayList)localObject).add(new k.a(0, str1, "", str2, null, true, paramIntent, i));
    this.rHn.a(b.c.a.rHx);
    F(this.rHo);
    Log.i("WxaUserInfoListOperationController", "mmOnActivityResult nickname=" + str1 + " avatarurl=" + paramIntent);
    AppMethodBeat.o(326991);
  }
  
  private static List<k.a> a(String paramString, MMUserAvatarInfo paramMMUserAvatarInfo)
  {
    AppMethodBeat.i(180470);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramMMUserAvatarInfo.rGX;
    int j = localArrayList2.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = localArrayList2.get(i);
      s.s(localObject, "avatar_list[i]");
      localObject = (MMUserAvatarInfo.MMUserAvatarItem)localObject;
      String str1 = ((MMUserAvatarInfo.MMUserAvatarItem)localObject).nickname;
      String str2 = ((MMUserAvatarInfo.MMUserAvatarItem)localObject).desc;
      if (paramMMUserAvatarInfo.rHa == ((MMUserAvatarInfo.MMUserAvatarItem)localObject).id) {}
      for (boolean bool = true;; bool = false)
      {
        localArrayList1.add(new k.a(str1, str2, paramString, bool, ((MMUserAvatarInfo.MMUserAvatarItem)localObject).rHi, ((MMUserAvatarInfo.MMUserAvatarItem)localObject).id));
        i += 1;
        break;
      }
    }
    paramString = (List)localArrayList1;
    AppMethodBeat.o(180470);
    return paramString;
  }
  
  private static final void a(View paramView1, ContextMenu paramContextMenu, View paramView2, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(327010);
    s.u(paramView1, "$view");
    paramContextMenu.add(0, 1, 0, (CharSequence)paramView1.getContext().getResources().getString(ba.i.appbrand_authorize_item_delete));
    AppMethodBeat.o(327010);
  }
  
  private static final void a(IPCBoolean paramIPCBoolean, b paramb, int paramInt, ArrayList paramArrayList, a.a parama)
  {
    AppMethodBeat.i(327004);
    s.u(paramb, "this$0");
    s.u(paramArrayList, "$itemsAfterDelete");
    boolean bool;
    if (paramIPCBoolean == null)
    {
      bool = false;
      if (bool) {
        break label95;
      }
      paramb.F(paramb.rHo);
      Log.i("WxaUserInfoListOperationController", s.X("delete avatar failed, revert delete item. index:", Integer.valueOf(paramInt)), new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      if (parama != null) {
        parama.cqs();
      }
      AppMethodBeat.o(327004);
      return;
      bool = paramIPCBoolean.value;
      break;
      label95:
      paramb.rHo.clear();
      paramb.rHo.addAll((Collection)paramArrayList);
      Log.i("WxaUserInfoListOperationController", "delete avatar success.index:" + paramInt + "  current szie=" + paramb.rHo.size());
    }
  }
  
  private static final void a(a.a parama)
  {
    AppMethodBeat.i(327000);
    if (parama != null) {
      parama.onStart();
    }
    AppMethodBeat.o(327000);
  }
  
  private static final void a(b paramb, int paramInt1, MenuItem paramMenuItem, int paramInt2)
  {
    AppMethodBeat.i(327014);
    s.u(paramb, "this$0");
    paramMenuItem = paramb.rHr;
    Log.i("WxaUserInfoListOperationController", s.X("[deleteUser] index=", Integer.valueOf(paramInt1)));
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      aa.makeText(paramb.context, (CharSequence)paramb.context.getResources().getString(ba.i.appbrand_setting_network_fail), 1).show();
      if (paramMenuItem != null) {
        paramMenuItem.onStart();
      }
      if (paramMenuItem != null) {
        paramMenuItem.cqs();
      }
      AppMethodBeat.o(327014);
      return;
    }
    ArrayList localArrayList = new ArrayList((Collection)paramb.rHo);
    localArrayList.remove(paramInt1);
    Object localObject = paramb.rHo.get(paramInt1);
    s.s(localObject, "mCurrentItems[itemIndex]");
    localObject = (k.a)localObject;
    if (((k.a)localObject).rFX == paramb.rHp.get()) {
      ((k.a)localArrayList.get(0)).plZ = true;
    }
    ((k.a)localObject).plZ = false;
    paramb.F(localArrayList);
    MMHandlerThread.postToMainThread(new b..ExternalSyntheticLambda5(paramMenuItem));
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCInteger(((k.a)localObject).rFX), b.b.class, new b..ExternalSyntheticLambda2(paramb, paramInt1, localArrayList, paramMenuItem));
    AppMethodBeat.o(327014);
  }
  
  private static final void a(b paramb, int paramInt, ArrayList paramArrayList, a.a parama, IPCBoolean paramIPCBoolean)
  {
    AppMethodBeat.i(327007);
    s.u(paramb, "this$0");
    s.u(paramArrayList, "$itemsAfterDelete");
    MMHandlerThread.postToMainThread(new b..ExternalSyntheticLambda4(paramIPCBoolean, paramb, paramInt, paramArrayList, parama));
    AppMethodBeat.o(327007);
  }
  
  private static final boolean a(b paramb, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(327017);
    s.u(paramb, "this$0");
    if (paramb.rHq == paramInt1)
    {
      paramb.G(paramIntent);
      AppMethodBeat.o(327017);
      return true;
    }
    AppMethodBeat.o(327017);
    return false;
  }
  
  private final void b(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(180469);
    this.rHs = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(180469);
      return;
    }
    com.tencent.mm.ui.widget.b.a locala = this.rHs;
    s.checkNotNull(locala);
    locala.a(paramView, paramInt1, 0L, new b..ExternalSyntheticLambda0(paramView), new b..ExternalSyntheticLambda3(this, paramInt1), paramInt2, paramInt3);
    AppMethodBeat.o(180469);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(180467);
    s.u(paramView, "view");
    b(paramView, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(180467);
  }
  
  public final void b(k.a parama)
  {
    AppMethodBeat.i(327069);
    s.u(parama, "item");
    this.rHp.set(parama.rFX);
    AppMethodBeat.o(327069);
  }
  
  public final void cqu()
  {
    AppMethodBeat.i(327071);
    com.tencent.mm.ui.widget.b.a locala = this.rHs;
    if (locala != null) {
      locala.diW();
    }
    AppMethodBeat.o(327071);
  }
  
  public final void e(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(327075);
    s.u(paramActivity, "activity");
    s.u(paramString, "appId");
    Intent localIntent = new Intent();
    localIntent.putExtra("0", paramString);
    localIntent.putExtra("extra_call_by_appbrand", true);
    if ((paramActivity instanceof MMActivity))
    {
      this.rHn.a(b.c.a.rHw);
      c.a((MMActivity)paramActivity, ".plugin.webview.ui.tools.CreateAvatarUI", localIntent, this.rHq, (MMActivity.a)new d(this));
      AppMethodBeat.o(327075);
      return;
    }
    if ((paramActivity instanceof AppBrandUI))
    {
      this.rHn.a(b.c.a.rHw);
      e.bt((Context)paramActivity).b(new b..ExternalSyntheticLambda1(this));
      c.d((Context)paramActivity, ".plugin.webview.ui.tools.CreateAvatarUI", localIntent, this.rHq);
    }
    AppMethodBeat.o(327075);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$goAddUserPage$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements MMActivity.a
  {
    d(b paramb) {}
    
    public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(180461);
      if (b.a(this.rHz) == paramInt1) {
        b.a(this.rHz, paramIntent);
      }
      AppMethodBeat.o(180461);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "activity", "Landroid/app/Activity;", "appId", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements m<Activity, String, ah>
  {
    e(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b
 * JD-Core Version:    0.7.0.1
 */