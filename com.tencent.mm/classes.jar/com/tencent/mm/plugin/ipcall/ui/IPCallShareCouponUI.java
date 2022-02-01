package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.m.e;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.f.i;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallShareCouponUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String mDesc;
  private String mTitle;
  private String mWording;
  private com.tencent.mm.sdk.b.c sFM;
  private ProgressDialog sFV;
  private RelativeLayout sJE;
  private TextView sJF;
  private ImageView sJG;
  private RelativeLayout sJH;
  private TextView sJI;
  private ImageView sJJ;
  private LinearLayout sJK;
  private LinearLayout sJL;
  private LinearLayout sJM;
  private LinearLayout sJN;
  private ImageView sJO;
  private LinearLayout sJP;
  private ImageView sJQ;
  private TextView sJR;
  private TextView sJS;
  private TextView sJT;
  private ImageView sJU;
  private TextView sJV;
  private TextView sJW;
  private View sJX;
  private IPCallDynamicTextView sJY;
  private com.tencent.mm.plugin.ipcall.model.f.b sJZ;
  private String sJk;
  private String sJl;
  private String sJm;
  private String sJn;
  private String sJo;
  private String sJp;
  private String sJq;
  private LinkedList<dpa> sKa;
  private boolean sKb;
  
  public IPCallShareCouponUI()
  {
    AppMethodBeat.i(25953);
    this.sJZ = new com.tencent.mm.plugin.ipcall.model.f.b();
    this.sJk = null;
    this.mDesc = null;
    this.sJl = null;
    this.mTitle = null;
    this.mWording = null;
    this.sJm = null;
    this.sJn = null;
    this.sJo = null;
    this.sJp = null;
    this.sJq = null;
    this.sKa = null;
    this.sFM = new com.tencent.mm.sdk.b.c() {};
    this.sKb = false;
    AppMethodBeat.o(25953);
  }
  
  private void a(bdc parambdc)
  {
    this.sJk = parambdc.DAt;
    this.mDesc = parambdc.Desc;
    this.sJl = parambdc.DAu;
    this.mTitle = parambdc.Title;
    this.mWording = parambdc.sDZ;
    this.sJm = parambdc.DAv;
    this.sJo = parambdc.DAw;
    this.sJp = parambdc.DAx;
    this.sJq = parambdc.DAy;
    this.sKa = parambdc.DAf;
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(25957);
    if (!bt.isNullOrNil(this.sJo))
    {
      if (this.sJn == null)
      {
        this.sJY.setValue(this.sJo, this.sJo);
        this.sJn = this.sJo;
      }
    }
    else
    {
      this.sJV.getText();
      this.sJV.setText(this.sJp);
      if (!bt.isNullOrNil(this.sJp)) {
        break label188;
      }
      this.sJV.setVisibility(8);
    }
    StringBuffer localStringBuffer;
    for (;;)
    {
      localStringBuffer = new StringBuffer("");
      if ((this.sKa == null) || (this.sKa.size() <= 0)) {
        break label199;
      }
      Iterator localIterator = this.sKa.iterator();
      while (localIterator.hasNext())
      {
        dpa localdpa = (dpa)localIterator.next();
        if ((localdpa != null) && (!bt.isNullOrNil(localdpa.Eit))) {
          localStringBuffer.append(localdpa.Eit).append('\n');
        }
      }
      this.sJY.setValue(this.sJn, this.sJo);
      break;
      label188:
      this.sJV.setVisibility(0);
    }
    label199:
    if (!bt.isNullOrNil(localStringBuffer.toString()))
    {
      if (localStringBuffer.charAt(localStringBuffer.length() - 1) == '\n') {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      this.sJW.setText(localStringBuffer.toString());
      this.sJW.setVisibility(0);
    }
    while ((this.sJV.getVisibility() == 0) && (this.sJW.getVisibility() == 0))
    {
      this.sJX.setVisibility(0);
      AppMethodBeat.o(25957);
      return;
      this.sJW.setText("");
      this.sJW.setVisibility(8);
    }
    this.sJX.setVisibility(8);
    AppMethodBeat.o(25957);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494505;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25954);
    super.onCreate(paramBundle);
    az.aeS().a(257, this);
    com.tencent.mm.sdk.b.a.ESL.c(this.sFM);
    setMMTitle(2131760508);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25945);
        IPCallShareCouponUI.this.finish();
        AppMethodBeat.o(25945);
        return true;
      }
    });
    removeAllOptionMenu();
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25943);
        paramAnonymousMenuItem = com.tencent.mm.plugin.ipcall.a.c.cIM();
        int i;
        if ((paramAnonymousMenuItem != null) && (!bt.isNullOrNil(paramAnonymousMenuItem.DAD))) {
          if (com.tencent.mm.m.g.Zd().getInt("WCOWebPayListSwitch", 0) > 0)
          {
            i = 1;
            if (i == 0) {
              break label133;
            }
            i = 1;
            label44:
            if (i == 0) {
              break label138;
            }
            paramAnonymousMenuItem = new String[3];
            paramAnonymousMenuItem[0] = IPCallShareCouponUI.this.getString(2131760507);
            paramAnonymousMenuItem[1] = IPCallShareCouponUI.this.getString(2131760450);
            paramAnonymousMenuItem[2] = IPCallShareCouponUI.this.getString(2131760429);
            IPCallShareCouponUI.a(IPCallShareCouponUI.this, true);
          }
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.b(IPCallShareCouponUI.this.getContext(), null, paramAnonymousMenuItem, null, new h.c()
          {
            public final void kM(int paramAnonymous2Int)
            {
              AppMethodBeat.i(25942);
              int i = paramAnonymous2Int;
              if (!IPCallShareCouponUI.h(IPCallShareCouponUI.this)) {
                i = paramAnonymous2Int + 1;
              }
              switch (i)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(25942);
                return;
                IPCallShareCouponUI.i(IPCallShareCouponUI.this);
                AppMethodBeat.o(25942);
                return;
                IPCallShareCouponUI.d(IPCallShareCouponUI.this);
                AppMethodBeat.o(25942);
                return;
                IPCallShareCouponUI.e(IPCallShareCouponUI.this);
              }
            }
          });
          AppMethodBeat.o(25943);
          return true;
          i = 0;
          break;
          label133:
          i = 0;
          break label44;
          label138:
          paramAnonymousMenuItem = new String[2];
          paramAnonymousMenuItem[0] = IPCallShareCouponUI.this.getString(2131760450);
          paramAnonymousMenuItem[1] = IPCallShareCouponUI.this.getString(2131760429);
          IPCallShareCouponUI.a(IPCallShareCouponUI.this, false);
        }
      }
    });
    this.sJY = ((IPCallDynamicTextView)findViewById(2131297085));
    this.sJE = ((RelativeLayout)findViewById(2131303817));
    this.sJF = ((TextView)findViewById(2131303836));
    this.sJG = ((ImageView)findViewById(2131303823));
    az.arV();
    if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FiI, Boolean.FALSE)).booleanValue()) {
      this.sJG.setVisibility(0);
    }
    az.arV();
    paramBundle = (String)com.tencent.mm.model.c.afk().get(ae.a.FiH, "");
    this.sJF.setText(paramBundle);
    this.sJH = ((RelativeLayout)findViewById(2131303546));
    this.sJI = ((TextView)findViewById(2131303123));
    this.sJJ = ((ImageView)findViewById(2131303120));
    az.arV();
    paramBundle = (String)com.tencent.mm.model.c.afk().get(ae.a.FiJ, "");
    this.sJI.setText(paramBundle);
    this.sJV = ((TextView)findViewById(2131298812));
    this.sJW = ((TextView)findViewById(2131303118));
    this.sJX = findViewById(2131304848);
    this.sJK = ((LinearLayout)findViewById(2131299541));
    this.sJU = ((ImageView)findViewById(2131302741));
    az.arV();
    if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FiK, Boolean.FALSE)).booleanValue()) {
      this.sJU.setVisibility(0);
    }
    this.sJR = ((TextView)findViewById(2131302899));
    this.sJS = ((TextView)findViewById(2131296519));
    this.sJT = ((TextView)findViewById(2131305240));
    this.sJL = ((LinearLayout)findViewById(2131304739));
    this.sJM = ((LinearLayout)findViewById(2131302648));
    this.sJP = ((LinearLayout)findViewById(2131304479));
    this.sJQ = ((ImageView)findViewById(2131304480));
    this.sJN = ((LinearLayout)findViewById(2131302523));
    this.sJO = ((ImageView)findViewById(2131302524));
    az.arV();
    if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FiQ, Boolean.FALSE)).booleanValue()) {
      this.sJO.setVisibility(0);
    }
    int i;
    label559:
    label587:
    label593:
    label614:
    Object localObject1;
    label779:
    Object localObject2;
    if (com.tencent.mm.plugin.ipcall.a.c.cIL())
    {
      i = 1;
      if (i != 0) {
        this.sJE.setVisibility(8);
      }
      if ((com.tencent.mm.plugin.ipcall.a.c.cIL()) || (com.tencent.mm.m.g.Zd().getInt("WCOPackagePurchaseSwitch", 0) == 0)) {
        break label1059;
      }
      i = 1;
      if (i != 0) {
        this.sJH.setVisibility(0);
      }
      if (com.tencent.mm.m.g.Zd().getInt("WCOAccountDetailSwitch", 0) != 1) {
        break label1064;
      }
      i = 1;
      if (i == 0) {
        break label1069;
      }
      i = 1;
      if (i != 0) {
        this.sJK.setVisibility(8);
      }
      if (!com.tencent.mm.plugin.ipcall.a.c.cIL()) {
        break label1074;
      }
      i = 1;
      if (i != 0) {
        this.sJL.setVisibility(8);
      }
      this.sJR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25946);
          IPCallShareCouponUI.d(IPCallShareCouponUI.this);
          AppMethodBeat.o(25946);
        }
      });
      this.sJS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25947);
          IPCallShareCouponUI.e(IPCallShareCouponUI.this);
          AppMethodBeat.o(25947);
        }
      });
      this.sJK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25948);
          IPCallShareCouponUI.f(IPCallShareCouponUI.this);
          AppMethodBeat.o(25948);
        }
      });
      this.sJL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25949);
          com.tencent.mm.plugin.report.service.h.vKh.f(13340, new Object[] { Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
          Object localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallShareCouponCardUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(25949);
        }
      });
      this.sJN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25950);
          az.arV();
          if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FiQ, Boolean.FALSE)).booleanValue())
          {
            az.arV();
            i.ag(4, -1, ((Integer)com.tencent.mm.model.c.afk().get(ae.a.FiR, Integer.valueOf(-1))).intValue());
          }
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.FiR, Integer.valueOf(-1));
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.FiQ, Boolean.FALSE);
          IPCallShareCouponUI.g(IPCallShareCouponUI.this).setVisibility(8);
          Object localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallMsgUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(25950);
        }
      });
      this.sJM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25951);
          Object localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallMyGiftCardUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(25951);
        }
      });
      this.sJE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25952);
          az.arV();
          if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FiI, Boolean.FALSE)).booleanValue() == true) {
            i.ag(3, -1, -1);
          }
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.FiI, Boolean.FALSE);
          IPCallShareCouponUI.a(IPCallShareCouponUI.this).setVisibility(8);
          Object localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallRechargeUI.class);
          paramAnonymousView = IPCallShareCouponUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(25952);
        }
      });
      this.sJH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25937);
          Object localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallPackageUI.class);
          paramAnonymousView = IPCallShareCouponUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(25937);
        }
      });
      this.sJP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25938);
          Intent localIntent = new Intent();
          paramAnonymousView = IPCallShareCouponUI.this.getString(2131760480) + "&usedcc=";
          Object localObject = com.tencent.mm.plugin.ipcall.model.c.cGV().cGY();
          int j;
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            j = ((List)localObject).size();
            int i = j;
            if (j > 5) {
              i = 5;
            }
            j = 0;
            if (j < i)
            {
              String str = com.tencent.mm.plugin.ipcall.a.a.aev(((Integer)((List)localObject).get(j)).toString());
              if (bt.isNullOrNil(str)) {
                break label241;
              }
              paramAnonymousView = paramAnonymousView + str + "|";
            }
          }
          label241:
          for (;;)
          {
            j += 1;
            break;
            localObject = paramAnonymousView;
            if (paramAnonymousView.endsWith("|")) {}
            for (localObject = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);; localObject = paramAnonymousView + com.tencent.mm.plugin.ipcall.a.a.aev(com.tencent.mm.plugin.ipcall.a.c.cIJ()))
            {
              localIntent.putExtra("rawUrl", (String)localObject);
              localIntent.putExtra("showShare", false);
              d.b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
              AppMethodBeat.o(25938);
              return;
            }
          }
        }
      });
      paramBundle = com.tencent.mm.plugin.ipcall.a.c.cIM();
      if (paramBundle == null) {
        break label1109;
      }
      a(paramBundle);
      refreshView();
      if (!com.tencent.mm.plugin.ipcall.a.c.cIL()) {
        break label1181;
      }
      paramBundle = getString(2131760564);
      localObject1 = getString(2131760563);
      localObject2 = paramBundle + (String)localObject1;
      localObject1 = new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25940);
          ((TextView)paramAnonymousView).setHighlightColor(IPCallShareCouponUI.this.getResources().getColor(2131101053));
          paramAnonymousView = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=weixin_phone/notice";
          Object localObject = ac.ir(aj.getContext());
          if (!bt.isNullOrNil((String)localObject)) {
            paramAnonymousView = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=weixin_phone/notice" + "&wechat_real_lang=" + (String)localObject;
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
          ((Intent)localObject).putExtra("showShare", false);
          d.b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          AppMethodBeat.o(25940);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(25941);
          paramAnonymousTextPaint.setColor(IPCallShareCouponUI.this.getResources().getColor(2131100547));
          paramAnonymousTextPaint.setUnderlineText(false);
          AppMethodBeat.o(25941);
        }
      };
      localObject2 = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject2);
      i = paramBundle.length();
      int j = ((Spannable)localObject2).length();
      if ((i < 0) || (i >= j) || (j < 0) || (j > ((Spannable)localObject2).length())) {
        break label1159;
      }
      ((Spannable)localObject2).setSpan(localObject1, i, j, 33);
      label893:
      this.sJT.setText((CharSequence)localObject2);
      this.sJT.setMovementMethod(LinkMovementMethod.getInstance());
      this.sJT.setVisibility(0);
    }
    for (;;)
    {
      paramBundle = (LinearLayout)findViewById(2131301348);
      if ((paramBundle != null) && (this.sJE.getVisibility() == 8) && (this.sJH.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      paramBundle = (LinearLayout)findViewById(2131301350);
      if ((paramBundle != null) && (this.sJL.getVisibility() == 8) && (this.sJM.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      this.sJZ.start();
      AppMethodBeat.o(25954);
      return;
      if (com.tencent.mm.m.g.Zd().getInt("WCOPurchaseSwitch", 0) == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1054;
        }
        i = 1;
        break;
      }
      label1054:
      i = 0;
      break;
      label1059:
      i = 0;
      break label559;
      label1064:
      i = 0;
      break label587;
      label1069:
      i = 0;
      break label593;
      label1074:
      if (com.tencent.mm.m.g.Zd().getInt("WCOInviteFriend", 0) == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1104;
        }
        i = 1;
        break;
      }
      label1104:
      i = 0;
      break label614;
      label1109:
      this.sJY.setText("0");
      paramBundle = getContext();
      getString(2131755906);
      this.sFV = com.tencent.mm.ui.base.h.b(paramBundle, getString(2131760457), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25939);
          try
          {
            IPCallShareCouponUI.this.finish();
            AppMethodBeat.o(25939);
            return;
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            ad.e("MicroMsg.IPCallShareCouponUI", "IPCallShareCouponUI error: %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
            AppMethodBeat.o(25939);
          }
        }
      });
      break label779;
      label1159:
      ((Spannable)localObject2).setSpan(localObject1, 0, ((Spannable)localObject2).length(), 33);
      break label893;
      label1181:
      this.sJT.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25956);
    super.onDestroy();
    az.aeS().b(257, this);
    com.tencent.mm.sdk.b.a.ESL.d(this.sFM);
    this.sJZ.sDl = bt.eGO();
    this.sJZ.finish();
    AppMethodBeat.o(25956);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25955);
    super.onResume();
    com.tencent.mm.plugin.ipcall.model.g.b.cHM().my(false);
    AppMethodBeat.o(25955);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25958);
    if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.g))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(((com.tencent.mm.plugin.ipcall.model.e.g)paramn).sCT);
        refreshView();
        if ((this.sFV != null) && (this.sFV.isShowing())) {
          this.sFV.dismiss();
        }
        AppMethodBeat.o(25958);
        return;
      }
      if ((this.sFV != null) && (this.sFV.isShowing()))
      {
        this.sFV.dismiss();
        com.tencent.mm.ui.base.h.d(getContext(), getString(2131760455), getString(2131760448), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25944);
            IPCallShareCouponUI.this.finish();
            AppMethodBeat.o(25944);
          }
        });
      }
    }
    AppMethodBeat.o(25958);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI
 * JD-Core Version:    0.7.0.1
 */