package com.tencent.mm.msgsubscription.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.ui.AppBrandAuthorizeSubscribeMsgDetailUI;
import com.tencent.mm.msgsubscription.ui.e;
import com.tencent.mm.msgsubscription.ui.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/presenter/WxaSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "()V", "REQUEST_CODE_TO_DETAIL", "", "activity", "Landroid/app/Activity;", "changed", "", "subscribeMsgSettingData", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "createAdapter", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter;", "Lcom/tencent/mm/ui/MMActivity;", "dispatchLoadDataResult", "", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "getCheckBoxState", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "goDetailUI", "position", "loadData", "bizUsername", "", "onActivityCreated", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeMsgItemInfoClick", "view", "Landroid/view/View;", "onSubscribeSwitchChanged", "on", "Companion", "plugin-comm_release"})
public final class d
  extends a
{
  public static final d.a mpS;
  private Activity activity;
  boolean bqf;
  final int mpQ = 1;
  SubscribeMsgSettingData mpR;
  
  static
  {
    AppMethodBeat.i(149587);
    mpS = new d.a((byte)0);
    AppMethodBeat.o(149587);
  }
  
  private static void a(b.a parama, SubscribeMsgSettingData paramSubscribeMsgSettingData)
  {
    AppMethodBeat.i(149582);
    if (paramSubscribeMsgSettingData == null)
    {
      parama.onError();
      AppMethodBeat.o(149582);
      return;
    }
    parama.a(paramSubscribeMsgSettingData);
    AppMethodBeat.o(149582);
  }
  
  public static boolean a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
  {
    AppMethodBeat.i(149586);
    p.k(paramSubscribeMsgTmpItem, "item");
    if (paramSubscribeMsgTmpItem.mof == 1)
    {
      AppMethodBeat.o(149586);
      return true;
    }
    AppMethodBeat.o(149586);
    return false;
  }
  
  public final void a(String paramString, final b.a parama)
  {
    AppMethodBeat.i(149581);
    p.k(paramString, "bizUsername");
    p.k(parama, "l");
    Object localObject = this.activity;
    if (localObject == null) {
      p.bGy("activity");
    }
    this.mpR = ((SubscribeMsgSettingData)((Activity)localObject).getIntent().getParcelableExtra("key_biz_data"));
    if (this.mpR == null)
    {
      localObject = com.tencent.mm.msgsubscription.util.d.mtA;
      com.tencent.mm.msgsubscription.util.d.c(paramString, (b)new d(this, parama));
      AppMethodBeat.o(149581);
      return;
    }
    a(parama, this.mpR);
    AppMethodBeat.o(149581);
  }
  
  public final com.tencent.mm.msgsubscription.ui.a<?> b(final MMActivity paramMMActivity)
  {
    AppMethodBeat.i(191917);
    p.k(paramMMActivity, "activity");
    paramMMActivity = (com.tencent.mm.msgsubscription.ui.a)new e((Context)paramMMActivity, (e.c)new b(this, paramMMActivity));
    AppMethodBeat.o(191917);
    return paramMMActivity;
  }
  
  public final void gn(boolean paramBoolean)
  {
    this.bqf = true;
    SubscribeMsgSettingData localSubscribeMsgSettingData = this.mpR;
    if (localSubscribeMsgSettingData != null) {
      localSubscribeMsgSettingData.lGT = paramBoolean;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity)
  {
    AppMethodBeat.i(149580);
    p.k(paramActivity, "activity");
    super.onActivityCreated(paramActivity);
    this.activity = paramActivity;
    AppMethodBeat.o(149580);
  }
  
  public final void x(Activity paramActivity)
  {
    AppMethodBeat.i(149585);
    p.k(paramActivity, "activity");
    if ((this.bqf) && (this.mpR != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_biz_data", (Parcelable)this.mpR);
      paramActivity.setResult(-1, localIntent);
    }
    AppMethodBeat.o(149585);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/presenter/WxaSubscribeMsgSettingPagePresenter$createAdapter$1", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter$SubscribeMsgSecondaryMenuListener;", "getSubscribeState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onClick", "", "position", "", "plugin-comm_release"})
  public static final class b
    implements e.c
  {
    b(MMActivity paramMMActivity) {}
    
    public final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, int paramInt)
    {
      AppMethodBeat.i(223830);
      p.k(paramSubscribeMsgTmpItem, "item");
      d locald = this.mpT;
      MMActivity localMMActivity = paramMMActivity;
      p.k(localMMActivity, "activity");
      p.k(paramSubscribeMsgTmpItem, "item");
      localMMActivity.mmSetOnActivityResultCallback((MMActivity.a)new d.c(locald, paramInt));
      Intent localIntent = new Intent((Context)localMMActivity, AppBrandAuthorizeSubscribeMsgDetailUI.class);
      localIntent.putExtra("key_data", (Parcelable)paramSubscribeMsgTmpItem);
      localIntent.putExtra("key_status_subscribed", d.a(paramSubscribeMsgTmpItem));
      com.tencent.mm.by.c.d((Context)localMMActivity, "com.tencent.mm.msgsubscription.ui.AppBrandAuthorizeSubscribeMsgDetailUI", localIntent, locald.mpQ);
      AppMethodBeat.o(223830);
    }
    
    public final boolean c(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
    {
      AppMethodBeat.i(223834);
      p.k(paramSubscribeMsgTmpItem, "item");
      boolean bool = d.a(paramSubscribeMsgTmpItem);
      AppMethodBeat.o(223834);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class c
    implements MMActivity.a
  {
    c(d paramd, int paramInt) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(223471);
      SubscribeMsgTmpItem localSubscribeMsgTmpItem1;
      SubscribeMsgTmpItem localSubscribeMsgTmpItem2;
      if ((paramInt1 == d.b(this.mpT)) && (paramInt2 == -1))
      {
        localSubscribeMsgTmpItem1 = (SubscribeMsgTmpItem)paramIntent.getParcelableExtra("key_data");
        boolean bool = paramIntent.getBooleanExtra("key_status_subscribed", false);
        if (localSubscribeMsgTmpItem1 == null)
        {
          AppMethodBeat.o(223471);
          return;
        }
        paramIntent = this.mpT;
        p.k(localSubscribeMsgTmpItem1, "itemChanged");
        paramIntent.bqf = true;
        paramIntent = paramIntent.mpR;
        if (paramIntent == null) {
          p.iCn();
        }
        paramIntent = paramIntent.lxh.iterator();
        while (paramIntent.hasNext())
        {
          localSubscribeMsgTmpItem2 = (SubscribeMsgTmpItem)paramIntent.next();
          if (TextUtils.equals((CharSequence)localSubscribeMsgTmpItem1.lnb, (CharSequence)localSubscribeMsgTmpItem2.lnb)) {
            if (!bool) {
              break label185;
            }
          }
        }
      }
      label185:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        localSubscribeMsgTmpItem2.mof = paramInt1;
        localSubscribeMsgTmpItem2.mnH = localSubscribeMsgTmpItem1.mnH;
        this.mpT.bsw().xq(this.jEN);
        Log.i("MicroMsg.WxaSubscribeMsgSettingPagePresenter", "goDetailUI  mmSetOnActivityResultCallback");
        AppMethodBeat.o(223471);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "invoke"})
  static final class d
    extends q
    implements b<SubscribeMsgSettingData, x>
  {
    d(d paramd, b.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.presenter.d
 * JD-Core Version:    0.7.0.1
 */