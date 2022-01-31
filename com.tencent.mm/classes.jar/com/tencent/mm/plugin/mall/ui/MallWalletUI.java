package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.mall.a.i;
import com.tencent.mm.plugin.mall.a.i.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.awf;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.cjw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MallWalletUI
  extends WalletBaseUI
{
  private static final int oAL;
  private Dialog mProgressDialog;
  private LinearLayout oAM;
  private LinearLayout oAN;
  private cjf oAO;
  private Dialog oAP;
  private i.a oAQ;
  private MallWalletUI.a oAR;
  private boolean owJ = false;
  
  static
  {
    AppMethodBeat.i(43278);
    oAL = a.fromDPToPix(ah.getContext(), 8);
    AppMethodBeat.o(43278);
  }
  
  private void a(LinearLayout paramLinearLayout, axa paramaxa)
  {
    AppMethodBeat.i(43276);
    label788:
    label928:
    if (paramaxa.xmm != null)
    {
      int i2 = paramaxa.xmm.size();
      cje localcje2 = null;
      com.tencent.mm.kernel.g.RM();
      Object localObject2 = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJd, "");
      Object localObject1 = localcje2;
      if (!bo.isNullOrNil((String)localObject2)) {}
      label801:
      label941:
      try
      {
        localObject1 = new JSONObject((String)localObject2);
        ab.i("MicroMsg.MallWalletUI", "cell size: %s", new Object[] { Integer.valueOf(i2) });
        paramaxa = paramaxa.xmm.iterator();
        int j = 0;
        for (;;)
        {
          if (!paramaxa.hasNext()) {
            break label1162;
          }
          localcje2 = (cje)paramaxa.next();
          localObject2 = new MallWalletSectionCellView(getContext());
          if (j >= i2 - 1) {
            break;
          }
          k = 1;
          com.tencent.mm.plugin.wallet_core.utils.e.a(((MallWalletSectionCellView)localObject2).oAx, localcje2.xTp);
          if ((localcje2.xTs == null) || (bo.isNullOrNil(localcje2.xTs.url))) {
            break label788;
          }
          com.tencent.mm.plugin.wallet_core.utils.e.a(((MallWalletSectionCellView)localObject2).oAA, localcje2.xTs, 2130840789, true);
          if ((localcje2.xTq == null) || (localcje2.xTq.size() <= 0)) {
            break label801;
          }
          com.tencent.mm.plugin.wallet_core.utils.e.a(((MallWalletSectionCellView)localObject2).oAy, (cjw)localcje2.xTq.get(0), null);
          if (localcje2.xTu == null) {
            break label928;
          }
          localObject3 = ((MallWalletSectionCellView)localObject2).oAG;
          localbvy = localcje2.xTu;
          if ((localbvy != null) && (localObject3 != null)) {
            break label814;
          }
          ((MallWalletSectionCellView)localObject2).oAG.setVisibility(0);
          if ((localcje2.xTr == null) || (localcje2.xTr.size() <= 0)) {
            break label941;
          }
          com.tencent.mm.plugin.wallet_core.utils.e.a(((MallWalletSectionCellView)localObject2).oAz, (cjw)localcje2.xTr.get(0), null);
          if ((localcje2.xTr == null) || (localcje2.xTr.size() <= 1)) {
            break label954;
          }
          com.tencent.mm.plugin.wallet_core.utils.e.a(((MallWalletSectionCellView)localObject2).oAB, (cjw)localcje2.xTr.get(1), null);
          if ((localcje2.xTt == null) || (localObject1 == null)) {
            break label1100;
          }
          if (((JSONObject)localObject1).optInt(localcje2.xTt.xcz, 0) != 1) {
            break label967;
          }
          i = 1;
          long l = ((JSONObject)localObject1).optLong(String.format("%s_expiretime", new Object[] { localcje2.xTt.xcz }), 0L);
          int m = i;
          if (l > 0L)
          {
            m = i;
            if (System.currentTimeMillis() > l)
            {
              ab.i("MicroMsg.MallWalletSectionCellView", "red dot expired: %s, %s", new Object[] { localcje2.xTt.xcz, Long.valueOf(l) });
              m = 0;
            }
          }
          if (m == 0) {
            break label1092;
          }
          if (localcje2.xTt.type != 1) {
            break label972;
          }
          ((MallWalletSectionCellView)localObject2).oAC.setVisibility(0);
          ((MallWalletSectionCellView)localObject2).oAD.setVisibility(8);
          ((MallWalletSectionCellView)localObject2).oAE.setVisibility(8);
          i = MallWalletSectionCellView.kzk;
          int n = MallWalletSectionCellView.kzk;
          m = MallWalletSectionCellView.kzk;
          int i1 = MallWalletSectionCellView.kzk;
          if (localcje2.xJu != null)
          {
            localObject3 = localcje2.xJu;
            if (((bkd)localObject3).left > 0.0F) {
              i = ((MallWalletSectionCellView)localObject2).aP(((bkd)localObject3).left);
            }
            if (((bkd)localObject3).right > 0.0F) {
              m = ((MallWalletSectionCellView)localObject2).aP(((bkd)localObject3).right);
            }
            if (((bkd)localObject3).top > 0.0F) {
              n = ((MallWalletSectionCellView)localObject2).aP(((bkd)localObject3).top);
            }
            if (((bkd)localObject3).bottom > 0.0F) {
              i1 = ((MallWalletSectionCellView)localObject2).aP(((bkd)localObject3).bottom);
            }
            ((MallWalletSectionCellView)localObject2).oAF.setPadding(i, n, m, i1);
          }
          if (k == 0) {
            break label1108;
          }
          ((MallWalletSectionCellView)localObject2).oAy.post(new MallWalletSectionCellView.1((MallWalletSectionCellView)localObject2));
          if (localcje2.wna != null) {
            ((MallWalletSectionCellView)localObject2).setOnClickListener(new MallWalletSectionCellView.2((MallWalletSectionCellView)localObject2, localcje2, (JSONObject)localObject1));
          }
          paramLinearLayout.addView((View)localObject2);
          if (!"balance_cell".equals(localcje2.wug)) {
            break label1121;
          }
          this.oAR.oAW = ((MallWalletSectionCellView)localObject2).oAz;
          this.oAR.oAY = ((MallWalletSectionCellView)localObject2).oAH;
          j += 1;
        }
      }
      catch (JSONException localJSONException)
      {
        label814:
        label954:
        label1092:
        for (;;)
        {
          Object localObject3;
          bvy localbvy;
          ab.printErrStackTrace("MicroMsg.MallWalletUI", localJSONException, "", new Object[0]);
          cje localcje1 = localcje2;
          continue;
          int k = 0;
          continue;
          ((MallWalletSectionCellView)localObject2).oAA.setImageResource(2130840789);
          continue;
          ((MallWalletSectionCellView)localObject2).oAy.setText("");
          continue;
          com.tencent.mm.plugin.wallet_core.utils.e.a((TextView)localObject3, localbvy.wNE, null);
          com.tencent.mm.plugin.wallet_core.utils.e.a((View)localObject3, localbvy.xJu);
          int i = (int)localbvy.xJw;
          if ((localbvy.xJw & 0xFF000000) == 0L) {
            i = (int)(localbvy.xJw | 0xFF000000);
          }
          GradientDrawable localGradientDrawable = new GradientDrawable();
          localGradientDrawable.setShape(0);
          if (localbvy.xJv > 0.0F) {
            localGradientDrawable.setCornerRadius(a.fromDPToPix(((TextView)localObject3).getContext(), (int)localbvy.xJv));
          }
          localGradientDrawable.setColor(i);
          ((TextView)localObject3).setBackground(localGradientDrawable);
          continue;
          ((MallWalletSectionCellView)localObject2).oAG.setVisibility(8);
          continue;
          ((MallWalletSectionCellView)localObject2).oAz.setText("");
          continue;
          ((MallWalletSectionCellView)localObject2).oAB.setVisibility(8);
          continue;
          label967:
          i = 0;
          continue;
          label972:
          if (localcje2.xTt.type == 2)
          {
            ((MallWalletSectionCellView)localObject2).oAC.setVisibility(8);
            ((MallWalletSectionCellView)localObject2).oAD.setVisibility(0);
            ((MallWalletSectionCellView)localObject2).oAE.setVisibility(8);
          }
          else if (localcje2.xTt.type == 3)
          {
            ((MallWalletSectionCellView)localObject2).oAE.setText(com.tencent.mm.plugin.wallet_core.utils.e.a(((MallWalletSectionCellView)localObject2).getContext(), localcje2.xTt.wNE));
            ((MallWalletSectionCellView)localObject2).oAC.setVisibility(8);
            ((MallWalletSectionCellView)localObject2).oAD.setVisibility(8);
            ((MallWalletSectionCellView)localObject2).oAE.setVisibility(0);
          }
          else
          {
            ((MallWalletSectionCellView)localObject2).bOQ();
            continue;
            ((MallWalletSectionCellView)localObject2).bOQ();
            continue;
            label1100:
            ((MallWalletSectionCellView)localObject2).bOQ();
            continue;
            label1108:
            ((MallWalletSectionCellView)localObject2).ksW.setVisibility(8);
            continue;
            label1121:
            if ("lqt_cell".equals(localcje2.wug))
            {
              this.oAR.oAX = ((MallWalletSectionCellView)localObject2).oAz;
              this.oAR.oAZ = ((MallWalletSectionCellView)localObject2).oAH;
            }
          }
        }
      }
    }
    label1162:
    AppMethodBeat.o(43276);
  }
  
  private void cm(List<cjw> paramList)
  {
    AppMethodBeat.i(43275);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(43275);
      return;
    }
    this.oAN.removeAllViews();
    paramList.size();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (cjw)paramList.next();
      TextView localTextView = new TextView(this);
      com.tencent.mm.plugin.wallet_core.utils.e.a(localTextView, (cjw)localObject, new MallWalletUI.3(this));
      localObject = new LinearLayout.LayoutParams(-2, -2);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).topMargin = a.fromDPToPix(this, 8);
      }
      this.oAN.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      i += 1;
    }
    AppMethodBeat.o(43275);
  }
  
  private void ji(boolean paramBoolean)
  {
    AppMethodBeat.i(142113);
    ab.i("MicroMsg.MallWalletUI", "do query wechat wallet");
    this.mProgressDialog = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    this.oAR.b(null);
    i.a(this.oAQ, true, paramBoolean, 3);
    AppMethodBeat.o(142113);
  }
  
  public int getLayoutId()
  {
    return 2130970115;
  }
  
  public void initView()
  {
    AppMethodBeat.i(43269);
    this.oAM = ((LinearLayout)findViewById(2131826081));
    this.oAN = ((LinearLayout)findViewById(2131826082));
    AppMethodBeat.o(43269);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(43273);
    ab.i("MicroMsg.MallWalletUI", "requestCode: %s, resultCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 65281) || (paramInt1 == 65286))
    {
      ji(false);
      AppMethodBeat.o(43273);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(43273);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(43268);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(Color.parseColor("#f7f7f7"));
    hideActionbarLine();
    setMMTitle("");
    initView();
    this.oAR = new MallWalletUI.a(this, (byte)0);
    this.oAQ = new i.a()
    {
      public final void a(cjf paramAnonymouscjf)
      {
        AppMethodBeat.i(43264);
        ab.i("MicroMsg.MallWalletUI", "cache callback: %s", new Object[] { paramAnonymouscjf });
        if (MallWalletUI.a(MallWalletUI.this) != null)
        {
          MallWalletUI.a(MallWalletUI.this).dismiss();
          MallWalletUI.b(MallWalletUI.this);
        }
        MallWalletUI.a(MallWalletUI.this, paramAnonymouscjf);
        MallWalletUI.c(MallWalletUI.this);
        AppMethodBeat.o(43264);
      }
      
      public final void b(bqq paramAnonymousbqq)
      {
        AppMethodBeat.i(43265);
        ab.i("MicroMsg.MallWalletUI", "net callback: %s", new Object[] { paramAnonymousbqq });
        if (MallWalletUI.a(MallWalletUI.this) != null)
        {
          MallWalletUI.a(MallWalletUI.this).dismiss();
          MallWalletUI.b(MallWalletUI.this);
        }
        if (paramAnonymousbqq != null)
        {
          if (paramAnonymousbqq.xEK != null)
          {
            MallWalletUI.a(MallWalletUI.this, paramAnonymousbqq.xEK);
            MallWalletUI.c(MallWalletUI.this);
            MallWalletUI.a locala = MallWalletUI.d(MallWalletUI.this);
            locala.oBa = true;
            if (locala.oAW != null) {
              locala.oAW.setVisibility(0);
            }
            if (locala.oAX != null) {
              locala.oAX.setVisibility(0);
            }
            if (locala.oAY != null) {
              locala.oAY.setVisibility(8);
            }
            if (locala.oAZ != null) {
              locala.oAZ.setVisibility(8);
            }
          }
          if ((paramAnonymousbqq.wna != null) && (paramAnonymousbqq.wna.type == 13)) {
            MallWalletUI.this.runOnUiThread(new MallWalletUI.1.1(this, paramAnonymousbqq));
          }
        }
        AppMethodBeat.o(43265);
      }
    };
    ji(true);
    AppMethodBeat.o(43268);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(43272);
    super.onDestroy();
    i.a(this.oAQ);
    AppMethodBeat.o(43272);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(43271);
    super.onPause();
    AppMethodBeat.o(43271);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(43270);
    super.onResume();
    AppMethodBeat.o(43270);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletUI
 * JD-Core Version:    0.7.0.1
 */