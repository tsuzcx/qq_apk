package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class n
  extends h
{
  public n(g paramg, MMActivity paramMMActivity)
  {
    super(paramg, paramMMActivity);
  }
  
  private void a(Button paramButton, b paramb)
  {
    AppMethodBeat.i(88771);
    paramb = paramb.bbd().color;
    if (!bo.isNullOrNil(paramb))
    {
      int i = com.tencent.mm.plugin.card.d.l.IB(paramb);
      paramButton.setText(this.jpX.getResources().getString(2131297881));
      paramButton.setTextColor(i);
      paramb = new GradientDrawable();
      paramb.setColor(this.jpX.getResources().getColor(2131689828));
      paramb.setStroke(2, i);
      paramb.setCornerRadius(8.0F);
      paramButton.setBackground(paramb);
    }
    AppMethodBeat.o(88771);
  }
  
  public final void a(ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(88769);
    am.bct().bbw();
    paramViewGroup.findViewById(2131822019).setVisibility(0);
    paramViewGroup.findViewById(2131822018).setVisibility(8);
    uo localuo = paramb.bbe().wEh;
    if (localuo != null)
    {
      paramViewGroup.findViewById(2131822020).setVisibility(0);
      if (!bo.isNullOrNil(localuo.title))
      {
        Button localButton = (Button)paramViewGroup.findViewById(2131822023);
        localButton.setText(localuo.title);
        localButton.setVisibility(0);
        a(localButton, paramb);
        localButton.setOnClickListener(new n.2(this, localuo, paramb));
        if (!bo.isNullOrNil(localuo.kmn)) {
          ((TextView)paramViewGroup.findViewById(2131822021)).setText(localuo.kmn);
        }
        paramViewGroup = (TextView)paramViewGroup.findViewById(2131822022);
        if (!bo.isNullOrNil(localuo.kmo))
        {
          paramViewGroup.setText(localuo.kmo);
          paramViewGroup.setVisibility(0);
          AppMethodBeat.o(88769);
          return;
        }
        paramViewGroup.setVisibility(8);
      }
    }
    AppMethodBeat.o(88769);
  }
  
  public final void b(ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(88770);
    ab.i("MicroMsg.CardDynamicQrCodeController", "onScreenShot! ");
    View localView1 = paramViewGroup.findViewById(2131822019);
    if (localView1.getVisibility() == 0)
    {
      ab.e("MicroMsg.CardDynamicQrCodeController", "code_qr_disable_layout is visible! do not show hint!");
      AppMethodBeat.o(88770);
      return;
    }
    localView1.setVisibility(0);
    Object localObject = paramViewGroup.findViewById(2131822015);
    if (((View)localObject).getVisibility() == 0) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (ImageView)paramViewGroup.findViewById(2131822018);
    ((ImageView)localObject).setVisibility(8);
    View localView2 = paramViewGroup.findViewById(2131822020);
    localView2.setVisibility(0);
    ((TextView)paramViewGroup.findViewById(2131822021)).setText(this.jpX.getResources().getString(2131297880));
    Button localButton = (Button)paramViewGroup.findViewById(2131822023);
    localButton.setVisibility(0);
    a(localButton, paramb);
    com.tencent.mm.plugin.card.b.g localg = am.bct();
    if (paramb == null) {
      ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport do nothing return !cardInfo is null!");
    }
    for (;;)
    {
      localButton.setOnClickListener(new n.3(this, localView1, localView2, (ImageView)localObject, localButton, paramViewGroup, paramb));
      AppMethodBeat.o(88770);
      return;
      localg.bbw();
      k localk = am.bcr().HN(paramb.bbh());
      if (localk != null)
      {
        ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport currentCode cardId =%s,codeId=%s", new Object[] { localk.field_card_id, localk.field_code_id });
        if (am.bcr().dp(paramb.bbh(), localk.field_code_id)) {
          localg.a(paramb.bbh(), localk.field_code_id, c.kCa);
        } else {
          ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport delete failue! do not report! cardId =%s,codeId=%s", new Object[] { localk.field_card_id, localk.field_code_id });
        }
      }
      else
      {
        ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport  failue! currentCode is null!");
      }
    }
  }
  
  public final boolean bfr()
  {
    return false;
  }
  
  public final boolean bfs()
  {
    return true;
  }
  
  public final void c(ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(88767);
    super.c(paramViewGroup, paramb);
    d(paramViewGroup, paramb);
    AppMethodBeat.o(88767);
  }
  
  final void d(ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(88768);
    paramb = paramb.bbd().wGE;
    View localView = paramViewGroup.findViewById(2131822015);
    if ((paramb != null) && (paramb.wPZ))
    {
      localView.setVisibility(0);
      if (!bo.isNullOrNil(paramb.wQa))
      {
        ((TextView)paramViewGroup.findViewById(2131822016)).setText(paramb.wQa);
        ((ImageView)paramViewGroup.findViewById(2131822017)).setOnClickListener(new n.1(this, paramViewGroup));
        AppMethodBeat.o(88768);
      }
    }
    else
    {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(88768);
  }
  
  public final boolean g(b paramb)
  {
    AppMethodBeat.i(88765);
    if (!paramb.bbe().wEi)
    {
      ab.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : is_commom_card false!ban card show!");
      AppMethodBeat.o(88765);
      return false;
    }
    paramb = paramb.bbe().wEh;
    if ((paramb != null) && (!bo.isNullOrNil(paramb.title)))
    {
      ab.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : unavailable_qrcode_field is not null  !ban card show!");
      AppMethodBeat.o(88765);
      return false;
    }
    AppMethodBeat.o(88765);
    return true;
  }
  
  public final int getLayoutId()
  {
    return 2130968916;
  }
  
  public final void l(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(88766);
    paramViewGroup.findViewById(2131822019).setVisibility(8);
    paramViewGroup.findViewById(2131822018).setVisibility(0);
    AppMethodBeat.o(88766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.n
 * JD-Core Version:    0.7.0.1
 */