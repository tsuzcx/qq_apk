package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.card.b.c.a;
import com.tencent.mm.plugin.card.b.d.a;
import com.tencent.mm.plugin.card.b.g.a;
import com.tencent.mm.plugin.card.b.i.a;
import com.tencent.mm.plugin.card.b.j.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.aa;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.card.ui.view.x;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.MMVerticalTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CardDetailUI
  extends CardDetailBaseUI
  implements com.tencent.mm.ai.f, c.a, d.a, j.a, bc.a
{
  private final String TAG;
  private b.a dZA;
  private float dZu;
  private float dZv;
  private com.tencent.mm.ui.base.p ehb;
  private int ejF;
  private String fhC;
  private com.tencent.mm.modelgeo.d fwu;
  private String kkW;
  private com.tencent.mm.plugin.card.base.b klk;
  private ArrayList<oz> klq;
  private String kmh;
  private boolean kmw;
  private int kqC;
  private Vibrator kqP;
  private boolean kqQ;
  private boolean krM;
  private int ksF;
  private String ksG;
  private String ksH;
  private String ksI;
  e ktb;
  private String ktc;
  private String ktd;
  private String kte;
  private boolean ktf;
  private boolean ktg;
  private boolean kth;
  private String kti;
  private e.a ktj;
  private boolean ktk;
  private boolean ktl;
  private boolean ktm;
  private boolean ktn;
  private String kto;
  private com.tencent.mm.plugin.card.b.i ktp;
  ak mHandler;
  private long mStartTime;
  private View xy;
  
  public CardDetailUI()
  {
    AppMethodBeat.i(88286);
    this.TAG = "MicroMsg.CardDetailUI";
    this.ehb = null;
    this.kkW = "";
    this.kmh = "";
    this.ktc = "";
    this.ktd = "";
    this.kte = "";
    this.ksG = "";
    this.ksH = "";
    this.ksI = "";
    this.kmw = false;
    this.ktf = false;
    this.ktg = false;
    this.kth = false;
    this.fhC = "";
    this.kti = "";
    this.kqQ = false;
    this.mHandler = new ak();
    this.ejF = 3;
    this.ksF = 0;
    this.kqC = -1;
    this.ktk = false;
    this.ktl = true;
    this.mStartTime = 0L;
    this.ktm = false;
    this.krM = false;
    this.ktn = false;
    this.dZu = -85.0F;
    this.dZv = -1000.0F;
    this.kto = "";
    this.ktp = new com.tencent.mm.plugin.card.b.i();
    this.dZA = new CardDetailUI.1(this);
    AppMethodBeat.o(88286);
  }
  
  /* Error */
  private void HA(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 171
    //   4: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 121	com/tencent/mm/plugin/card/ui/CardDetailUI:kqQ	Z
    //   11: ifeq +18 -> 29
    //   14: ldc 85
    //   16: ldc 173
    //   18: invokestatic 179	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 171
    //   23: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: ldc 85
    //   31: ldc 181
    //   33: invokestatic 183	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 121	com/tencent/mm/plugin/card/ui/CardDetailUI:kqQ	Z
    //   41: new 185	android/content/Intent
    //   44: dup
    //   45: aload_0
    //   46: ldc 187
    //   48: invokespecial 190	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   51: astore_2
    //   52: aload_2
    //   53: ldc 192
    //   55: aload_0
    //   56: getfield 194	com/tencent/mm/plugin/card/ui/CardDetailUI:klk	Lcom/tencent/mm/plugin/card/base/b;
    //   59: invokeinterface 200 1 0
    //   64: invokevirtual 204	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   67: pop
    //   68: aload_2
    //   69: ldc 206
    //   71: aload_1
    //   72: invokevirtual 204	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   75: pop
    //   76: aload_2
    //   77: ldc 208
    //   79: aload_0
    //   80: getfield 194	com/tencent/mm/plugin/card/ui/CardDetailUI:klk	Lcom/tencent/mm/plugin/card/base/b;
    //   83: invokeinterface 212 1 0
    //   88: getfield 217	com/tencent/mm/protocal/protobuf/pg:color	Ljava/lang/String;
    //   91: invokevirtual 204	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   94: pop
    //   95: aload_2
    //   96: ldc 219
    //   98: aload_0
    //   99: getfield 128	com/tencent/mm/plugin/card/ui/CardDetailUI:ejF	I
    //   102: invokevirtual 222	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   105: pop
    //   106: aload_2
    //   107: ldc 224
    //   109: iconst_0
    //   110: invokevirtual 222	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   113: pop
    //   114: aload_0
    //   115: aload_2
    //   116: invokevirtual 228	com/tencent/mm/plugin/card/ui/CardDetailUI:startActivity	(Landroid/content/Intent;)V
    //   119: ldc 171
    //   121: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: goto -98 -> 26
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	CardDetailUI
    //   0	132	1	paramString	String
    //   51	65	2	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   2	26	127	finally
    //   29	124	127	finally
  }
  
  private void a(j.b paramb)
  {
    AppMethodBeat.i(88320);
    if (this.ktb.cvo)
    {
      ab.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
      AppMethodBeat.o(88320);
      return;
    }
    ab.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
    this.ktb.a(this.kth, paramb, true);
    AppMethodBeat.o(88320);
  }
  
  private void baB()
  {
    AppMethodBeat.i(88308);
    if (this.fwu == null) {
      this.fwu = com.tencent.mm.modelgeo.d.agQ();
    }
    this.fwu.a(this.dZA, true);
    AppMethodBeat.o(88308);
  }
  
  private void baD()
  {
    AppMethodBeat.i(88309);
    if (this.fwu != null) {
      this.fwu.c(this.dZA);
    }
    AppMethodBeat.o(88309);
  }
  
  private void bcI()
  {
    AppMethodBeat.i(88297);
    this.ktj.ejF = this.ejF;
    this.ktj.kqC = this.kqC;
    this.ktj.kkW = this.kkW;
    this.ktb.a(this.klk, this.ktj, this.klq);
    this.ktb.bcI();
    am.bco().klk = this.klk;
    AppMethodBeat.o(88297);
  }
  
  private void bcS()
  {
    AppMethodBeat.i(88310);
    this.fwu = com.tencent.mm.modelgeo.d.agQ();
    baB();
    AppMethodBeat.o(88310);
  }
  
  private void bdi()
  {
    AppMethodBeat.i(88292);
    com.tencent.mm.kernel.g.RK().eHt.a(645, this);
    com.tencent.mm.kernel.g.RK().eHt.a(651, this);
    com.tencent.mm.kernel.g.RK().eHt.a(563, this);
    com.tencent.mm.kernel.g.RK().eHt.a(652, this);
    com.tencent.mm.kernel.g.RK().eHt.a(560, this);
    com.tencent.mm.kernel.g.RK().eHt.a(699, this);
    com.tencent.mm.kernel.g.RK().eHt.a(902, this);
    com.tencent.mm.kernel.g.RK().eHt.a(904, this);
    com.tencent.mm.kernel.g.RK().eHt.a(1163, this);
    AppMethodBeat.o(88292);
  }
  
  private void bdj()
  {
    AppMethodBeat.i(88293);
    com.tencent.mm.kernel.g.RK().eHt.b(645, this);
    com.tencent.mm.kernel.g.RK().eHt.b(651, this);
    com.tencent.mm.kernel.g.RK().eHt.b(563, this);
    com.tencent.mm.kernel.g.RK().eHt.b(652, this);
    com.tencent.mm.kernel.g.RK().eHt.b(560, this);
    com.tencent.mm.kernel.g.RK().eHt.b(699, this);
    com.tencent.mm.kernel.g.RK().eHt.b(902, this);
    com.tencent.mm.kernel.g.RK().eHt.b(904, this);
    com.tencent.mm.kernel.g.RK().eHt.b(1163, this);
    AppMethodBeat.o(88293);
  }
  
  private void bdk()
  {
    AppMethodBeat.i(88295);
    this.kqC = this.ejF;
    this.ktj = new e.a();
    this.ktj.ejF = this.ejF;
    this.ktj.kqC = this.kqC;
    this.ktj.kkW = this.kkW;
    this.ktj.ktc = this.ktc;
    this.ktj.kte = this.kte;
    this.ktj.ktd = this.ktd;
    this.ktj.ksG = this.ksG;
    this.ktj.ksH = this.ksH;
    this.ktj.kmw = this.kmw;
    this.ktj.kua = getIntent().getIntExtra("key_from_appbrand_type", 0);
    AppMethodBeat.o(88295);
  }
  
  private void bdl()
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(88296);
    if ((this.ktm) || (this.klk == null))
    {
      AppMethodBeat.o(88296);
      return;
    }
    this.ktm = true;
    if (this.kmw)
    {
      localh = com.tencent.mm.plugin.report.service.h.qsU;
      j = this.klk.bbd().iFL;
      str1 = this.klk.bbi();
      str2 = this.klk.bbh();
      k = this.kqC;
      str3 = this.ktc;
      if (this.klk.bbb()) {}
      for (;;)
      {
        localh.e(11324, new Object[] { "ShareCardDetailUI", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
        AppMethodBeat.o(88296);
        return;
        i = 0;
      }
    }
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
    int k = this.klk.bbd().iFL;
    String str1 = this.klk.bbi();
    String str2 = this.klk.bbh();
    int m = this.kqC;
    String str3 = this.ktc;
    if (this.klk.bbb()) {}
    for (i = j;; i = 0)
    {
      localh.e(11324, new Object[] { "CardDetailView", Integer.valueOf(k), str1, str2, Integer.valueOf(0), Integer.valueOf(m), str3, Integer.valueOf(i), "" });
      AppMethodBeat.o(88296);
      return;
    }
  }
  
  private void bdm()
  {
    AppMethodBeat.i(88302);
    Object localObject = new cgd();
    ((cgd)localObject).xQS = this.fhC;
    ((cgd)localObject).kny = this.kti;
    ab.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", new Object[] { this.fhC });
    localObject = new aa(this.kkW, this.ejF, this.ktc, this.kte, this.ksG, this.ksH, this.ksF, this.ksI, (cgd)localObject);
    com.tencent.mm.kernel.g.RK().eHt.a((com.tencent.mm.ai.m)localObject, 0);
    AppMethodBeat.o(88302);
  }
  
  private void bdn()
  {
    AppMethodBeat.i(88303);
    Object localObject;
    if (!TextUtils.isEmpty(this.klk.bbi())) {
      localObject = this.klk.bbi();
    }
    while ((this.klk != null) && (this.klk.bbd().wGd == 1))
    {
      float f2 = this.dZu;
      float f3 = this.dZv;
      float f1;
      if (f2 != -85.0F)
      {
        f1 = f3;
        if (f3 != -1000.0F) {}
      }
      else
      {
        f2 = am.bcj().dZu;
        f1 = am.bcj().dZv;
      }
      localObject = new v((String)localObject, f1, f2, this.klk.bbh());
      com.tencent.mm.kernel.g.RK().eHt.a((com.tencent.mm.ai.m)localObject, 0);
      AppMethodBeat.o(88303);
      return;
      if (!TextUtils.isEmpty(this.kkW))
      {
        localObject = this.kkW;
      }
      else
      {
        ab.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
        AppMethodBeat.o(88303);
        return;
      }
    }
    if ((this.klk != null) && (this.klk.bbd().wGd > 1))
    {
      if ((this.dZu != -85.0F) && (this.dZv != -1000.0F))
      {
        this.ktn = false;
        localObject = new v((String)localObject, this.dZv, this.dZu, this.klk.bbh());
        com.tencent.mm.kernel.g.RK().eHt.a((com.tencent.mm.ai.m)localObject, 0);
        AppMethodBeat.o(88303);
        return;
      }
      if (!this.ktn)
      {
        this.ktn = true;
        if (this.krM)
        {
          baB();
          AppMethodBeat.o(88303);
        }
      }
    }
    else if (this.klk != null)
    {
      this.klk.a(null);
      bcI();
      if (this.klk.baK())
      {
        localObject = am.bcl().HZ(this.kkW);
        if (localObject != null)
        {
          ((ShareCardInfo)localObject).a(null);
          am.bcl().update((com.tencent.mm.sdk.e.c)localObject, new String[] { this.kkW });
        }
        AppMethodBeat.o(88303);
        return;
      }
      localObject = am.bcd().HJ(this.kkW);
      if (localObject != null)
      {
        ((CardInfo)localObject).a(null);
        am.bcd().update((com.tencent.mm.sdk.e.c)localObject, new String[] { this.kkW });
      }
    }
    AppMethodBeat.o(88303);
  }
  
  private void bdo()
  {
    AppMethodBeat.i(88304);
    com.tencent.mm.plugin.card.sharecard.model.c localc = new com.tencent.mm.plugin.card.sharecard.model.c(this.kkW);
    com.tencent.mm.kernel.g.RK().eHt.a(localc, 0);
    AppMethodBeat.o(88304);
  }
  
  private void c(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(88299);
    ab.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + paramInt1 + " errMsg = " + paramString1 + " ret_code:" + paramInt2 + " ret_msg:" + paramString2);
    if (paramInt2 == 10000)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = getString(2131297859);
      }
      this.klk.bbe().status = 4;
      bcI();
    }
    for (;;)
    {
      com.tencent.mm.plugin.card.d.d.c(this, paramString1);
      AppMethodBeat.o(88299);
      return;
      if (paramInt2 == 10001)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(2131297863);
        }
        this.klk.bbe().status = 5;
        bcI();
      }
      else if (paramInt2 == 10002)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(2131298004);
        }
      }
      else
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(2131297857);
        }
      }
    }
  }
  
  private void fV(boolean paramBoolean)
  {
    AppMethodBeat.i(88300);
    if (paramBoolean)
    {
      this.ehb = com.tencent.mm.ui.base.p.b(this, getString(2131301086), true, null);
      AppMethodBeat.o(88300);
      return;
    }
    if ((this.ehb != null) && (this.ehb.isShowing()))
    {
      this.ehb.dismiss();
      this.ehb = null;
    }
    AppMethodBeat.o(88300);
  }
  
  private void fZ(boolean paramBoolean)
  {
    AppMethodBeat.i(88301);
    if (paramBoolean) {
      com.tencent.mm.plugin.card.d.l.dz(this.ktb.ktP, this.ktb.ktO);
    }
    AppMethodBeat.o(88301);
  }
  
  private void q(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(88306);
    Intent localIntent;
    if (paramInt == 1)
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.kto);
      localIntent.putExtra("key_card_id", this.kkW);
      localIntent.putExtra("key_finish_action", paramInt);
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(88306);
      return;
    }
    if (((this.kqC == 7) || (this.kqC == 8) || (this.kqC == 16) || (this.kqC == 26)) && (this.ejF == 3))
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.kto);
      if (paramInt > 0)
      {
        localIntent.putExtra("key_card_id", this.kkW);
        localIntent.putExtra("key_finish_action", paramInt);
      }
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(88306);
      return;
    }
    if (((this.kqC == 7) && (this.ejF == 7)) || ((this.kqC == 16) && (this.ejF == 16)) || ((this.kqC == 8) && (this.ejF == 8)) || ((this.kqC == 26) && (this.ejF == 26)))
    {
      setResult(0);
      if (paramBoolean)
      {
        finish();
        AppMethodBeat.o(88306);
      }
    }
    else if (paramBoolean)
    {
      finish();
    }
    AppMethodBeat.o(88306);
  }
  
  private void ti(int paramInt)
  {
    AppMethodBeat.i(88307);
    if ((this.kqC != 7) && (this.kqC != 16))
    {
      ab.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
      AppMethodBeat.o(88307);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new com.tencent.mm.plugin.card.model.e();
    ((com.tencent.mm.plugin.card.model.e)localObject).kml = this.klk.bbi();
    ((com.tencent.mm.plugin.card.model.e)localObject).cHo = this.kte;
    ((com.tencent.mm.plugin.card.model.e)localObject).code = this.kto;
    localLinkedList.add(localObject);
    localObject = new com.tencent.mm.g.a.b();
    ((com.tencent.mm.g.a.b)localObject).clZ.bpE = paramInt;
    if (paramInt == -1) {}
    for (((com.tencent.mm.g.a.b)localObject).clZ.cma = com.tencent.mm.plugin.card.d.h.a(localLinkedList, true, this.kqC);; ((com.tencent.mm.g.a.b)localObject).clZ.cma = com.tencent.mm.plugin.card.d.h.a(localLinkedList, false, this.kqC))
    {
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(88307);
      return;
    }
  }
  
  public final void HB(String paramString)
  {
    AppMethodBeat.i(88316);
    if (!this.ktb.bdT())
    {
      ab.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
      AppMethodBeat.o(88316);
      return;
    }
    ab.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
    this.mHandler.post(new CardDetailUI.5(this, paramString));
    AppMethodBeat.o(88316);
  }
  
  public final void HE(String paramString)
  {
    AppMethodBeat.i(88319);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.kkW)))
    {
      ab.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(88319);
      return;
    }
    this.ktf = false;
    AppMethodBeat.o(88319);
  }
  
  public final void Hy(String paramString)
  {
    AppMethodBeat.i(88322);
    if (!TextUtils.isEmpty(paramString)) {
      com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    }
    AppMethodBeat.o(88322);
  }
  
  public final void aNW()
  {
    AppMethodBeat.i(88290);
    com.tencent.mm.plugin.card.ui.view.g localg = this.ktb.ktz;
    if (localg != null) {
      localg.bfu();
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(16827, new Object[] { this.kkW, Long.valueOf(System.currentTimeMillis() / 1000L) });
    AppMethodBeat.o(88290);
  }
  
  public final void b(String paramString, j.b paramb)
  {
    AppMethodBeat.i(88317);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.kkW)))
    {
      ab.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(88317);
      return;
    }
    fV(false);
    ab.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
    ab.i("MicroMsg.CardDetailUI", "markSucc:" + paramb.klZ + " markCardId: " + paramb.kma);
    this.ktg = false;
    if (paramb.klZ == 1)
    {
      if ((!TextUtils.isEmpty(paramb.kma)) && (!this.klk.bbh().equals(paramb.kma)))
      {
        ab.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
        if (this.klk.baK())
        {
          paramString = am.bcl().HZ(paramb.kma);
          if (paramString != null)
          {
            this.klk = paramString;
            this.kkW = paramb.kma;
            bcI();
            am.bco().b(this.klk);
            ab.i("MicroMsg.CardDetailUI", "update the mCardInfo");
            this.ktf = true;
            a(paramb);
            AppMethodBeat.o(88317);
            return;
          }
          ab.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
          com.tencent.mm.plugin.card.d.d.c(this, getString(2131297984));
          this.ktf = false;
          AppMethodBeat.o(88317);
        }
      }
      else
      {
        ab.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
        this.ktf = true;
        a(paramb);
        AppMethodBeat.o(88317);
      }
    }
    else
    {
      this.ktf = false;
      com.tencent.mm.plugin.card.d.d.c(this, getString(2131297985));
    }
    AppMethodBeat.o(88317);
  }
  
  public final void bbC()
  {
    AppMethodBeat.i(88314);
    ab.i("MicroMsg.CardDetailUI", "onVibrate");
    this.kqP.vibrate(300L);
    AppMethodBeat.o(88314);
  }
  
  public final void bbD()
  {
    AppMethodBeat.i(88315);
    ab.i("MicroMsg.CardDetailUI", "onFinishUI");
    AppMethodBeat.o(88315);
  }
  
  public final void bbx()
  {
    AppMethodBeat.i(88321);
    ab.i("MicroMsg.CardDetailUI", "code change");
    if ((this.ktb.ktz instanceof q))
    {
      ((q)this.ktb.ktz).kxM = am.bcq().getCode();
      this.ktb.bcI();
    }
    AppMethodBeat.o(88321);
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(88313);
    if (paramb == null)
    {
      ab.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
      AppMethodBeat.o(88313);
      return;
    }
    if ((this.klk == null) || (!this.klk.bbh().equals(paramb.bbh())))
    {
      ab.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
      AppMethodBeat.o(88313);
      return;
    }
    if (!this.ktb.bdT())
    {
      ab.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
      AppMethodBeat.o(88313);
      return;
    }
    ab.i("MicroMsg.CardDetailUI", "onDataChange");
    this.klk = paramb;
    this.kkW = this.klk.bbh();
    if ((this.klk.baY()) && (am.bcq().isEmpty())) {
      am.bcq().Hz(this.klk.bbh());
    }
    bcI();
    AppMethodBeat.o(88313);
  }
  
  public final void jdMethod_do(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88318);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.kkW)))
    {
      ab.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(88318);
      return;
    }
    ab.i("MicroMsg.CardDetailUI", "onMarkFail()");
    this.ktf = false;
    this.ktg = false;
    fV(false);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(2131297984);
    }
    com.tencent.mm.plugin.card.d.d.c(this, paramString1);
    AppMethodBeat.o(88318);
  }
  
  public int getLayoutId()
  {
    return 2130968930;
  }
  
  public void initView()
  {
    AppMethodBeat.i(88294);
    setBackBtn(new CardDetailUI.2(this));
    this.kqP = ((Vibrator)getSystemService("vibrator"));
    this.xy = findViewById(2131822099);
    Object localObject2;
    if (this.ktb == null)
    {
      this.ktb = new e(this, getContentView());
      localObject1 = this.ktb;
      ((e)localObject1).ktL = new j(((e)localObject1).kts);
      localObject2 = ((e)localObject1).ktL;
      ((j)localObject2).kqy = ((j)localObject2).kxD.getWindow().getAttributes().screenBrightness;
      if (((j)localObject2).gMK == null)
      {
        localObject3 = View.inflate(((j)localObject2).kxD, 2130968978, null);
        ((j)localObject2).gMM = ((View)localObject3).findViewById(2131822317);
        ((j)localObject2).gML = ((ImageView)((View)localObject3).findViewById(2131822318));
        ((j)localObject2).kxF = ((TextView)((View)localObject3).findViewById(2131822319));
        ((j)localObject2).kxG = ((TextView)((View)localObject3).findViewById(2131822320));
        ((j)localObject2).kxH = ((View)localObject3).findViewById(2131822321);
        ((j)localObject2).kxI = ((ImageView)((View)localObject3).findViewById(2131822324));
        ((j)localObject2).kxJ = ((MMVerticalTextView)((View)localObject3).findViewById(2131822323));
        ((j)localObject2).kxK = ((MMVerticalTextView)((View)localObject3).findViewById(2131822322));
        ((View)localObject3).setOnClickListener(new j.2((j)localObject2));
        ((j)localObject2).gMK = new com.tencent.mm.ui.base.o((View)localObject3, -1, -1, true);
        ((j)localObject2).gMK.update();
        ((j)localObject2).gMK.setBackgroundDrawable(new ColorDrawable(16777215));
        ((j)localObject2).gMK.setOnDismissListener(new j.3((j)localObject2));
      }
      ((e)localObject1).kts.setMMTitle("");
      ((e)localObject1).kts.Q(-1, false);
      ((e)localObject1).ktN = new com.tencent.mm.plugin.card.b.f(((e)localObject1).kts);
      ((e)localObject1).kts.mmSetOnActivityResultCallback((MMActivity.a)localObject1);
      com.tencent.mm.sdk.b.a.ymk.c(((e)localObject1).ktW);
      localObject1 = this.ktb;
      if (((e)localObject1).ktu == null)
      {
        ((e)localObject1).ktu = new x();
        ((e)localObject1).ktu.a((n)localObject1);
      }
      if (((e)localObject1).ktw == null)
      {
        ((e)localObject1).ktw = new com.tencent.mm.plugin.card.ui.view.o();
        ((e)localObject1).ktw.a((n)localObject1);
      }
      if (((e)localObject1).ktx == null)
      {
        ((e)localObject1).ktx = new com.tencent.mm.plugin.card.ui.view.a();
        ((e)localObject1).ktx.a((n)localObject1);
      }
      ((e)localObject1).mListView = ((ListView)((e)localObject1).findViewById(2131822091));
      ((e)localObject1).ktA = new m(((e)localObject1).kts.getContext());
      ((e)localObject1).ktA.kyq = ((e)localObject1).gMO;
      ((e)localObject1).mListView.setAdapter(((e)localObject1).ktA);
      ((e)localObject1).ktA.notifyDataSetChanged();
      ((e)localObject1).mListView.setOnItemClickListener(new e.1((e)localObject1));
      ab.i("MicroMsg.CardDetailUIContoller", "initMenu");
      localObject2 = ((e)localObject1).kts;
      Object localObject3 = new e.5((e)localObject1);
      ((CardDetailBaseUI)localObject2).ksV.setOnClickListener((View.OnClickListener)localObject3);
      ((e)localObject1).eM = ((LinearLayout)((e)localObject1).findViewById(2131822075));
      ((e)localObject1).ktJ = new com.tencent.mm.plugin.card.ui.view.d();
      ((e)localObject1).ktJ.a((n)localObject1);
      ((e)localObject1).ktL.klk = ((e)localObject1).klk;
    }
    int i = getIntent().getIntExtra("key_from_scene", -1);
    ab.i("MicroMsg.CardDetailUI", "scene:%d", new Object[] { Integer.valueOf(i) });
    int j;
    if ((i == 2) || (i == 6) || (i == 5))
    {
      this.ejF = i;
      localObject1 = getIntent().getStringExtra("key_card_app_msg");
      localObject2 = com.tencent.mm.plugin.card.d.g.Iw((String)localObject1);
      if (localObject2 != null)
      {
        this.kkW = ((com.tencent.mm.plugin.card.model.d)localObject2).cHn;
        this.ktc = ((com.tencent.mm.plugin.card.model.d)localObject2).knu;
        this.kte = ((com.tencent.mm.plugin.card.model.d)localObject2).cHo;
        j = ((com.tencent.mm.plugin.card.model.d)localObject2).knx;
        ab.i("MicroMsg.CardDetailUI", "scene is " + i + ", isRecommend is " + j);
        if ((j == 1) && (i == 2)) {
          this.ejF = 23;
        }
        this.kti = ((com.tencent.mm.plugin.card.model.d)localObject2).kny;
        ab.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.kti);
      }
      this.ktd = com.tencent.mm.plugin.card.d.g.Ix((String)localObject1);
      bdk();
      if (!TextUtils.isEmpty(this.kkW)) {
        break label1826;
      }
      ab.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
      q(true, -1);
    }
    for (;;)
    {
      this.ktb.a(this.klk, this.ktj, this.klq);
      this.ktb.ktT = new CardDetailUI.3(this);
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
      ab.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      this.krM = bool;
      if (this.krM)
      {
        this.fwu = com.tencent.mm.modelgeo.d.agQ();
        baB();
      }
      AppMethodBeat.o(88294);
      return;
      if ((com.tencent.mm.plugin.card.d.l.tu(i)) || (i == 0) || (i == 1) || (i == 3) || (i == 4) || (i == 9) || (i == 12) || (i == 15) || (i == 17) || (i == 21))
      {
        this.ejF = i;
        this.kkW = getIntent().getStringExtra("key_card_id");
        this.kte = getIntent().getStringExtra("key_card_ext");
        this.kmw = getIntent().getBooleanExtra("key_is_share_card", false);
        this.ksF = getIntent().getIntExtra("key_stastic_scene", 0);
        this.ksI = getIntent().getStringExtra("key_consumed_card_id");
        if ((i == 7) || (i == 16))
        {
          this.ksG = getIntent().getStringExtra("src_username");
          this.ksH = getIntent().getStringExtra("js_url");
          this.fhC = getIntent().getStringExtra("key_template_id");
          break;
        }
        if ((this.kmw) && (i == 3))
        {
          this.kmh = getIntent().getStringExtra("key_card_tp_id");
          this.kkW = com.tencent.mm.plugin.card.sharecard.a.b.ds(this.kkW, this.kmh);
          break;
        }
        if (i != 8) {
          break;
        }
        this.ktk = getIntent().getBooleanExtra("key_is_sms_add_card", false);
        break;
      }
      if ((i == 50) || (i == 27))
      {
        this.ejF = getIntent().getIntExtra("key_previous_scene", 50);
        if ((this.ejF != 26) && (this.ejF != 27)) {
          this.ejF = 3;
        }
        this.fhC = getIntent().getStringExtra("key_template_id");
        if (this.ejF == 27)
        {
          localObject1 = (com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info");
          if (localObject1 != null)
          {
            this.klk = ((com.tencent.mm.plugin.card.base.b)localObject1);
            this.kkW = this.klk.bbh();
            bdk();
            bdn();
            if (this.klk.baY()) {
              am.bcq().Hz(this.klk.bbh());
            }
            bcI();
          }
          bdl();
          com.tencent.mm.plugin.card.d.l.bfz();
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.card.d.k.r(getIntent().getStringExtra("card_list"), this.ejF, "");
          if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
          {
            ab.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
            q(true, -1);
          }
          for (;;)
          {
            bdk();
            break;
            fV(true);
            this.kkW = ((ph)((LinkedList)localObject1).get(0)).kml;
            i = getIntent().getIntExtra("key_previous_scene", 51);
            localObject2 = new cgd();
            ((cgd)localObject2).xQS = this.fhC;
            ab.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.fhC });
            localObject1 = new t((LinkedList)localObject1, (cgd)localObject2, i, this.kkW);
            com.tencent.mm.kernel.g.RK().eHt.a((com.tencent.mm.ai.m)localObject1, 0);
          }
        }
      }
      else if (i == 51)
      {
        if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {}
        for (this.ejF = 26;; this.ejF = 3)
        {
          this.kkW = getIntent().getStringExtra("key_card_id");
          this.klk = am.bci().kkN;
          if (this.klk == null) {
            this.klk = am.bcd().HJ(this.kkW);
          }
          bdk();
          if (this.klk != null) {
            break label1674;
          }
          ab.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
          q(true, -1);
          break;
        }
        label1674:
        bdn();
        bcI();
        bdl();
        if (this.klk.baY()) {
          am.bcq().Hz(this.klk.bbh());
        }
      }
      else
      {
        if (i == 26)
        {
          this.ejF = i;
          this.kkW = getIntent().getStringExtra("key_card_id");
          this.kte = getIntent().getStringExtra("key_card_ext");
          break;
        }
        this.ejF = i;
        localObject1 = getIntent().getStringExtra("key_card_app_msg");
        localObject2 = com.tencent.mm.plugin.card.d.g.Iw((String)localObject1);
        if (localObject2 != null)
        {
          this.kkW = ((com.tencent.mm.plugin.card.model.d)localObject2).cHn;
          this.ktc = ((com.tencent.mm.plugin.card.model.d)localObject2).knu;
          this.kte = ((com.tencent.mm.plugin.card.model.d)localObject2).cHo;
        }
        this.ktd = com.tencent.mm.plugin.card.d.g.Ix((String)localObject1);
        break;
        label1826:
        if ((i == 2) || (i == 6) || ((i == 4) && (!this.kmw)) || (i == 5) || (i == 17) || (i == 21) || (i == 23)) {
          i = 1;
        }
        for (;;)
        {
          if ((i == 0) && (this.klk != null)) {
            break label2051;
          }
          ab.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.kkW + " isShareCard is " + this.kmw);
          fV(true);
          this.xy.setVisibility(0);
          if (!this.kmw) {
            break label2044;
          }
          bdo();
          break;
          if (i == 15)
          {
            localObject1 = am.bci().getValue("key_accept_card_info");
            if ((localObject1 != null) && ((localObject1 instanceof CardInfo)))
            {
              this.klk = ((CardInfo)localObject1);
              i = 0;
            }
            else
            {
              i = 1;
            }
          }
          else if (this.kmw)
          {
            this.klk = am.bcl().HZ(this.kkW);
            i = 0;
          }
          else
          {
            this.klk = am.bcd().HJ(this.kkW);
            i = 0;
          }
        }
        label2044:
        bdm();
      }
    }
    label2051:
    ab.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.kkW);
    Object localObject1 = this.klk.bbg();
    if (localObject1 != null)
    {
      this.klq = new ArrayList();
      this.klq.add(localObject1);
    }
    bcI();
    if (this.klk.baY()) {
      am.bcq().Hz(this.klk.bbh());
    }
    if (this.kmw)
    {
      this.ktl = true;
      i = 1;
      label2158:
      if (i == 0) {
        break label2294;
      }
      ab.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.kkW + " isShareCard is " + this.kmw);
      if (!this.kmw) {
        break label2287;
      }
      bdo();
    }
    for (;;)
    {
      bdl();
      break;
      if ((int)(System.currentTimeMillis() / 1000L) - this.klk.bbk() >= 86400L) {}
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label2265;
        }
        this.ktl = true;
        i = 1;
        break;
      }
      label2265:
      if (!this.klk.baV()) {
        break label2158;
      }
      this.ktl = true;
      i = 1;
      break label2158;
      label2287:
      bdm();
      continue;
      label2294:
      bdn();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88287);
    super.onCreate(paramBundle);
    this.mStartTime = System.currentTimeMillis();
    bdi();
    paramBundle = am.bco();
    AppCompatActivity localAppCompatActivity = getContext();
    com.tencent.mm.kernel.g.RK().eHt.a(910, paramBundle);
    am.bck().a(paramBundle);
    com.tencent.mm.plugin.card.b.b localb = am.bcc();
    if (localb.kkV == null) {
      localb.kkV = new ArrayList();
    }
    localb.kkV.add(new WeakReference(paramBundle));
    paramBundle.aon = new WeakReference(localAppCompatActivity);
    am.bco().a(this);
    am.bcp().a(this);
    paramBundle = am.bcq();
    com.tencent.mm.kernel.g.RK().eHt.a(577, paramBundle);
    paramBundle.kkX.clear();
    paramBundle.kkY = 0;
    am.bcq().a(this);
    initView();
    AppMethodBeat.o(88287);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88291);
    am.bco().c(this);
    bdj();
    am.bco().b(this);
    am.bco().release();
    am.bcp().b(this);
    am.bcq().b(this);
    am.bcq().release();
    Object localObject1 = this.ktb;
    Object localObject2 = ((e)localObject1).ktN;
    ((com.tencent.mm.plugin.card.b.f)localObject2).klk = null;
    ((com.tencent.mm.plugin.card.b.f)localObject2).klo.clear();
    ((e)localObject1).ktN = null;
    localObject2 = ((e)localObject1).ktL;
    com.tencent.mm.plugin.card.d.l.I(((j)localObject2).kxE);
    int i = ((j)localObject2).kxL.size() - 1;
    while (i >= 0)
    {
      com.tencent.mm.plugin.card.d.l.I((Bitmap)((j)localObject2).kxL.remove(i));
      i -= 1;
    }
    ((j)localObject2).kxL.clear();
    if (((j)localObject2).gMK.isShowing()) {
      ((j)localObject2).gMK.dismiss();
    }
    ((j)localObject2).gMK = null;
    ((j)localObject2).bep();
    ((j)localObject2).kxD = null;
    ((j)localObject2).klk = null;
    ((e)localObject1).ktL = null;
    if (((e)localObject1).kty != null) {
      ((e)localObject1).kty.release();
    }
    ((e)localObject1).kts.mmSetOnActivityResultCallback(null);
    com.tencent.mm.sdk.b.a.ymk.d(((e)localObject1).ktW);
    ((e)localObject1).ktu.destroy();
    ((e)localObject1).ktx.destroy();
    ((e)localObject1).ktw.destroy();
    ((e)localObject1).ktJ.destroy();
    if (((e)localObject1).ktK != null) {
      ((e)localObject1).ktK.destroy();
    }
    if (((e)localObject1).ktC != null) {
      ((e)localObject1).ktC.destroy();
    }
    if (((e)localObject1).ktB != null) {
      ((e)localObject1).ktB.destroy();
    }
    if (((e)localObject1).ktD != null) {
      ((e)localObject1).ktD.destroy();
    }
    if (((e)localObject1).ktE != null) {
      ((e)localObject1).ktE.destroy();
    }
    if (((e)localObject1).ktF != null) {
      ((e)localObject1).ktF.destroy();
    }
    if (((e)localObject1).ktG != null) {
      ((e)localObject1).ktG.destroy();
    }
    if (((e)localObject1).ktH != null) {
      ((e)localObject1).ktH.destroy();
    }
    if (((e)localObject1).ktI != null) {
      ((e)localObject1).ktI.destroy();
    }
    if (((e)localObject1).ktz != null) {
      ((e)localObject1).ktz.destroy();
    }
    ((e)localObject1).ktt = null;
    localObject2 = am.bct();
    if (((com.tencent.mm.plugin.card.b.g)localObject2).kkV != null)
    {
      i = 0;
      if (i < ((com.tencent.mm.plugin.card.b.g)localObject2).kkV.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.card.b.g)localObject2).kkV.get(i);
        if (localWeakReference == null) {
          break label748;
        }
        g.a locala = (g.a)localWeakReference.get();
        if ((locala == null) || (!locala.equals(localObject1))) {
          break label748;
        }
        ((com.tencent.mm.plugin.card.b.g)localObject2).kkV.remove(localWeakReference);
      }
    }
    am.bct().release();
    this.kqP.cancel();
    baD();
    long l = System.currentTimeMillis() - this.mStartTime;
    if (this.klk != null)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(13219, new Object[] { "CardDetailView", Integer.valueOf(this.ejF), this.klk.bbi(), this.klk.bbh(), Long.valueOf(l) });
      label611:
      if (((this.ktf) || (this.ktg)) && (this.klk != null) && (this.klk.baK()))
      {
        if (!this.klk.baX()) {
          break label808;
        }
        am.bcp().bN(this.kkW, 2);
      }
      label667:
      localObject1 = this.ktp;
      ab.i("MicroMsg.CardLbsOrBluetooth", "uninit");
      if (((com.tencent.mm.plugin.card.b.i)localObject1).klB != null)
      {
        localObject2 = ((com.tencent.mm.plugin.card.b.i)localObject1).klB;
        if (((i.a)localObject2).hFt != null) {
          break label822;
        }
        ab.e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.b.i)localObject1).klB = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).bbK();
      ((com.tencent.mm.plugin.card.b.i)localObject1).klG = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).klu = null;
      super.onDestroy();
      AppMethodBeat.o(88291);
      return;
      label748:
      i += 1;
      break;
      com.tencent.mm.plugin.report.service.h.qsU.e(13219, new Object[] { "CardDetailView", Integer.valueOf(this.ejF), this.kkW, this.kkW, Long.valueOf(l) });
      break label611;
      label808:
      am.bcp().bN(this.kkW, 1);
      break label667;
      label822:
      ah.getContext().unregisterReceiver(((i.a)localObject2).hFt);
      ((i.a)localObject2).hFt = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(88305);
    if (paramInt == 4)
    {
      ab.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
      q(false, -1);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(88305);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(88289);
    bdj();
    super.onPause();
    this.ktb.cvo = true;
    am.bco().a(this, false);
    bc.a(this, null);
    com.tencent.mm.plugin.card.b.i locali = this.ktp;
    if (locali.bbN())
    {
      ab.i("MicroMsg.CardLbsOrBluetooth", "stop");
      if (locali.klB != null) {
        locali.klB.bbQ();
      }
      locali.bbK();
      com.tencent.mm.kernel.g.RK().eHt.b(2574, locali);
    }
    AppMethodBeat.o(88289);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(88311);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(88311);
      return;
    }
    ab.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88311);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ab.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.krM);
        if (!this.krM)
        {
          this.krM = true;
          bcS();
        }
        AppMethodBeat.o(88311);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131298499), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(88284);
          CardDetailUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
          AppMethodBeat.o(88284);
        }
      }, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(88288);
    super.onResume();
    bdi();
    if (this.fwu != null) {
      this.fwu.a(this.dZA, true);
    }
    this.ktb.cvo = false;
    bc.a(this, this);
    am.bco().a(this, true);
    Object localObject;
    int i;
    if (((this.ktf) || (this.ktg)) && (this.klk.baK()))
    {
      if (!this.klk.baX()) {
        break label224;
      }
      am.bcp().bN(this.kkW, 2);
      localObject = am.bco();
      String str = this.kkW;
      localObject = (Boolean)((com.tencent.mm.plugin.card.b.d)localObject).klj.get(str);
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
        break label208;
      }
      i = 1;
      if ((i == 0) || (TextUtils.isEmpty(am.bco().klm))) {
        break label213;
      }
      ab.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
      HB(am.bco().klm);
      label171:
      this.ktb.ktz.d(com.tencent.mm.plugin.card.d.c.kCb);
    }
    for (;;)
    {
      if (this.ktp.bRB) {
        this.ktp.start();
      }
      AppMethodBeat.o(88288);
      return;
      label208:
      i = 0;
      break;
      label213:
      ab.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
      break label171;
      label224:
      am.bcp().bN(this.kkW, 1);
      localObject = this.ktb.ktz;
      if (localObject != null) {
        ((com.tencent.mm.plugin.card.ui.view.g)localObject).d(com.tencent.mm.plugin.card.d.c.kCb);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(88298);
    ab.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      fV(false);
      this.xy.setVisibility(8);
      Object localObject;
      if ((paramm instanceof aa))
      {
        paramString = ((aa)paramm).koi;
        if (TextUtils.isEmpty(paramString))
        {
          ab.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
          AppMethodBeat.o(88298);
          return;
        }
        paramm = this.klk;
        localObject = new CardInfo();
        com.tencent.mm.plugin.card.d.f.a((CardInfo)localObject, paramString);
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bbh()))
        {
          this.kkW = ((com.tencent.mm.plugin.card.base.b)localObject).bbh();
          this.klk = ((com.tencent.mm.plugin.card.base.b)localObject);
          bdn();
          if (this.ejF == 3)
          {
            if (paramm != null)
            {
              ((CardInfo)this.klk).field_stickyAnnouncement = ((CardInfo)paramm).field_stickyAnnouncement;
              ((CardInfo)this.klk).field_stickyEndTime = ((CardInfo)paramm).field_stickyEndTime;
              ((CardInfo)this.klk).field_stickyIndex = ((CardInfo)paramm).field_stickyIndex;
              ((CardInfo)this.klk).field_label_wording = ((CardInfo)paramm).field_label_wording;
              this.klk.a(paramm.bbg());
            }
            if (!this.ktl) {
              break label405;
            }
            com.tencent.mm.plugin.card.d.l.h(this.klk);
          }
        }
        for (;;)
        {
          bcI();
          bdl();
          if (this.klk.baY()) {
            am.bcq().Hz(this.klk.bbh());
          }
          this.ktp.a(this, this.kkW, this.klk, this.dZu, this.dZv);
          AppMethodBeat.o(88298);
          return;
          if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bbh())) || (this.kkW.equals(((com.tencent.mm.plugin.card.base.b)localObject).bbi()))) {
            break;
          }
          ab.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.kkW, ((com.tencent.mm.plugin.card.base.b)localObject).bbi() });
          AppMethodBeat.o(88298);
          return;
          label405:
          ab.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.card.model.o))
      {
        if (this.kqC == 26) {
          fV(false);
        }
        localObject = ((com.tencent.mm.plugin.card.model.o)paramm).koi;
        paramInt1 = ((com.tencent.mm.plugin.card.model.o)paramm).koj;
        paramm = ((com.tencent.mm.plugin.card.model.o)paramm).kok;
        if (paramInt1 != 0) {
          c(paramInt2, paramString, paramInt1, paramm);
        }
        while (TextUtils.isEmpty((CharSequence)localObject))
        {
          ab.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
          AppMethodBeat.o(88298);
          return;
          com.tencent.mm.ui.base.h.bO(this, getResources().getString(2131297870));
        }
        this.ejF = 3;
        if (this.klk == null) {
          this.klk = new CardInfo();
        }
        com.tencent.mm.plugin.card.d.f.a((CardInfo)this.klk, (String)localObject);
        if (!TextUtils.isEmpty(this.klk.bbh())) {
          this.kkW = this.klk.bbh();
        }
        if (this.ktb.bdS() == 1)
        {
          paramString = this.ktb;
          if (paramString.ktN != null)
          {
            paramString = paramString.ktN;
            if (paramString.klp != null) {
              paramString.klp.kmz = false;
            }
          }
        }
        if (this.kqC != 26)
        {
          bdn();
          bcI();
        }
        com.tencent.mm.plugin.card.d.l.bfz();
        paramString = this.klk;
        if (paramString.baL())
        {
          paramm = (Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yzg, Integer.valueOf(0));
          if ((paramm == null) || (paramm.intValue() != 1))
          {
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yzg, Integer.valueOf(1));
            if (!com.tencent.mm.plugin.card.d.l.bfC()) {
              break label908;
            }
            com.tencent.mm.plugin.card.d.d.c(this, 2130968998, 2131297867, paramString.bbd().knv);
          }
          label737:
          this.kto = this.klk.bbn();
          if ((this.kqC != 7) && (this.kqC != 16)) {
            break label930;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.kto);
          setResult(-1, paramString);
          ti(-1);
        }
        for (;;)
        {
          if (this.klk.baY()) {
            am.bcq().Hz(this.klk.bbh());
          }
          this.ktp.a(this, this.kkW, this.klk, this.dZu, this.dZv);
          AppMethodBeat.o(88298);
          return;
          paramm = (Integer)com.tencent.mm.kernel.g.RL().Ru().get(282884, null);
          if ((paramm != null) && (paramm.intValue() == 1)) {
            break label737;
          }
          com.tencent.mm.kernel.g.RL().Ru().set(282884, Integer.valueOf(1));
          break;
          label908:
          com.tencent.mm.plugin.card.d.d.c(this, 2130968997, 2131297866, paramString.bbd().knv);
          break label737;
          label930:
          if ((!this.ktk) && (this.kqC == 8)) {
            q(true, -1);
          } else if ((this.kqC == 26) && (paramInt1 == 0)) {
            q(true, -1);
          }
        }
      }
      if ((paramm instanceof v))
      {
        this.klq = ((v)paramm).kor;
        if ((this.klk != null) && (this.klq != null) && (this.klq.size() > 0))
        {
          this.klk.a((oz)this.klq.get(0));
          bcI();
          if (this.klk.baK())
          {
            paramString = am.bcl().HZ(this.kkW);
            if (paramString != null)
            {
              paramString.a((oz)this.klq.get(0));
              am.bcl().update(paramString, new String[] { this.kkW });
            }
            AppMethodBeat.o(88298);
            return;
          }
          paramString = am.bcd().HJ(this.kkW);
          if (paramString != null)
          {
            paramString.a((oz)this.klq.get(0));
            am.bcd().update(paramString, new String[] { this.kkW });
          }
          AppMethodBeat.o(88298);
          return;
        }
        if ((this.klk != null) && (this.klq == null))
        {
          this.klk.a(null);
          bcI();
          if (this.klk.baK())
          {
            paramString = am.bcl().HZ(this.kkW);
            if (paramString != null)
            {
              paramString.a(null);
              am.bcl().update(paramString, new String[] { this.kkW });
            }
            AppMethodBeat.o(88298);
            return;
          }
          paramString = am.bcd().HJ(this.kkW);
          if (paramString != null)
          {
            paramString.a(null);
            am.bcd().update(paramString, new String[] { this.kkW });
          }
        }
        AppMethodBeat.o(88298);
        return;
      }
      if ((paramm instanceof af))
      {
        paramInt1 = ((af)paramm).koj;
        localObject = ((af)paramm).kok;
        if (paramInt1 == 10000)
        {
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = getString(2131297920);
          }
          com.tencent.mm.plugin.card.d.d.c(this, paramString);
          AppMethodBeat.o(88298);
          return;
        }
        this.kte = ((af)paramm).cHo;
        fZ(true);
        paramString = this.klk.bbe();
        paramString.status = 3;
        this.klk.a(paramString);
        com.tencent.mm.plugin.card.d.l.h(this.klk);
        bcI();
        if (this.kqC == 3)
        {
          q(true, 2);
          AppMethodBeat.o(88298);
          return;
        }
        if (this.kqC == 15)
        {
          paramString = new qu();
          com.tencent.mm.sdk.b.a.ymk.l(paramString);
        }
        AppMethodBeat.o(88298);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.card.model.r))
      {
        com.tencent.mm.ui.base.h.bO(this, getResources().getString(2131297896));
        am.bcc();
        com.tencent.mm.plugin.card.b.b.sW(4);
        q(true, 1);
        AppMethodBeat.o(88298);
        return;
      }
      if ((paramm instanceof t))
      {
        paramString = (t)paramm;
        paramm = paramString.kop;
        if ((paramm != null) && (paramm.size() > 0))
        {
          paramm = (com.tencent.mm.plugin.card.base.b)paramm.get(0);
          if ((paramm != null) && (!this.kkW.equals(paramString.cardId)))
          {
            ab.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.kkW, paramString.cardId });
            AppMethodBeat.o(88298);
            return;
          }
          this.klk = paramm;
          if (this.klk != null)
          {
            this.kkW = this.klk.bbh();
            bdn();
            if (this.klk.baY()) {
              am.bcq().Hz(this.klk.bbh());
            }
          }
          if (this.ejF == 26) {
            this.ejF = 3;
          }
          bcI();
        }
        bdl();
        com.tencent.mm.plugin.card.d.l.bfz();
        AppMethodBeat.o(88298);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramm).koi;
        paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramm).koj;
        paramm = ((com.tencent.mm.plugin.card.sharecard.model.g)paramm).kok;
        if (paramInt1 != 0)
        {
          paramString = paramm;
          if (TextUtils.isEmpty(paramm)) {
            paramString = getString(2131297858);
          }
          com.tencent.mm.plugin.card.d.d.c(this, paramString);
          ab.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", new Object[] { paramString });
          AppMethodBeat.o(88298);
          return;
        }
        com.tencent.mm.ui.base.h.bO(this, getResources().getString(2131297862));
        if (TextUtils.isEmpty(paramString))
        {
          ab.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
          AppMethodBeat.o(88298);
          return;
        }
        this.ejF = 3;
        if (this.klk == null)
        {
          this.klk = new ShareCardInfo();
          com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)this.klk, paramString);
          paramm = (ShareCardInfo)this.klk;
          if (!TextUtils.isEmpty(paramString)) {
            break label2149;
          }
          ab.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
          label1885:
          if (!TextUtils.isEmpty(this.klk.bbh())) {
            this.kkW = this.klk.bbh();
          }
          if (TextUtils.isEmpty(this.klk.bbj())) {
            ((ShareCardInfo)this.klk).field_from_username = com.tencent.mm.model.r.Zn();
          }
          com.tencent.mm.plugin.card.d.l.a((ShareCardInfo)this.klk);
          bdn();
          bcI();
          com.tencent.mm.plugin.card.d.l.bfB();
          am.bck().onChange();
          this.kto = this.klk.bbn();
          if ((this.kqC != 7) && (this.kqC != 16)) {
            break label2241;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.kto);
          setResult(-1, paramString);
          ti(-1);
        }
        for (;;)
        {
          for (;;)
          {
            paramString = (Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yze, Integer.valueOf(0));
            if ((paramString == null) || (paramString.intValue() != 1))
            {
              com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yze, Integer.valueOf(1));
              com.tencent.mm.plugin.card.d.d.c(this, 2130969000, 2131298045, "");
            }
            if (this.klk.baY()) {
              am.bcq().Hz(this.klk.bbh());
            }
            AppMethodBeat.o(88298);
            return;
            if (!(this.klk instanceof CardInfo)) {
              break;
            }
            this.klk = new ShareCardInfo();
            break;
            try
            {
              label2149:
              paramString = new JSONObject(paramString).optJSONArray("card_list");
              if (paramString == null) {
                break label1885;
              }
              paramm.kmp = paramString.optJSONObject(0).optString("encrypt_code");
              ab.i("MicroMsg.CardInfoParser", "encrypt_code:" + paramm.kmp);
            }
            catch (JSONException paramString)
            {
              ab.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
              ab.e("MicroMsg.CardInfoParser", paramString.getMessage());
            }
          }
          break label1885;
          label2241:
          if ((!this.ktk) && (this.kqC == 8)) {
            q(true, -1);
          }
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.c))
      {
        paramm = ((com.tencent.mm.plugin.card.sharecard.model.c)paramm).koi;
        if (TextUtils.isEmpty(paramm))
        {
          ab.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
          AppMethodBeat.o(88298);
          return;
        }
        paramString = this.klk;
        this.klk = new ShareCardInfo();
        localObject = (ShareCardInfo)this.klk;
        if (TextUtils.isEmpty(paramm))
        {
          ab.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
          if (paramString != null)
          {
            if (!TextUtils.isEmpty(paramString.bbj())) {
              ((ShareCardInfo)this.klk).field_from_username = ((ShareCardInfo)paramString).field_from_username;
            }
            ((ShareCardInfo)this.klk).field_app_id = ((ShareCardInfo)paramString).field_app_id;
            ((ShareCardInfo)this.klk).field_consumer = ((ShareCardInfo)paramString).field_consumer;
            ((ShareCardInfo)this.klk).field_share_time = ((ShareCardInfo)paramString).field_share_time;
            ((ShareCardInfo)this.klk).field_updateTime = ((ShareCardInfo)paramString).field_updateTime;
            ((ShareCardInfo)this.klk).field_begin_time = ((ShareCardInfo)paramString).field_begin_time;
            ((ShareCardInfo)this.klk).field_end_time = ((ShareCardInfo)paramString).field_end_time;
            ((ShareCardInfo)this.klk).field_block_mask = ((ShareCardInfo)paramString).field_block_mask;
            this.klk.a(paramString.bbg());
            ((ShareCardInfo)this.klk).field_categoryType = ((ShareCardInfo)paramString).field_categoryType;
            ((ShareCardInfo)this.klk).field_itemIndex = ((ShareCardInfo)paramString).field_itemIndex;
            if (((ShareCardInfo)paramString).field_status != ((ShareCardInfo)this.klk).field_status)
            {
              ab.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo)this.klk).field_status);
              com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.klk);
            }
          }
          if (!TextUtils.isEmpty(this.klk.bbh())) {
            this.kkW = this.klk.bbh();
          }
          bcI();
          bdn();
          bdl();
          if (this.ejF == 3)
          {
            if (!this.ktl) {
              break label2742;
            }
            com.tencent.mm.plugin.card.d.l.h(this.klk);
          }
        }
        for (;;)
        {
          for (;;)
          {
            if (this.klk.baY()) {
              am.bcq().Hz(this.klk.bbh());
            }
            AppMethodBeat.o(88298);
            return;
            try
            {
              com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)localObject, new JSONObject(paramm));
            }
            catch (JSONException paramm)
            {
              ab.printErrStackTrace("MicroMsg.CardInfoParser", paramm, "", new Object[0]);
            }
          }
          break;
          label2742:
          ab.e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.a))
      {
        if (((com.tencent.mm.plugin.card.sharecard.model.a)paramm).koj != 0)
        {
          com.tencent.mm.plugin.card.d.d.c(this, getString(2131297894));
          AppMethodBeat.o(88298);
          return;
        }
        ab.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.klk.bbh());
        com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.klk);
        com.tencent.mm.ui.base.h.bO(this, getResources().getString(2131297896));
        am.bck().bcy();
        q(true, -1);
        AppMethodBeat.o(88298);
      }
    }
    else
    {
      ab.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " cmd:" + paramm.getType());
      fV(false);
      if (!(paramm instanceof af)) {
        break label3010;
      }
      fZ(false);
      paramInt1 = ((af)paramm).koj;
      paramm = ((af)paramm).kok;
      if (paramInt1 != 10000) {
        break label3067;
      }
      paramString = paramm;
      if (TextUtils.isEmpty(paramm)) {
        paramString = getString(2131297920);
      }
    }
    label3010:
    label3067:
    for (;;)
    {
      paramm = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramm = getString(2131298085);
      }
      Toast.makeText(getContext(), paramm, 0).show();
      AppMethodBeat.o(88298);
      return;
      if ((paramm instanceof com.tencent.mm.plugin.card.model.o))
      {
        ti(0);
        c(paramInt2, paramString, ((com.tencent.mm.plugin.card.model.o)paramm).koj, ((com.tencent.mm.plugin.card.model.o)paramm).kok);
        AppMethodBeat.o(88298);
        return;
      }
      if ((paramm instanceof v))
      {
        AppMethodBeat.o(88298);
        return;
      }
    }
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(88323);
    if ((this.ktb.ktz instanceof q))
    {
      ((q)this.ktb.ktz).kxM = am.bcq().getCode();
      this.ktb.bcI();
    }
    ab.i("MicroMsg.CardDetailUI", "code get success");
    AppMethodBeat.o(88323);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailUI
 * JD-Core Version:    0.7.0.1
 */