package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.h.a.pn;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
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
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.ui.view.x;
import com.tencent.mm.protocal.c.bvk;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.mh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.ay.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.s;
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
  implements com.tencent.mm.ah.f, c.a, d.a, j.a, ay.a
{
  private final String TAG = "MicroMsg.CardDetailUI";
  private String dRD = "";
  private float dia = -85.0F;
  private float dib = -1000.0F;
  private a.a dig = new CardDetailUI.1(this);
  private com.tencent.mm.ui.base.p dpF = null;
  private int drX = 3;
  private com.tencent.mm.modelgeo.c egs;
  private Vibrator ibr;
  private String ijW = "";
  private com.tencent.mm.plugin.card.base.b ikk;
  private ArrayList<mb> ikq;
  private String ilj = "";
  private boolean ily = false;
  private boolean ipI = false;
  private int ipv = -1;
  private boolean iqE = false;
  private String irA = "";
  private String irB = "";
  e irU;
  private String irV = "";
  private String irW = "";
  private String irX = "";
  private boolean irY = false;
  private boolean irZ = false;
  private int iry = 0;
  private String irz = "";
  private boolean isa = false;
  private String isb = "";
  private e.a isc;
  private boolean isd = false;
  private boolean ise = true;
  private boolean isf = false;
  private boolean isg = false;
  private String ish = "";
  private com.tencent.mm.plugin.card.b.i isi = new com.tencent.mm.plugin.card.b.i();
  ah mHandler = new ah();
  private long mStartTime = 0L;
  
  private void a(j.b paramb)
  {
    if (this.irU.bNW)
    {
      y.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
      return;
    }
    y.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
    this.irU.a(this.isa, paramb, true);
  }
  
  private void aAW()
  {
    this.isc.drX = this.drX;
    this.isc.ipv = this.ipv;
    this.isc.ijW = this.ijW;
    this.irU.a(this.ikk, this.isc, this.ikq);
    this.irU.aAW();
    am.aAD().ikk = this.ikk;
  }
  
  private void aBf()
  {
    this.egs = com.tencent.mm.modelgeo.c.Ob();
    ayV();
  }
  
  private void aBr()
  {
    com.tencent.mm.kernel.g.DO().dJT.a(645, this);
    com.tencent.mm.kernel.g.DO().dJT.a(651, this);
    com.tencent.mm.kernel.g.DO().dJT.a(563, this);
    com.tencent.mm.kernel.g.DO().dJT.a(652, this);
    com.tencent.mm.kernel.g.DO().dJT.a(560, this);
    com.tencent.mm.kernel.g.DO().dJT.a(699, this);
    com.tencent.mm.kernel.g.DO().dJT.a(902, this);
    com.tencent.mm.kernel.g.DO().dJT.a(904, this);
    com.tencent.mm.kernel.g.DO().dJT.a(1163, this);
  }
  
  private void aBs()
  {
    com.tencent.mm.kernel.g.DO().dJT.b(645, this);
    com.tencent.mm.kernel.g.DO().dJT.b(651, this);
    com.tencent.mm.kernel.g.DO().dJT.b(563, this);
    com.tencent.mm.kernel.g.DO().dJT.b(652, this);
    com.tencent.mm.kernel.g.DO().dJT.b(560, this);
    com.tencent.mm.kernel.g.DO().dJT.b(699, this);
    com.tencent.mm.kernel.g.DO().dJT.b(902, this);
    com.tencent.mm.kernel.g.DO().dJT.b(904, this);
    com.tencent.mm.kernel.g.DO().dJT.b(1163, this);
  }
  
  private void aBt()
  {
    this.ipv = this.drX;
    this.isc = new e.a();
    this.isc.drX = this.drX;
    this.isc.ipv = this.ipv;
    this.isc.ijW = this.ijW;
    this.isc.irV = this.irV;
    this.isc.irX = this.irX;
    this.isc.irW = this.irW;
    this.isc.irz = this.irz;
    this.isc.irA = this.irA;
    this.isc.ily = this.ily;
    this.isc.isT = getIntent().getIntExtra("key_from_appbrand_type", 0);
  }
  
  private void aBu()
  {
    int j = 1;
    int i = 1;
    if ((this.isf) || (this.ikk == null)) {
      return;
    }
    this.isf = true;
    if (this.ily)
    {
      localh = com.tencent.mm.plugin.report.service.h.nFQ;
      j = this.ikk.azx().ilo;
      str1 = this.ikk.azC();
      str2 = this.ikk.azB();
      k = this.ipv;
      str3 = this.irV;
      if (this.ikk.azv()) {}
      for (;;)
      {
        localh.f(11324, new Object[] { "ShareCardDetailUI", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
        return;
        i = 0;
      }
    }
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.nFQ;
    int k = this.ikk.azx().ilo;
    String str1 = this.ikk.azC();
    String str2 = this.ikk.azB();
    int m = this.ipv;
    String str3 = this.irV;
    if (this.ikk.azv()) {}
    for (i = j;; i = 0)
    {
      localh.f(11324, new Object[] { "CardDetailView", Integer.valueOf(k), str1, str2, Integer.valueOf(0), Integer.valueOf(m), str3, Integer.valueOf(i), "" });
      return;
    }
  }
  
  private void aBv()
  {
    Object localObject = new bvk();
    ((bvk)localObject).tMg = this.dRD;
    ((bvk)localObject).imC = this.isb;
    y.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", new Object[] { this.dRD });
    localObject = new aa(this.ijW, this.drX, this.irV, this.irX, this.irz, this.irA, this.iry, this.irB, (bvk)localObject);
    com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject, 0);
  }
  
  private void aBw()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.ikk.azC()))
    {
      localObject = this.ikk.azC();
      if ((this.ikk == null) || (this.ikk.azx().sIu != 1)) {
        break label153;
      }
      float f2 = this.dia;
      float f3 = this.dib;
      float f1;
      if (f2 != -85.0F)
      {
        f1 = f3;
        if (f3 != -1000.0F) {}
      }
      else
      {
        f2 = am.aAy().dia;
        f1 = am.aAy().dib;
      }
      localObject = new v((String)localObject, f1, f2, this.ikk.azB());
      com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject, 0);
    }
    label153:
    label344:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (!TextUtils.isEmpty(this.ijW))
              {
                localObject = this.ijW;
                break;
              }
              y.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
              return;
              if ((this.ikk == null) || (this.ikk.azx().sIu <= 1)) {
                break label267;
              }
              if ((this.dia != -85.0F) && (this.dib != -1000.0F))
              {
                this.isg = false;
                localObject = new v((String)localObject, this.dib, this.dia, this.ikk.azB());
                com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject, 0);
                return;
              }
            } while (this.isg);
            this.isg = true;
          } while (!this.iqE);
          ayV();
          return;
        } while (this.ikk == null);
        this.ikk.a(null);
        aAW();
        if (!this.ikk.aze()) {
          break label344;
        }
        localObject = am.aAA().yy(this.ijW);
      } while (localObject == null);
      ((ShareCardInfo)localObject).a(null);
      am.aAA().c((com.tencent.mm.sdk.e.c)localObject, new String[] { this.ijW });
      return;
      localObject = am.aAs().yi(this.ijW);
    } while (localObject == null);
    label267:
    ((CardInfo)localObject).a(null);
    am.aAs().c((com.tencent.mm.sdk.e.c)localObject, new String[] { this.ijW });
  }
  
  private void aBx()
  {
    com.tencent.mm.plugin.card.sharecard.model.c localc = new com.tencent.mm.plugin.card.sharecard.model.c(this.ijW);
    com.tencent.mm.kernel.g.DO().dJT.a(localc, 0);
  }
  
  private void ayV()
  {
    if (this.egs == null) {
      this.egs = com.tencent.mm.modelgeo.c.Ob();
    }
    this.egs.a(this.dig, true);
  }
  
  private void ayX()
  {
    if (this.egs != null) {
      this.egs.c(this.dig);
    }
  }
  
  private void b(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    y.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + paramInt1 + " errMsg = " + paramString1 + " ret_code:" + paramInt2 + " ret_msg:" + paramString2);
    if (paramInt2 == 10000)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = getString(a.g.card_accept_late);
      }
      this.ikk.azy().status = 4;
      aAW();
    }
    for (;;)
    {
      com.tencent.mm.plugin.card.d.d.b(this, paramString1);
      return;
      if (paramInt2 == 10001)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(a.g.card_accept_time_out);
        }
        this.ikk.azy().status = 5;
        aAW();
      }
      else if (paramInt2 == 10002)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(a.g.card_no_stock);
        }
      }
      else
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(a.g.card_accept_fail);
        }
      }
    }
  }
  
  private void eA(boolean paramBoolean)
  {
    if (((this.ipv == 7) || (this.ipv == 8) || (this.ipv == 16) || (this.ipv == 26)) && (this.drX == 3))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_code", this.ish);
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
    }
    do
    {
      do
      {
        return;
        if (((this.ipv != 7) || (this.drX != 7)) && ((this.ipv != 16) || (this.drX != 16)) && ((this.ipv != 8) || (this.drX != 8)) && ((this.ipv != 26) || (this.drX != 26))) {
          break;
        }
        setResult(0);
      } while (!paramBoolean);
      finish();
      return;
    } while (!paramBoolean);
    finish();
  }
  
  private void ew(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.dpF = com.tencent.mm.ui.base.p.b(this, getString(a.g.loading_tips), true, 0, null);
    }
    while ((this.dpF == null) || (!this.dpF.isShowing())) {
      return;
    }
    this.dpF.dismiss();
    this.dpF = null;
  }
  
  private void ez(boolean paramBoolean)
  {
    if (paramBoolean) {
      com.tencent.mm.plugin.card.d.l.cC(this.irU.isI, this.irU.isH);
    }
  }
  
  private void oY(int paramInt)
  {
    if ((this.ipv != 7) && (this.ipv != 16))
    {
      y.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new com.tencent.mm.plugin.card.model.e();
    ((com.tencent.mm.plugin.card.model.e)localObject).iln = this.ikk.azC();
    ((com.tencent.mm.plugin.card.model.e)localObject).bZd = this.irX;
    ((com.tencent.mm.plugin.card.model.e)localObject).code = this.ish;
    localLinkedList.add(localObject);
    localObject = new com.tencent.mm.h.a.b();
    ((com.tencent.mm.h.a.b)localObject).bEO.aYY = paramInt;
    if (paramInt == -1) {}
    for (((com.tencent.mm.h.a.b)localObject).bEO.bEP = com.tencent.mm.plugin.card.d.h.a(localLinkedList, true, this.ipv);; ((com.tencent.mm.h.a.b)localObject).bEO.bEP = com.tencent.mm.plugin.card.d.h.a(localLinkedList, false, this.ipv))
    {
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      return;
    }
  }
  
  /* Error */
  private void xZ(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 112	com/tencent/mm/plugin/card/ui/CardDetailUI:ipI	Z
    //   6: ifeq +14 -> 20
    //   9: ldc 76
    //   11: ldc_w 662
    //   14: invokestatic 371	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: ldc 76
    //   22: ldc_w 664
    //   25: invokestatic 178	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 112	com/tencent/mm/plugin/card/ui/CardDetailUI:ipI	Z
    //   33: new 277	android/content/Intent
    //   36: dup
    //   37: aload_0
    //   38: ldc_w 666
    //   41: invokespecial 669	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   44: astore_2
    //   45: aload_2
    //   46: ldc_w 671
    //   49: aload_0
    //   50: getfield 162	com/tencent/mm/plugin/card/ui/CardDetailUI:ikk	Lcom/tencent/mm/plugin/card/base/b;
    //   53: invokeinterface 196 1 0
    //   58: invokevirtual 495	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   61: pop
    //   62: aload_2
    //   63: ldc_w 673
    //   66: aload_1
    //   67: invokevirtual 495	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   70: pop
    //   71: aload_2
    //   72: ldc_w 675
    //   75: aload_0
    //   76: getfield 162	com/tencent/mm/plugin/card/ui/CardDetailUI:ikk	Lcom/tencent/mm/plugin/card/base/b;
    //   79: invokeinterface 295 1 0
    //   84: getfield 678	com/tencent/mm/protocal/c/mg:color	Ljava/lang/String;
    //   87: invokevirtual 495	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   90: pop
    //   91: aload_2
    //   92: ldc_w 680
    //   95: aload_0
    //   96: getfield 119	com/tencent/mm/plugin/card/ui/CardDetailUI:drX	I
    //   99: invokevirtual 683	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   102: pop
    //   103: aload_2
    //   104: ldc_w 685
    //   107: iconst_0
    //   108: invokevirtual 683	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   111: pop
    //   112: aload_0
    //   113: aload_2
    //   114: invokevirtual 689	com/tencent/mm/plugin/card/ui/CardDetailUI:startActivity	(Landroid/content/Intent;)V
    //   117: goto -100 -> 17
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	CardDetailUI
    //   0	125	1	paramString	String
    //   44	70	2	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   2	17	120	finally
    //   20	117	120	finally
  }
  
  public final void aqt()
  {
    com.tencent.mm.plugin.card.ui.view.g localg = this.irU.iss;
    if (localg != null) {
      localg.aCY();
    }
  }
  
  public final void azP()
  {
    y.i("MicroMsg.CardDetailUI", "code change");
    if ((this.irU.iss instanceof com.tencent.mm.plugin.card.ui.view.q))
    {
      ((com.tencent.mm.plugin.card.ui.view.q)this.irU.iss).iwI = am.aAF().getCode();
      this.irU.aAW();
    }
  }
  
  public final void azU()
  {
    y.i("MicroMsg.CardDetailUI", "onVibrate");
    this.ibr.vibrate(300L);
  }
  
  public final void azV()
  {
    y.i("MicroMsg.CardDetailUI", "onFinishUI");
  }
  
  public final void b(String paramString, j.b paramb)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.ijW))) {
      y.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
    }
    do
    {
      return;
      ew(false);
      y.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
      y.i("MicroMsg.CardDetailUI", "markSucc:" + paramb.ilb + " markCardId: " + paramb.ilc);
      this.irZ = false;
      if (paramb.ilb != 1) {
        break label245;
      }
      if ((TextUtils.isEmpty(paramb.ilc)) || (this.ikk.azB().equals(paramb.ilc))) {
        break;
      }
      y.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
    } while (!this.ikk.aze());
    paramString = am.aAA().yy(paramb.ilc);
    if (paramString != null)
    {
      this.ikk = paramString;
      this.ijW = paramb.ilc;
      aAW();
      am.aAD().b(this.ikk);
      y.i("MicroMsg.CardDetailUI", "update the mCardInfo");
      this.irY = true;
      a(paramb);
      return;
    }
    y.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
    com.tencent.mm.plugin.card.d.d.b(this, getString(a.g.card_mark_failed_tips));
    this.irY = false;
    return;
    y.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
    this.irY = true;
    a(paramb);
    return;
    label245:
    this.irY = false;
    com.tencent.mm.plugin.card.d.d.b(this, getString(a.g.card_mark_used));
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.ijW)))
    {
      y.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
      return;
    }
    y.i("MicroMsg.CardDetailUI", "onMarkFail()");
    this.irY = false;
    this.irZ = false;
    ew(false);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(a.g.card_mark_failed_tips);
    }
    com.tencent.mm.plugin.card.d.d.b(this, paramString1);
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    if (paramb == null)
    {
      y.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
      return;
    }
    if ((this.ikk == null) || (!this.ikk.azB().equals(paramb.azB())))
    {
      y.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
      return;
    }
    if (!this.irU.aBP())
    {
      y.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
      return;
    }
    y.i("MicroMsg.CardDetailUI", "onDataChange");
    this.ikk = paramb;
    this.ijW = this.ikk.azB();
    if ((this.ikk.azs()) && (am.aAF().isEmpty())) {
      am.aAF().xY(this.ikk.azB());
    }
    aAW();
  }
  
  protected final int getLayoutId()
  {
    return a.e.card_detail_ui;
  }
  
  protected final void initView()
  {
    setBackBtn(new CardDetailUI.2(this));
    this.ibr = ((Vibrator)getSystemService("vibrator"));
    Object localObject2;
    if (this.irU == null)
    {
      this.irU = new e(this, this.mController.contentView);
      localObject1 = this.irU;
      ((e)localObject1).isE = new j(((e)localObject1).isl);
      localObject2 = ((e)localObject1).isE;
      ((j)localObject2).ipr = ((j)localObject2).iwz.getWindow().getAttributes().screenBrightness;
      if (((j)localObject2).fvf == null)
      {
        localObject3 = View.inflate(((j)localObject2).iwz, a.e.card_popup_window, null);
        ((j)localObject2).fvh = ((View)localObject3).findViewById(a.d.popupwd_qrcode_layout);
        ((j)localObject2).fvg = ((ImageView)((View)localObject3).findViewById(a.d.popupwd_qrcode_iv));
        ((j)localObject2).iwB = ((TextView)((View)localObject3).findViewById(a.d.popupwd_qrcode_tv));
        ((j)localObject2).iwC = ((TextView)((View)localObject3).findViewById(a.d.popupwd_qrcode_tips_tv));
        ((j)localObject2).iwD = ((View)localObject3).findViewById(a.d.popupwd_barcode_layout);
        ((j)localObject2).iwE = ((ImageView)((View)localObject3).findViewById(a.d.popupwd_barcode_iv));
        ((j)localObject2).iwF = ((MMVerticalTextView)((View)localObject3).findViewById(a.d.vertical_barcode_text));
        ((j)localObject2).iwG = ((MMVerticalTextView)((View)localObject3).findViewById(a.d.vertical_barcode_tips_text));
        ((View)localObject3).setOnClickListener(new j.2((j)localObject2));
        ((j)localObject2).fvf = new com.tencent.mm.ui.base.o((View)localObject3, -1, -1, true);
        ((j)localObject2).fvf.update();
        ((j)localObject2).fvf.setBackgroundDrawable(new ColorDrawable(16777215));
        ((j)localObject2).fvf.setOnDismissListener(new j.3((j)localObject2));
      }
      ((e)localObject1).isG = new com.tencent.mm.plugin.card.b.f(((e)localObject1).isl);
      ((e)localObject1).isl.gJb = ((MMActivity.a)localObject1);
      com.tencent.mm.sdk.b.a.udP.c(((e)localObject1).isP);
      localObject1 = this.irU;
      if (((e)localObject1).isn == null)
      {
        ((e)localObject1).isn = new x();
        ((e)localObject1).isn.a((n)localObject1);
      }
      if (((e)localObject1).isp == null)
      {
        ((e)localObject1).isp = new com.tencent.mm.plugin.card.ui.view.o();
        ((e)localObject1).isp.a((n)localObject1);
      }
      if (((e)localObject1).isq == null)
      {
        ((e)localObject1).isq = new com.tencent.mm.plugin.card.ui.view.a();
        ((e)localObject1).isq.a((n)localObject1);
      }
      ((e)localObject1).Nn = ((ListView)((e)localObject1).findViewById(a.d.cell_list));
      ((e)localObject1).ist = new m(((e)localObject1).isl.mController.uMN);
      ((e)localObject1).ist.ixn = ((e)localObject1).fvj;
      ((e)localObject1).Nn.setAdapter(((e)localObject1).ist);
      ((e)localObject1).ist.notifyDataSetChanged();
      ((e)localObject1).Nn.setOnItemClickListener(new e.1((e)localObject1));
      y.i("MicroMsg.CardDetailUIContoller", "initMenu");
      localObject2 = ((e)localObject1).isl;
      Object localObject3 = new e.5((e)localObject1);
      ((CardDetailBaseUI)localObject2).irO.setOnClickListener((View.OnClickListener)localObject3);
      ((e)localObject1).dK = ((LinearLayout)((e)localObject1).findViewById(a.d.header_view));
      ((e)localObject1).isC = new com.tencent.mm.plugin.card.ui.view.d();
      ((e)localObject1).isC.a((n)localObject1);
      ((e)localObject1).isE.ikk = ((e)localObject1).ikk;
    }
    int i = getIntent().getIntExtra("key_from_scene", -1);
    y.i("MicroMsg.CardDetailUI", "scene:%d", new Object[] { Integer.valueOf(i) });
    int j;
    if ((i == 2) || (i == 6) || (i == 5))
    {
      this.drX = i;
      localObject1 = getIntent().getStringExtra("key_card_app_msg");
      localObject2 = com.tencent.mm.plugin.card.d.g.yM((String)localObject1);
      if (localObject2 != null)
      {
        this.ijW = ((com.tencent.mm.plugin.card.model.d)localObject2).bZc;
        this.irV = ((com.tencent.mm.plugin.card.model.d)localObject2).imy;
        this.irX = ((com.tencent.mm.plugin.card.model.d)localObject2).bZd;
        j = ((com.tencent.mm.plugin.card.model.d)localObject2).imB;
        y.i("MicroMsg.CardDetailUI", "scene is " + i + ", isRecommend is " + j);
        if ((j == 1) && (i == 2)) {
          this.drX = 23;
        }
        this.isb = ((com.tencent.mm.plugin.card.model.d)localObject2).imC;
        y.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.isb);
      }
      this.irW = com.tencent.mm.plugin.card.d.g.yN((String)localObject1);
      aBt();
      if (!TextUtils.isEmpty(this.ijW)) {
        break label1782;
      }
      y.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
      eA(true);
    }
    for (;;)
    {
      this.irU.a(this.ikk, this.isc, this.ikq);
      this.irU.isM = new CardDetailUI.3(this);
      boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
      y.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      this.iqE = bool;
      if (this.iqE)
      {
        this.egs = com.tencent.mm.modelgeo.c.Ob();
        ayV();
      }
      return;
      if ((com.tencent.mm.plugin.card.d.l.pf(i)) || (i == 0) || (i == 1) || (i == 3) || (i == 4) || (i == 9) || (i == 12) || (i == 15) || (i == 17) || (i == 21))
      {
        this.drX = i;
        this.ijW = getIntent().getStringExtra("key_card_id");
        this.irX = getIntent().getStringExtra("key_card_ext");
        this.ily = getIntent().getBooleanExtra("key_is_share_card", false);
        this.iry = getIntent().getIntExtra("key_stastic_scene", 0);
        this.irB = getIntent().getStringExtra("key_consumed_card_id");
        if ((i == 7) || (i == 16))
        {
          this.irz = getIntent().getStringExtra("src_username");
          this.irA = getIntent().getStringExtra("js_url");
          this.dRD = getIntent().getStringExtra("key_template_id");
          break;
        }
        if ((this.ily) && (i == 3))
        {
          this.ilj = getIntent().getStringExtra("key_card_tp_id");
          this.ijW = com.tencent.mm.plugin.card.sharecard.a.b.cv(this.ijW, this.ilj);
          break;
        }
        if (i != 8) {
          break;
        }
        this.isd = getIntent().getBooleanExtra("key_is_sms_add_card", false);
        break;
      }
      if ((i == 50) || (i == 27))
      {
        this.drX = getIntent().getIntExtra("key_previous_scene", 50);
        if ((this.drX != 26) && (this.drX != 27)) {
          this.drX = 3;
        }
        this.dRD = getIntent().getStringExtra("key_template_id");
        if (this.drX == 27)
        {
          localObject1 = (com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info");
          if (localObject1 != null)
          {
            this.ikk = ((com.tencent.mm.plugin.card.base.b)localObject1);
            this.ijW = this.ikk.azB();
            aBt();
            aBw();
            if (this.ikk.azs()) {
              am.aAF().xY(this.ikk.azB());
            }
            aAW();
          }
          aBu();
          com.tencent.mm.plugin.card.d.l.aDc();
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.card.d.k.bp(getIntent().getStringExtra("card_list"), this.drX);
          if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
          {
            y.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
            eA(true);
          }
          for (;;)
          {
            aBt();
            break;
            ew(true);
            this.ijW = ((mh)((LinkedList)localObject1).get(0)).iln;
            i = getIntent().getIntExtra("key_previous_scene", 51);
            localObject2 = new bvk();
            ((bvk)localObject2).tMg = this.dRD;
            y.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.dRD });
            localObject1 = new t((LinkedList)localObject1, (bvk)localObject2, i);
            com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject1, 0);
          }
        }
      }
      else if (i == 51)
      {
        if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {}
        for (this.drX = 26;; this.drX = 3)
        {
          this.ijW = getIntent().getStringExtra("key_card_id");
          this.ikk = am.aAx().ijN;
          if (this.ikk == null) {
            this.ikk = am.aAs().yi(this.ijW);
          }
          aBt();
          if (this.ikk != null) {
            break label1630;
          }
          y.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
          eA(true);
          break;
        }
        label1630:
        aBw();
        aAW();
        aBu();
        if (this.ikk.azs()) {
          am.aAF().xY(this.ikk.azB());
        }
      }
      else
      {
        if (i == 26)
        {
          this.drX = i;
          this.ijW = getIntent().getStringExtra("key_card_id");
          this.irX = getIntent().getStringExtra("key_card_ext");
          break;
        }
        this.drX = i;
        localObject1 = getIntent().getStringExtra("key_card_app_msg");
        localObject2 = com.tencent.mm.plugin.card.d.g.yM((String)localObject1);
        if (localObject2 != null)
        {
          this.ijW = ((com.tencent.mm.plugin.card.model.d)localObject2).bZc;
          this.irV = ((com.tencent.mm.plugin.card.model.d)localObject2).imy;
          this.irX = ((com.tencent.mm.plugin.card.model.d)localObject2).bZd;
        }
        this.irW = com.tencent.mm.plugin.card.d.g.yN((String)localObject1);
        break;
        label1782:
        if ((i == 2) || (i == 6) || ((i == 4) && (!this.ily)) || (i == 5) || (i == 17) || (i == 21) || (i == 23)) {
          i = 1;
        }
        for (;;)
        {
          if ((i == 0) && (this.ikk != null)) {
            break label1999;
          }
          y.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.ijW + " isShareCard is " + this.ily);
          ew(true);
          if (!this.ily) {
            break label1992;
          }
          aBx();
          break;
          if (i == 15)
          {
            localObject1 = am.aAx().getValue("key_accept_card_info");
            if ((localObject1 != null) && ((localObject1 instanceof CardInfo)))
            {
              this.ikk = ((CardInfo)localObject1);
              i = 0;
            }
            else
            {
              i = 1;
            }
          }
          else if (this.ily)
          {
            this.ikk = am.aAA().yy(this.ijW);
            i = 0;
          }
          else
          {
            this.ikk = am.aAs().yi(this.ijW);
            i = 0;
          }
        }
        label1992:
        aBv();
      }
    }
    label1999:
    y.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.ijW);
    Object localObject1 = this.ikk.azA();
    if (localObject1 != null)
    {
      this.ikq = new ArrayList();
      this.ikq.add(localObject1);
    }
    aAW();
    if (this.ikk.azs()) {
      am.aAF().xY(this.ikk.azB());
    }
    if (this.ily)
    {
      this.ise = true;
      i = 1;
      label2106:
      if (i == 0) {
        break label2242;
      }
      y.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.ijW + " isShareCard is " + this.ily);
      if (!this.ily) {
        break label2235;
      }
      aBx();
    }
    for (;;)
    {
      aBu();
      break;
      if ((int)(System.currentTimeMillis() / 1000L) - this.ikk.azE() >= 86400L) {}
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label2213;
        }
        this.ise = true;
        i = 1;
        break;
      }
      label2213:
      if (!this.ikk.azp()) {
        break label2106;
      }
      this.ise = true;
      i = 1;
      break label2106;
      label2235:
      aBv();
      continue;
      label2242:
      aBw();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mStartTime = System.currentTimeMillis();
    aBr();
    paramBundle = am.aAD();
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    com.tencent.mm.kernel.g.DO().dJT.a(910, paramBundle);
    am.aAz().a(paramBundle);
    com.tencent.mm.plugin.card.b.b localb = am.aAr();
    if (localb.fKm == null) {
      localb.fKm = new ArrayList();
    }
    if (paramBundle != null) {
      localb.fKm.add(new WeakReference(paramBundle));
    }
    paramBundle.alY = new WeakReference(localAppCompatActivity);
    am.aAD().a(this);
    am.aAE().a(this);
    paramBundle = am.aAF();
    com.tencent.mm.kernel.g.DO().dJT.a(577, paramBundle);
    paramBundle.ijX.clear();
    paramBundle.ijY = 0;
    am.aAF().a(this);
    initView();
  }
  
  protected void onDestroy()
  {
    am.aAD().c(this);
    aBs();
    am.aAD().b(this);
    am.aAD().release();
    am.aAE().b(this);
    am.aAF().b(this);
    am.aAF().release();
    Object localObject1 = this.irU;
    Object localObject2 = ((e)localObject1).isG;
    ((com.tencent.mm.plugin.card.b.f)localObject2).ikk = null;
    ((com.tencent.mm.plugin.card.b.f)localObject2).iko.clear();
    ((e)localObject1).isG = null;
    localObject2 = ((e)localObject1).isE;
    com.tencent.mm.plugin.card.d.l.w(((j)localObject2).iwA);
    int i = ((j)localObject2).iwH.size() - 1;
    while (i >= 0)
    {
      com.tencent.mm.plugin.card.d.l.w((Bitmap)((j)localObject2).iwH.remove(i));
      i -= 1;
    }
    ((j)localObject2).iwH.clear();
    if (((j)localObject2).fvf.isShowing()) {
      ((j)localObject2).fvf.dismiss();
    }
    ((j)localObject2).fvf = null;
    ((j)localObject2).aCf();
    ((j)localObject2).iwz = null;
    ((j)localObject2).ikk = null;
    ((e)localObject1).isE = null;
    if (((e)localObject1).isr != null) {
      ((e)localObject1).isr.release();
    }
    ((e)localObject1).isl.gJb = null;
    com.tencent.mm.sdk.b.a.udP.d(((e)localObject1).isP);
    ((e)localObject1).isn.destroy();
    ((e)localObject1).isq.destroy();
    ((e)localObject1).isp.destroy();
    ((e)localObject1).isC.destroy();
    if (((e)localObject1).isD != null) {
      ((e)localObject1).isD.destroy();
    }
    if (((e)localObject1).isv != null) {
      ((e)localObject1).isv.destroy();
    }
    if (((e)localObject1).isu != null) {
      ((e)localObject1).isu.destroy();
    }
    if (((e)localObject1).isw != null) {
      ((e)localObject1).isw.destroy();
    }
    if (((e)localObject1).isx != null) {
      ((e)localObject1).isx.destroy();
    }
    if (((e)localObject1).isy != null) {
      ((e)localObject1).isy.destroy();
    }
    if (((e)localObject1).isz != null) {
      ((e)localObject1).isz.destroy();
    }
    if (((e)localObject1).isA != null) {
      ((e)localObject1).isA.destroy();
    }
    if (((e)localObject1).isB != null) {
      ((e)localObject1).isB.destroy();
    }
    if (((e)localObject1).iss != null) {
      ((e)localObject1).iss.destroy();
    }
    ((e)localObject1).ism = null;
    localObject2 = am.aAI();
    long l;
    if ((((com.tencent.mm.plugin.card.b.g)localObject2).fKm == null) || (localObject1 == null))
    {
      am.aAI().release();
      this.ibr.cancel();
      ayX();
      l = System.currentTimeMillis() - this.mStartTime;
      if (this.ikk == null) {
        break label751;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(13219, new Object[] { "CardDetailView", Integer.valueOf(this.drX), this.ikk.azC(), this.ikk.azB(), Long.valueOf(l) });
      label535:
      if (((this.irY) || (this.irZ)) && (this.ikk != null) && (this.ikk.aze()))
      {
        if (!this.ikk.azr()) {
          break label804;
        }
        am.aAE().bl(this.ijW, 2);
      }
      label591:
      localObject1 = this.isi;
      y.i("MicroMsg.CardLbsOrBluetooth", "uninit");
      if (((com.tencent.mm.plugin.card.b.i)localObject1).ikD != null)
      {
        localObject2 = ((com.tencent.mm.plugin.card.b.i)localObject1).ikD;
        if (((i.a)localObject2).glu != null) {
          break label818;
        }
        y.e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.b.i)localObject1).ikD = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).azZ();
      ((com.tencent.mm.plugin.card.b.i)localObject1).ikI = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).ikv = null;
      super.onDestroy();
      return;
      i = 0;
      for (;;)
      {
        if (i >= ((com.tencent.mm.plugin.card.b.g)localObject2).fKm.size()) {
          break label749;
        }
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.card.b.g)localObject2).fKm.get(i);
        if (localWeakReference != null)
        {
          g.a locala = (g.a)localWeakReference.get();
          if ((locala != null) && (locala.equals(localObject1)))
          {
            ((com.tencent.mm.plugin.card.b.g)localObject2).fKm.remove(localWeakReference);
            break;
          }
        }
        i += 1;
      }
      label749:
      break;
      label751:
      com.tencent.mm.plugin.report.service.h.nFQ.f(13219, new Object[] { "CardDetailView", Integer.valueOf(this.drX), this.ijW, this.ijW, Long.valueOf(l) });
      break label535;
      label804:
      am.aAE().bl(this.ijW, 1);
      break label591;
      label818:
      ae.getContext().unregisterReceiver(((i.a)localObject2).glu);
      ((i.a)localObject2).glu = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      y.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
      eA(false);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    aBs();
    super.onPause();
    this.irU.bNW = true;
    am.aAD().a(this, false);
    ay.a(this, null);
    com.tencent.mm.plugin.card.b.i locali = this.isi;
    if (locali.aAb())
    {
      y.i("MicroMsg.CardLbsOrBluetooth", "stop");
      if (locali.ikD != null) {
        locali.ikD.aAe();
      }
      locali.azZ();
      com.tencent.mm.kernel.g.DO().dJT.b(2574, locali);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.CardDetailUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (paramArrayOfInt[0] != 0) {
        break;
      }
      y.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.iqE);
    } while (this.iqE);
    this.iqE = true;
    aBf();
    return;
    com.tencent.mm.ui.base.h.a(this, getString(a.g.permission_location_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.confirm_dialog_cancel), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        CardDetailUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
      }
    }, null);
  }
  
  protected void onResume()
  {
    super.onResume();
    aBr();
    if (this.egs != null) {
      this.egs.a(this.dig, true);
    }
    this.irU.bNW = false;
    ay.a(this, this);
    am.aAD().a(this, true);
    Object localObject;
    int i;
    if (((this.irY) || (this.irZ)) && (this.ikk.aze()))
    {
      if (!this.ikk.azr()) {
        break label212;
      }
      am.aAE().bl(this.ijW, 2);
      localObject = am.aAD();
      String str = this.ijW;
      localObject = (Boolean)((com.tencent.mm.plugin.card.b.d)localObject).ikj.get(str);
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
        break label196;
      }
      i = 1;
      if ((i == 0) || (TextUtils.isEmpty(am.aAD().ikm))) {
        break label201;
      }
      y.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
      ya(am.aAD().ikm);
      label165:
      this.irU.iss.d(com.tencent.mm.plugin.card.d.c.iyU);
    }
    for (;;)
    {
      if (this.isi.dBn) {
        this.isi.start();
      }
      return;
      label196:
      i = 0;
      break;
      label201:
      y.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
      break label165;
      label212:
      am.aAE().bl(this.ijW, 1);
      localObject = this.irU.iss;
      if (localObject != null) {
        ((com.tencent.mm.plugin.card.ui.view.g)localObject).d(com.tencent.mm.plugin.card.d.c.iyU);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ew(false);
      if ((paramm instanceof aa))
      {
        paramString = ((aa)paramm).inn;
        if (TextUtils.isEmpty(paramString)) {
          y.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
        }
      }
      label372:
      label885:
      do
      {
        for (;;)
        {
          return;
          paramm = this.ikk;
          Object localObject = new CardInfo();
          com.tencent.mm.plugin.card.d.f.a((CardInfo)localObject, paramString);
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).azB()))
          {
            this.ijW = ((com.tencent.mm.plugin.card.base.b)localObject).azB();
            this.ikk = ((com.tencent.mm.plugin.card.base.b)localObject);
            aBw();
            if (this.drX == 3)
            {
              if (paramm != null)
              {
                ((CardInfo)this.ikk).field_stickyAnnouncement = ((CardInfo)paramm).field_stickyAnnouncement;
                ((CardInfo)this.ikk).field_stickyEndTime = ((CardInfo)paramm).field_stickyEndTime;
                ((CardInfo)this.ikk).field_stickyIndex = ((CardInfo)paramm).field_stickyIndex;
                ((CardInfo)this.ikk).field_label_wording = ((CardInfo)paramm).field_label_wording;
                this.ikk.a(paramm.azA());
              }
              if (!this.ise) {
                break label372;
              }
              com.tencent.mm.plugin.card.d.l.h(this.ikk);
            }
          }
          for (;;)
          {
            aAW();
            aBu();
            if (this.ikk.azs()) {
              am.aAF().xY(this.ikk.azB());
            }
            this.isi.a(this, this.ijW, this.ikk, this.dia, this.dib);
            return;
            if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).azB())) || (this.ijW.equals(((com.tencent.mm.plugin.card.base.b)localObject).azC()))) {
              break;
            }
            y.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.ijW, ((com.tencent.mm.plugin.card.base.b)localObject).azC() });
            return;
            y.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
          }
          if ((paramm instanceof com.tencent.mm.plugin.card.model.o))
          {
            if (this.ipv == 26) {
              ew(false);
            }
            localObject = ((com.tencent.mm.plugin.card.model.o)paramm).inn;
            paramInt1 = ((com.tencent.mm.plugin.card.model.o)paramm).ino;
            paramm = ((com.tencent.mm.plugin.card.model.o)paramm).inp;
            if (paramInt1 != 0) {
              b(paramInt2, paramString, paramInt1, paramm);
            }
            while (TextUtils.isEmpty((CharSequence)localObject))
            {
              y.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
              return;
              com.tencent.mm.ui.base.h.bC(this, getResources().getString(a.g.card_add_card_pack));
            }
            this.drX = 3;
            if (this.ikk == null) {
              this.ikk = new CardInfo();
            }
            com.tencent.mm.plugin.card.d.f.a((CardInfo)this.ikk, (String)localObject);
            if (!TextUtils.isEmpty(this.ikk.azB())) {
              this.ijW = this.ikk.azB();
            }
            if (this.irU.aBO() == 1)
            {
              paramString = this.irU;
              if (paramString.isG != null)
              {
                paramString = paramString.isG;
                if (paramString.ikp != null) {
                  paramString.ikp.ilB = false;
                }
              }
            }
            if (this.ipv != 26)
            {
              aBw();
              aAW();
            }
            com.tencent.mm.plugin.card.d.l.aDc();
            paramString = this.ikk;
            if (paramString.azf())
            {
              paramm = (Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.upk, Integer.valueOf(0));
              if ((paramm == null) || (paramm.intValue() != 1))
              {
                com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upk, Integer.valueOf(1));
                if (!com.tencent.mm.plugin.card.d.l.aDf()) {
                  break label863;
                }
                com.tencent.mm.plugin.card.d.d.c(this, a.e.card_show_accepted_tips_for_share, a.g.card_accepted_title_for_share, paramString.azx().imz);
              }
              this.ish = this.ikk.azH();
              if ((this.ipv != 7) && (this.ipv != 16)) {
                break label885;
              }
              paramString = new Intent();
              paramString.putExtra("key_code", this.ish);
              setResult(-1, paramString);
              oY(-1);
            }
            for (;;)
            {
              if (this.ikk.azs()) {
                am.aAF().xY(this.ikk.azB());
              }
              this.isi.a(this, this.ijW, this.ikk, this.dia, this.dib);
              return;
              paramm = (Integer)com.tencent.mm.kernel.g.DP().Dz().get(282884, null);
              if ((paramm != null) && (paramm.intValue() == 1)) {
                break label698;
              }
              com.tencent.mm.kernel.g.DP().Dz().o(282884, Integer.valueOf(1));
              break;
              com.tencent.mm.plugin.card.d.d.c(this, a.e.card_show_accepted_tips, a.g.card_accepted_title, paramString.azx().imz);
              break label698;
              if ((!this.isd) && (this.ipv == 8)) {
                eA(true);
              } else if ((this.ipv == 26) && (paramInt1 == 0)) {
                eA(true);
              }
            }
          }
          if ((paramm instanceof v))
          {
            this.ikq = ((v)paramm).inx;
            if ((this.ikk != null) && (this.ikq != null) && (this.ikq.size() > 0))
            {
              this.ikk.a((mb)this.ikq.get(0));
              aAW();
              if (this.ikk.aze())
              {
                paramString = am.aAA().yy(this.ijW);
                if (paramString != null)
                {
                  paramString.a((mb)this.ikq.get(0));
                  am.aAA().c(paramString, new String[] { this.ijW });
                }
              }
              else
              {
                paramString = am.aAs().yi(this.ijW);
                if (paramString != null)
                {
                  paramString.a((mb)this.ikq.get(0));
                  am.aAs().c(paramString, new String[] { this.ijW });
                }
              }
            }
            else if ((this.ikk != null) && (this.ikq == null))
            {
              this.ikk.a(null);
              aAW();
              if (this.ikk.aze())
              {
                paramString = am.aAA().yy(this.ijW);
                if (paramString != null)
                {
                  paramString.a(null);
                  am.aAA().c(paramString, new String[] { this.ijW });
                }
              }
              else
              {
                paramString = am.aAs().yi(this.ijW);
                if (paramString != null)
                {
                  paramString.a(null);
                  am.aAs().c(paramString, new String[] { this.ijW });
                }
              }
            }
          }
          else if ((paramm instanceof af))
          {
            paramInt1 = ((af)paramm).ino;
            localObject = ((af)paramm).inp;
            if (paramInt1 == 10000)
            {
              paramString = (String)localObject;
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                paramString = getString(a.g.card_gift_failed_tips);
              }
              com.tencent.mm.plugin.card.d.d.b(this, paramString);
              return;
            }
            this.irX = ((af)paramm).bZd;
            ez(true);
            paramString = this.ikk.azy();
            paramString.status = 3;
            this.ikk.a(paramString);
            com.tencent.mm.plugin.card.d.l.h(this.ikk);
            aAW();
            if (this.ipv == 3)
            {
              eA(true);
              return;
            }
            if (this.ipv == 15)
            {
              paramString = new pn();
              com.tencent.mm.sdk.b.a.udP.m(paramString);
            }
          }
          else
          {
            if ((paramm instanceof r))
            {
              com.tencent.mm.ui.base.h.bC(this, getResources().getString(a.g.card_delete_success_tips));
              am.aAr();
              com.tencent.mm.plugin.card.b.b.oM(4);
              eA(true);
              return;
            }
            if ((paramm instanceof t))
            {
              paramString = ((t)paramm).inv;
              if ((paramString != null) && (paramString.size() > 0))
              {
                paramString = (com.tencent.mm.plugin.card.base.b)paramString.get(0);
                if ((paramString != null) && (!this.ijW.equals(paramString.azC())))
                {
                  y.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.ijW, paramString.azC() });
                  return;
                }
                this.ikk = paramString;
                if (this.ikk != null)
                {
                  this.ijW = this.ikk.azB();
                  aBw();
                  if (this.ikk.azs()) {
                    am.aAF().xY(this.ikk.azB());
                  }
                }
                if (this.drX == 26) {
                  this.drX = 3;
                }
                aAW();
              }
              aBu();
              com.tencent.mm.plugin.card.d.l.aDc();
              return;
            }
            if ((paramm instanceof com.tencent.mm.plugin.card.sharecard.model.g))
            {
              paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramm).inn;
              paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramm).ino;
              paramm = ((com.tencent.mm.plugin.card.sharecard.model.g)paramm).inp;
              if (paramInt1 != 0)
              {
                paramString = paramm;
                if (TextUtils.isEmpty(paramm)) {
                  paramString = getString(a.g.card_accept_fail_tips);
                }
                com.tencent.mm.plugin.card.d.d.b(this, paramString);
                y.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", new Object[] { paramString });
                return;
              }
              com.tencent.mm.ui.base.h.bC(this, getResources().getString(a.g.card_accept_success_tips));
              if (TextUtils.isEmpty(paramString))
              {
                y.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
                return;
              }
              this.drX = 3;
              if (this.ikk == null)
              {
                this.ikk = new ShareCardInfo();
                com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)this.ikk, paramString);
                paramm = (ShareCardInfo)this.ikk;
                if (!TextUtils.isEmpty(paramString)) {
                  break label2017;
                }
                y.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
                if (!TextUtils.isEmpty(this.ikk.azB())) {
                  this.ijW = this.ikk.azB();
                }
                if (TextUtils.isEmpty(this.ikk.azD())) {
                  ((ShareCardInfo)this.ikk).field_from_username = com.tencent.mm.model.q.Gj();
                }
                com.tencent.mm.plugin.card.d.l.a((ShareCardInfo)this.ikk);
                aBw();
                aAW();
                com.tencent.mm.plugin.card.d.l.aDe();
                am.aAz().axs();
                this.ish = this.ikk.azH();
                if ((this.ipv != 7) && (this.ipv != 16)) {
                  break label2109;
                }
                paramString = new Intent();
                paramString.putExtra("key_code", this.ish);
                setResult(-1, paramString);
                oY(-1);
              }
              for (;;)
              {
                for (;;)
                {
                  paramString = (Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.upi, Integer.valueOf(0));
                  if ((paramString == null) || (paramString.intValue() != 1))
                  {
                    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upi, Integer.valueOf(1));
                    com.tencent.mm.plugin.card.d.d.c(this, a.e.card_show_share_card_tips, a.g.card_share_card_tips_title, "");
                  }
                  if (!this.ikk.azs()) {
                    break;
                  }
                  am.aAF().xY(this.ikk.azB());
                  return;
                  if (!(this.ikk instanceof CardInfo)) {
                    break label1723;
                  }
                  this.ikk = new ShareCardInfo();
                  break label1723;
                  try
                  {
                    paramString = new JSONObject(paramString).optJSONArray("card_list");
                    if (paramString == null) {
                      break label1759;
                    }
                    paramm.ils = paramString.optJSONObject(0).optString("encrypt_code");
                    y.i("MicroMsg.CardInfoParser", "encrypt_code:" + paramm.ils);
                  }
                  catch (JSONException paramString)
                  {
                    y.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
                    y.e("MicroMsg.CardInfoParser", paramString.getMessage());
                  }
                }
                break label1759;
                if ((!this.isd) && (this.ipv == 8)) {
                  eA(true);
                }
              }
            }
            if (!(paramm instanceof com.tencent.mm.plugin.card.sharecard.model.c)) {
              break;
            }
            paramm = ((com.tencent.mm.plugin.card.sharecard.model.c)paramm).inn;
            if (TextUtils.isEmpty(paramm))
            {
              y.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
              return;
            }
            paramString = this.ikk;
            this.ikk = new ShareCardInfo();
            localObject = (ShareCardInfo)this.ikk;
            if (TextUtils.isEmpty(paramm))
            {
              y.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
              if (paramString != null)
              {
                if (!TextUtils.isEmpty(paramString.azD())) {
                  ((ShareCardInfo)this.ikk).field_from_username = ((ShareCardInfo)paramString).field_from_username;
                }
                ((ShareCardInfo)this.ikk).field_app_id = ((ShareCardInfo)paramString).field_app_id;
                ((ShareCardInfo)this.ikk).field_consumer = ((ShareCardInfo)paramString).field_consumer;
                ((ShareCardInfo)this.ikk).field_share_time = ((ShareCardInfo)paramString).field_share_time;
                ((ShareCardInfo)this.ikk).field_updateTime = ((ShareCardInfo)paramString).field_updateTime;
                ((ShareCardInfo)this.ikk).field_begin_time = ((ShareCardInfo)paramString).field_begin_time;
                ((ShareCardInfo)this.ikk).field_end_time = ((ShareCardInfo)paramString).field_end_time;
                ((ShareCardInfo)this.ikk).field_block_mask = ((ShareCardInfo)paramString).field_block_mask;
                this.ikk.a(paramString.azA());
                ((ShareCardInfo)this.ikk).field_categoryType = ((ShareCardInfo)paramString).field_categoryType;
                ((ShareCardInfo)this.ikk).field_itemIndex = ((ShareCardInfo)paramString).field_itemIndex;
                if (((ShareCardInfo)paramString).field_status != ((ShareCardInfo)this.ikk).field_status)
                {
                  y.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo)this.ikk).field_status);
                  com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.ikk);
                }
              }
              if (!TextUtils.isEmpty(this.ikk.azB())) {
                this.ijW = this.ikk.azB();
              }
              aAW();
              aBw();
              aBu();
              if (this.drX == 3)
              {
                if (!this.ise) {
                  break label2597;
                }
                com.tencent.mm.plugin.card.d.l.h(this.ikk);
              }
            }
            for (;;)
            {
              for (;;)
              {
                if (!this.ikk.azs()) {
                  break label2606;
                }
                am.aAF().xY(this.ikk.azB());
                return;
                try
                {
                  com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)localObject, new JSONObject(paramm));
                }
                catch (JSONException paramm)
                {
                  y.printErrStackTrace("MicroMsg.CardInfoParser", paramm, "", new Object[0]);
                }
              }
              break;
              y.e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
            }
          }
        }
      } while (!(paramm instanceof com.tencent.mm.plugin.card.sharecard.model.a));
      label698:
      label863:
      label1759:
      label2017:
      if (((com.tencent.mm.plugin.card.sharecard.model.a)paramm).ino != 0)
      {
        com.tencent.mm.plugin.card.d.d.b(this, getString(a.g.card_delete_fail_tips));
        return;
      }
      label1723:
      label2109:
      y.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.ikk.azB());
      label2597:
      label2606:
      com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.ikk);
      com.tencent.mm.ui.base.h.bC(this, getResources().getString(a.g.card_delete_success_tips));
      am.aAz().aAN();
      eA(true);
      return;
    }
    y.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " cmd:" + paramm.getType());
    ew(false);
    if ((paramm instanceof af))
    {
      ez(false);
      paramInt1 = ((af)paramm).ino;
      paramm = ((af)paramm).inp;
      if (paramInt1 != 10000) {
        break label2893;
      }
      paramString = paramm;
      if (TextUtils.isEmpty(paramm)) {
        paramString = getString(a.g.card_gift_failed_tips);
      }
    }
    label2893:
    for (;;)
    {
      paramm = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramm = getString(a.g.card_wallet_unknown_err);
      }
      Toast.makeText(this.mController.uMN, paramm, 0).show();
      return;
      if ((paramm instanceof com.tencent.mm.plugin.card.model.o))
      {
        oY(0);
        b(paramInt2, paramString, ((com.tencent.mm.plugin.card.model.o)paramm).ino, ((com.tencent.mm.plugin.card.model.o)paramm).inp);
        return;
      }
      if ((paramm instanceof v)) {
        break;
      }
    }
  }
  
  public final void onSuccess()
  {
    if ((this.irU.iss instanceof com.tencent.mm.plugin.card.ui.view.q))
    {
      ((com.tencent.mm.plugin.card.ui.view.q)this.irU.iss).iwI = am.aAF().getCode();
      this.irU.aAW();
    }
    y.i("MicroMsg.CardDetailUI", "code get success");
  }
  
  public final void xX(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    }
  }
  
  public final void ya(String paramString)
  {
    if (!this.irU.aBP())
    {
      y.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
      return;
    }
    y.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
    this.mHandler.post(new CardDetailUI.5(this, paramString));
  }
  
  public final void yd(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.ijW)))
    {
      y.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
      return;
    }
    this.irY = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailUI
 * JD-Core Version:    0.7.0.1
 */