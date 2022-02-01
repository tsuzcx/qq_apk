package com.tencent.mm.msgsubscription.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.util.c;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/presenter/WxaSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "()V", "activity", "Landroid/app/Activity;", "changed", "", "subscribeMsgSettingData", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "dispatchLoadDataResult", "", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "getCheckBoxState", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "loadData", "bizUsername", "", "onActivityCreated", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeSwitchChanged", "on", "Companion", "plugin-comm_release"})
public final class d
  extends a
{
  public static final d.a hHf;
  private Activity activity;
  private boolean byn;
  private SubscribeMsgSettingData hHe;
  
  static
  {
    AppMethodBeat.i(149587);
    hHf = new d.a((byte)0);
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
  
  public final void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, boolean paramBoolean)
  {
    AppMethodBeat.i(149584);
    k.h(paramSubscribeMsgTmpItem, "itemChanged");
    this.byn = true;
    Object localObject = this.hHe;
    if (localObject == null) {
      k.fvU();
    }
    localObject = ((SubscribeMsgSettingData)localObject).gQr.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)((Iterator)localObject).next();
      if (TextUtils.equals((CharSequence)paramSubscribeMsgTmpItem.gIj, (CharSequence)localSubscribeMsgTmpItem.gIj))
      {
        if (paramBoolean) {}
        for (int i = 1;; i = 0)
        {
          localSubscribeMsgTmpItem.hGw = i;
          AppMethodBeat.o(149584);
          return;
        }
      }
    }
    AppMethodBeat.o(149584);
  }
  
  public final void a(String paramString, final b.a parama)
  {
    AppMethodBeat.i(149581);
    k.h(paramString, "bizUsername");
    k.h(parama, "l");
    Object localObject = this.activity;
    if (localObject == null) {
      k.aPZ("activity");
    }
    this.hHe = ((SubscribeMsgSettingData)((Activity)localObject).getIntent().getParcelableExtra("key_biz_data"));
    if (this.hHe == null)
    {
      localObject = c.hKr;
      c.b(paramString, (b)new b(this, parama));
      AppMethodBeat.o(149581);
      return;
    }
    a(parama, this.hHe);
    AppMethodBeat.o(149581);
  }
  
  public final boolean a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
  {
    AppMethodBeat.i(149586);
    k.h(paramSubscribeMsgTmpItem, "item");
    if (paramSubscribeMsgTmpItem.hGw == 1)
    {
      AppMethodBeat.o(149586);
      return true;
    }
    AppMethodBeat.o(149586);
    return false;
  }
  
  public final void em(boolean paramBoolean)
  {
    this.byn = true;
    SubscribeMsgSettingData localSubscribeMsgSettingData = this.hHe;
    if (localSubscribeMsgSettingData != null) {
      localSubscribeMsgSettingData.gZE = paramBoolean;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity)
  {
    AppMethodBeat.i(149580);
    k.h(paramActivity, "activity");
    super.onActivityCreated(paramActivity);
    this.activity = paramActivity;
    AppMethodBeat.o(149580);
  }
  
  public final void y(Activity paramActivity)
  {
    AppMethodBeat.i(149585);
    k.h(paramActivity, "activity");
    if ((this.byn) && (this.hHe != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_biz_data", (Parcelable)this.hHe);
      paramActivity.setResult(-1, localIntent);
    }
    AppMethodBeat.o(149585);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<SubscribeMsgSettingData, y>
  {
    b(d paramd, b.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.presenter.d
 * JD-Core Version:    0.7.0.1
 */