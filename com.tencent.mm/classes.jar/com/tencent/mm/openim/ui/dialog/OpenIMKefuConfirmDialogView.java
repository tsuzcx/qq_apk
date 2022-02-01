package com.tencent.mm.openim.ui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.api.j;
import com.tencent.mm.openim.e.k;
import com.tencent.mm.openim.e.l;
import com.tencent.mm.openim.ui.e.b;
import com.tencent.mm.openim.ui.view.BaseDialogView;
import com.tencent.mm.plugin.comm.c.c;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/ui/dialog/OpenIMKefuConfirmDialogView;", "Lcom/tencent/mm/openim/ui/view/BaseDialogView;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "antispamTips", "Landroid/widget/TextView;", "avatarImageView", "Landroid/widget/ImageView;", "closeButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "confirmButton", "dialogDesc", "dialogTitle", "kfContact", "Lcom/tencent/mm/openim/api/IOpenIMKefuContact;", "nickNameTextView", "opListener", "Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmUIModel$OnConfirmDialogOpListener;", "openImDescWording", "fillAntispamTips", "", "confirmData", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "fillOpenIMDescWording", "contact", "getCloseButton", "Landroid/view/View;", "root", "getCloseLayoutHeight", "getContentViewLayoutId", "initView", "view", "onContentViewAttached", "onNotifyChange", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "release", "setConfirmData", "setContactInfo", "setOnConfirmDialogOpListener", "listener", "updateOpenIMDescWording", "openImAppId", "wording", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OpenIMKefuConfirmDialogView
  extends BaseDialogView
  implements MStorage.IOnStorageChange
{
  public static final OpenIMKefuConfirmDialogView.a puD;
  private e.b puC;
  private TextView puE;
  private TextView puF;
  private WeImageView puG;
  private ImageView puH;
  private TextView puI;
  private TextView puJ;
  private TextView pui;
  private TextView pun;
  private com.tencent.mm.openim.api.a puo;
  
  static
  {
    AppMethodBeat.i(236049);
    puD = new OpenIMKefuConfirmDialogView.a((byte)0);
    AppMethodBeat.o(236049);
  }
  
  public OpenIMKefuConfirmDialogView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(236010);
    AppMethodBeat.o(236010);
  }
  
  public OpenIMKefuConfirmDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(236015);
    AppMethodBeat.o(236015);
  }
  
  public OpenIMKefuConfirmDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(236020);
    AppMethodBeat.o(236020);
  }
  
  private final void a(com.tencent.mm.openim.api.a parama)
  {
    AppMethodBeat.i(236030);
    if (parama == null)
    {
      AppMethodBeat.o(236030);
      return;
    }
    String str = ((e)h.ax(e.class)).cc(parama.bRR(), parama.bRS());
    cf(parama.bRR(), str);
    AppMethodBeat.o(236030);
  }
  
  private static final void a(OpenIMKefuConfirmDialogView paramOpenIMKefuConfirmDialogView, View paramView)
  {
    AppMethodBeat.i(236041);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramOpenIMKefuConfirmDialogView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/openim/ui/dialog/OpenIMKefuConfirmDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramOpenIMKefuConfirmDialogView, "this$0");
    paramOpenIMKefuConfirmDialogView = paramOpenIMKefuConfirmDialogView.puC;
    if (paramOpenIMKefuConfirmDialogView != null) {
      paramOpenIMKefuConfirmDialogView.bSw();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/openim/ui/dialog/OpenIMKefuConfirmDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236041);
  }
  
  private final void cf(String paramString1, String paramString2)
  {
    TextView localTextView = null;
    Object localObject = null;
    AppMethodBeat.i(236035);
    CharSequence localCharSequence = (CharSequence)paramString2;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label119;
      }
      if (!s.p("3552365301", paramString1)) {
        break label178;
      }
    }
    label175:
    label178:
    for (paramString1 = s.X("@", paramString2);; paramString1 = paramString2)
    {
      localTextView = this.puJ;
      paramString2 = localTextView;
      if (localTextView == null)
      {
        s.bIx("openImDescWording");
        paramString2 = null;
      }
      paramString2.setText((CharSequence)paramString1);
      paramString1 = this.puJ;
      if (paramString1 == null)
      {
        s.bIx("openImDescWording");
        paramString1 = localObject;
      }
      for (;;)
      {
        paramString1.setVisibility(0);
        AppMethodBeat.o(236035);
        return;
        i = 0;
        break;
      }
      label119:
      paramString1 = this.puJ;
      if (paramString1 == null)
      {
        s.bIx("openImDescWording");
        paramString1 = null;
        paramString1.setText((CharSequence)"");
        paramString1 = this.puJ;
        if (paramString1 != null) {
          break label175;
        }
        s.bIx("openImDescWording");
        paramString1 = localTextView;
      }
      for (;;)
      {
        paramString1.setVisibility(4);
        AppMethodBeat.o(236035);
        return;
        break;
      }
    }
  }
  
  public final View jdMethod_do(View paramView)
  {
    AppMethodBeat.i(236059);
    s.u(paramView, "root");
    paramView = paramView.findViewById(c.e.confirm_dialog_close_btn);
    s.s(paramView, "root.findViewById(R.id.confirm_dialog_close_btn)");
    this.puG = ((WeImageView)paramView);
    WeImageView localWeImageView = this.puG;
    paramView = localWeImageView;
    if (localWeImageView == null)
    {
      s.bIx("closeButton");
      paramView = null;
    }
    paramView = (View)paramView;
    AppMethodBeat.o(236059);
    return paramView;
  }
  
  public final void dp(View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(236076);
    s.u(paramView, "view");
    super.dp(paramView);
    Object localObject2 = paramView.findViewById(c.e.confirm_dialog_title);
    s.s(localObject2, "view.findViewById(R.id.confirm_dialog_title)");
    this.puE = ((TextView)localObject2);
    localObject2 = paramView.findViewById(c.e.confirm_dialog_desc);
    s.s(localObject2, "view.findViewById(R.id.confirm_dialog_desc)");
    this.puF = ((TextView)localObject2);
    localObject2 = paramView.findViewById(c.e.confirm_dialog_confirm_button);
    s.s(localObject2, "view.findViewById(R.id.c…rm_dialog_confirm_button)");
    this.pui = ((TextView)localObject2);
    localObject2 = paramView.findViewById(c.e.confirm_dialog_close_btn);
    s.s(localObject2, "view.findViewById(R.id.confirm_dialog_close_btn)");
    this.puG = ((WeImageView)localObject2);
    localObject2 = paramView.findViewById(c.e.kf_avatar);
    s.s(localObject2, "view.findViewById(R.id.kf_avatar)");
    this.puH = ((ImageView)localObject2);
    localObject2 = paramView.findViewById(c.e.kf_nickname);
    s.s(localObject2, "view.findViewById(R.id.kf_nickname)");
    this.puI = ((TextView)localObject2);
    localObject2 = paramView.findViewById(c.e.kf_desc_wording);
    s.s(localObject2, "view.findViewById(R.id.kf_desc_wording)");
    this.puJ = ((TextView)localObject2);
    paramView = paramView.findViewById(c.e.kf_antispam_tips);
    s.s(paramView, "view.findViewById(R.id.kf_antispam_tips)");
    this.pun = ((TextView)paramView);
    localObject2 = this.puE;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      s.bIx("dialogTitle");
      paramView = null;
    }
    aw.a((Paint)paramView.getPaint(), 0.8F);
    localObject2 = this.pui;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      s.bIx("confirmButton");
      paramView = null;
    }
    aw.a((Paint)paramView.getPaint(), 0.8F);
    paramView = this.pui;
    if (paramView == null)
    {
      s.bIx("confirmButton");
      paramView = localObject1;
    }
    for (;;)
    {
      paramView.setOnClickListener(new OpenIMKefuConfirmDialogView..ExternalSyntheticLambda0(this));
      setOnCloseClickListener((com.tencent.mm.openim.ui.view.a.b)new b(this));
      setCanceledOnTouchOutside(true);
      setEnableDialogScroll(false);
      setEnableScrollRightClose(true);
      setIsFixDialogHeight(true);
      ((PluginOpenIM)h.az(PluginOpenIM.class)).getWordingInfoStg().add((MStorage.IOnStorageChange)this);
      AppMethodBeat.o(236076);
      return;
    }
  }
  
  public final int getCloseLayoutHeight()
  {
    AppMethodBeat.i(236063);
    int i = getContext().getResources().getDimensionPixelSize(c.c.Edge_4A);
    AppMethodBeat.o(236063);
    return i;
  }
  
  public final int getContentViewLayoutId()
  {
    return c.f.layout_open_im_kefu_confirm_dialog_content_view;
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    Object localObject = null;
    AppMethodBeat.i(236098);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(236098);
      return;
    }
    if (paramMStorageEventData == null)
    {
      AppMethodBeat.o(236098);
      return;
    }
    String str;
    if ((paramMStorageEventData.obj instanceof k))
    {
      paramString = paramMStorageEventData.obj;
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.openim.storage.OpenIMWordingInfo");
        AppMethodBeat.o(236098);
        throw paramString;
      }
      paramMStorageEventData = (k)paramString;
      str = paramMStorageEventData.field_appid;
      paramString = this.puo;
      if (paramString != null) {
        break label205;
      }
      paramString = null;
      if (s.p(str, paramString))
      {
        str = paramMStorageEventData.field_wordingId;
        paramString = this.puo;
        if (paramString != null) {
          break label215;
        }
      }
    }
    label205:
    label215:
    for (paramString = localObject;; paramString = paramString.bRS())
    {
      if (s.p(str, paramString))
      {
        Log.i("MicroMsg.OpenIMKefuConfirmDialogView", "onNotifyChange openImAppId: %s, wordingId: %s, wording: %s", new Object[] { paramMStorageEventData.field_appid, paramMStorageEventData.field_wordingId, paramMStorageEventData.field_wording });
        cf(paramMStorageEventData.field_appid, paramMStorageEventData.field_wording);
      }
      AppMethodBeat.o(236098);
      return;
      paramString = paramString.bRR();
      break;
    }
  }
  
  public final void setConfirmData(j paramj)
  {
    Object localObject2 = null;
    AppMethodBeat.i(236088);
    com.tencent.mm.openim.api.a locala;
    label42:
    label53:
    int i;
    if (paramj == null)
    {
      locala = null;
      this.puo = locala;
      TextView localTextView = this.puI;
      if (localTextView != null) {
        break label196;
      }
      s.bIx("nickNameTextView");
      localTextView = null;
      if (locala != null) {
        break label199;
      }
      localObject1 = (CharSequence)"";
      localTextView.setText((CharSequence)localObject1);
      a(locala);
      if (paramj != null)
      {
        localObject1 = (CharSequence)paramj.prr;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label228;
        }
        i = 1;
        label92:
        if (i != 0) {
          break label236;
        }
        localObject1 = this.pun;
        if (localObject1 != null) {
          break label233;
        }
        s.bIx("antispamTips");
        localObject1 = null;
        label113:
        ((TextView)localObject1).setText((CharSequence)paramj.prr);
        localObject1 = this.pun;
        paramj = (j)localObject1;
        if (localObject1 == null)
        {
          s.bIx("antispamTips");
          paramj = null;
        }
        paramj.setVisibility(0);
      }
      label148:
      localObject1 = this.puH;
      paramj = (j)localObject1;
      if (localObject1 == null)
      {
        s.bIx("avatarImageView");
        paramj = null;
      }
      if (locala != null) {
        break label264;
      }
    }
    label264:
    for (Object localObject1 = localObject2;; localObject1 = locala.getUsername())
    {
      com.tencent.mm.pluginsdk.ui.a.b.g(paramj, (String)localObject1);
      AppMethodBeat.o(236088);
      return;
      locala = paramj.prp;
      break;
      label196:
      break label42;
      label199:
      localObject1 = locala.getNickname();
      if (localObject1 == null)
      {
        localObject1 = (CharSequence)"";
        break label53;
      }
      localObject1 = (CharSequence)localObject1;
      break label53;
      label228:
      i = 0;
      break label92;
      label233:
      break label113;
      label236:
      localObject1 = this.pun;
      paramj = (j)localObject1;
      if (localObject1 == null)
      {
        s.bIx("antispamTips");
        paramj = null;
      }
      paramj.setVisibility(8);
      break label148;
    }
  }
  
  public final void setContactInfo(com.tencent.mm.openim.api.a parama)
  {
    AppMethodBeat.i(236080);
    TextView localTextView = this.puI;
    Object localObject;
    if (localTextView == null)
    {
      s.bIx("nickNameTextView");
      localTextView = null;
      if (parama != null) {
        break label81;
      }
      localObject = (CharSequence)"";
      label33:
      localTextView.setText((CharSequence)localObject);
      a(parama);
      localObject = this.puH;
      if (localObject != null) {
        break label109;
      }
      s.bIx("avatarImageView");
      localObject = null;
      label60:
      if (parama != null) {
        break label112;
      }
    }
    label81:
    label109:
    label112:
    for (parama = null;; parama = parama.getUsername())
    {
      com.tencent.mm.pluginsdk.ui.a.b.g((ImageView)localObject, parama);
      AppMethodBeat.o(236080);
      return;
      break;
      localObject = parama.getNickname();
      if (localObject == null)
      {
        localObject = (CharSequence)"";
        break label33;
      }
      localObject = (CharSequence)localObject;
      break label33;
      break label60;
    }
  }
  
  public final void setOnConfirmDialogOpListener(e.b paramb)
  {
    this.puC = paramb;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/openim/ui/dialog/OpenIMKefuConfirmDialogView$initView$2", "Lcom/tencent/mm/openim/ui/view/BaseDialogModel$OnCloseClickListener;", "onClose", "", "exitType", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.openim.ui.view.a.b
  {
    b(OpenIMKefuConfirmDialogView paramOpenIMKefuConfirmDialogView) {}
    
    public final void xL(int paramInt)
    {
      AppMethodBeat.i(236004);
      e.b localb = OpenIMKefuConfirmDialogView.a(this.puK);
      if (localb != null) {
        localb.xL(paramInt);
      }
      AppMethodBeat.o(236004);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.openim.ui.dialog.OpenIMKefuConfirmDialogView
 * JD-Core Version:    0.7.0.1
 */