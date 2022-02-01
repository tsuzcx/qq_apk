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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.m.e;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.f.i;
import com.tencent.mm.protocal.protobuf.bgu;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallShareCouponUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String mDesc;
  private String mTitle;
  private String mWording;
  private ProgressDialog tNC;
  private com.tencent.mm.sdk.b.c tNt;
  private String tQQ;
  private String tQR;
  private String tQS;
  private String tQT;
  private String tQU;
  private String tQV;
  private String tQW;
  private ImageView tRA;
  private TextView tRB;
  private TextView tRC;
  private View tRD;
  private IPCallDynamicTextView tRE;
  private com.tencent.mm.plugin.ipcall.model.f.b tRF;
  private LinkedList<dur> tRG;
  private boolean tRH;
  private RelativeLayout tRk;
  private TextView tRl;
  private ImageView tRm;
  private RelativeLayout tRn;
  private TextView tRo;
  private ImageView tRp;
  private LinearLayout tRq;
  private LinearLayout tRr;
  private LinearLayout tRs;
  private LinearLayout tRt;
  private ImageView tRu;
  private LinearLayout tRv;
  private ImageView tRw;
  private TextView tRx;
  private TextView tRy;
  private TextView tRz;
  
  public IPCallShareCouponUI()
  {
    AppMethodBeat.i(25953);
    this.tRF = new com.tencent.mm.plugin.ipcall.model.f.b();
    this.tQQ = null;
    this.mDesc = null;
    this.tQR = null;
    this.mTitle = null;
    this.mWording = null;
    this.tQS = null;
    this.tQT = null;
    this.tQU = null;
    this.tQV = null;
    this.tQW = null;
    this.tRG = null;
    this.tNt = new com.tencent.mm.sdk.b.c() {};
    this.tRH = false;
    AppMethodBeat.o(25953);
  }
  
  private void a(bgu parambgu)
  {
    this.tQQ = parambgu.EVP;
    this.mDesc = parambgu.Desc;
    this.tQR = parambgu.EVQ;
    this.mTitle = parambgu.Title;
    this.mWording = parambgu.tLG;
    this.tQS = parambgu.EVR;
    this.tQU = parambgu.EVS;
    this.tQV = parambgu.EVT;
    this.tQW = parambgu.EVU;
    this.tRG = parambgu.EVB;
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(25957);
    if (!bs.isNullOrNil(this.tQU))
    {
      if (this.tQT == null)
      {
        this.tRE.setValue(this.tQU, this.tQU);
        this.tQT = this.tQU;
      }
    }
    else
    {
      this.tRB.getText();
      this.tRB.setText(this.tQV);
      if (!bs.isNullOrNil(this.tQV)) {
        break label188;
      }
      this.tRB.setVisibility(8);
    }
    StringBuffer localStringBuffer;
    for (;;)
    {
      localStringBuffer = new StringBuffer("");
      if ((this.tRG == null) || (this.tRG.size() <= 0)) {
        break label199;
      }
      Iterator localIterator = this.tRG.iterator();
      while (localIterator.hasNext())
      {
        dur localdur = (dur)localIterator.next();
        if ((localdur != null) && (!bs.isNullOrNil(localdur.FFr))) {
          localStringBuffer.append(localdur.FFr).append('\n');
        }
      }
      this.tRE.setValue(this.tQT, this.tQU);
      break;
      label188:
      this.tRB.setVisibility(0);
    }
    label199:
    if (!bs.isNullOrNil(localStringBuffer.toString()))
    {
      if (localStringBuffer.charAt(localStringBuffer.length() - 1) == '\n') {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      this.tRC.setText(localStringBuffer.toString());
      this.tRC.setVisibility(0);
    }
    while ((this.tRB.getVisibility() == 0) && (this.tRC.getVisibility() == 0))
    {
      this.tRD.setVisibility(0);
      AppMethodBeat.o(25957);
      return;
      this.tRC.setText("");
      this.tRC.setVisibility(8);
    }
    this.tRD.setVisibility(8);
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
    az.agi().a(257, this);
    com.tencent.mm.sdk.b.a.GpY.c(this.tNt);
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
        paramAnonymousMenuItem = com.tencent.mm.plugin.ipcall.a.c.cVX();
        int i;
        if ((paramAnonymousMenuItem != null) && (!bs.isNullOrNil(paramAnonymousMenuItem.EVZ))) {
          if (com.tencent.mm.m.g.ZY().getInt("WCOWebPayListSwitch", 0) > 0)
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
            public final void kG(int paramAnonymous2Int)
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
    this.tRE = ((IPCallDynamicTextView)findViewById(2131297085));
    this.tRk = ((RelativeLayout)findViewById(2131303817));
    this.tRl = ((TextView)findViewById(2131303836));
    this.tRm = ((ImageView)findViewById(2131303823));
    az.ayM();
    if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GGx, Boolean.FALSE)).booleanValue()) {
      this.tRm.setVisibility(0);
    }
    az.ayM();
    paramBundle = (String)com.tencent.mm.model.c.agA().get(ah.a.GGw, "");
    this.tRl.setText(paramBundle);
    this.tRn = ((RelativeLayout)findViewById(2131303546));
    this.tRo = ((TextView)findViewById(2131303123));
    this.tRp = ((ImageView)findViewById(2131303120));
    az.ayM();
    paramBundle = (String)com.tencent.mm.model.c.agA().get(ah.a.GGy, "");
    this.tRo.setText(paramBundle);
    this.tRB = ((TextView)findViewById(2131298812));
    this.tRC = ((TextView)findViewById(2131303118));
    this.tRD = findViewById(2131304848);
    this.tRq = ((LinearLayout)findViewById(2131299541));
    this.tRA = ((ImageView)findViewById(2131302741));
    az.ayM();
    if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GGz, Boolean.FALSE)).booleanValue()) {
      this.tRA.setVisibility(0);
    }
    this.tRx = ((TextView)findViewById(2131302899));
    this.tRy = ((TextView)findViewById(2131296519));
    this.tRz = ((TextView)findViewById(2131305240));
    this.tRr = ((LinearLayout)findViewById(2131304739));
    this.tRs = ((LinearLayout)findViewById(2131302648));
    this.tRv = ((LinearLayout)findViewById(2131304479));
    this.tRw = ((ImageView)findViewById(2131304480));
    this.tRt = ((LinearLayout)findViewById(2131302523));
    this.tRu = ((ImageView)findViewById(2131302524));
    az.ayM();
    if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GGF, Boolean.FALSE)).booleanValue()) {
      this.tRu.setVisibility(0);
    }
    int i;
    label559:
    label587:
    label593:
    label614:
    Object localObject1;
    label779:
    Object localObject2;
    if (com.tencent.mm.plugin.ipcall.a.c.cVW())
    {
      i = 1;
      if (i != 0) {
        this.tRk.setVisibility(8);
      }
      if ((com.tencent.mm.plugin.ipcall.a.c.cVW()) || (com.tencent.mm.m.g.ZY().getInt("WCOPackagePurchaseSwitch", 0) == 0)) {
        break label1059;
      }
      i = 1;
      if (i != 0) {
        this.tRn.setVisibility(0);
      }
      if (com.tencent.mm.m.g.ZY().getInt("WCOAccountDetailSwitch", 0) != 1) {
        break label1064;
      }
      i = 1;
      if (i == 0) {
        break label1069;
      }
      i = 1;
      if (i != 0) {
        this.tRq.setVisibility(8);
      }
      if (!com.tencent.mm.plugin.ipcall.a.c.cVW()) {
        break label1074;
      }
      i = 1;
      if (i != 0) {
        this.tRr.setVisibility(8);
      }
      this.tRx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25946);
          IPCallShareCouponUI.d(IPCallShareCouponUI.this);
          AppMethodBeat.o(25946);
        }
      });
      this.tRy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25947);
          IPCallShareCouponUI.e(IPCallShareCouponUI.this);
          AppMethodBeat.o(25947);
        }
      });
      this.tRq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25948);
          IPCallShareCouponUI.f(IPCallShareCouponUI.this);
          AppMethodBeat.o(25948);
        }
      });
      this.tRr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25949);
          com.tencent.mm.plugin.report.service.h.wUl.f(13340, new Object[] { Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
          Object localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallShareCouponCardUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(25949);
        }
      });
      this.tRt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25950);
          az.ayM();
          if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GGF, Boolean.FALSE)).booleanValue())
          {
            az.ayM();
            i.ah(4, -1, ((Integer)com.tencent.mm.model.c.agA().get(ah.a.GGG, Integer.valueOf(-1))).intValue());
          }
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GGG, Integer.valueOf(-1));
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GGF, Boolean.FALSE);
          IPCallShareCouponUI.g(IPCallShareCouponUI.this).setVisibility(8);
          Object localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallMsgUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(25950);
        }
      });
      this.tRs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25951);
          Object localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallMyGiftCardUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(25951);
        }
      });
      this.tRk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25952);
          az.ayM();
          if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GGx, Boolean.FALSE)).booleanValue() == true) {
            i.ah(3, -1, -1);
          }
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GGx, Boolean.FALSE);
          IPCallShareCouponUI.a(IPCallShareCouponUI.this).setVisibility(8);
          Object localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallRechargeUI.class);
          paramAnonymousView = IPCallShareCouponUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(25952);
        }
      });
      this.tRn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25937);
          Object localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallPackageUI.class);
          paramAnonymousView = IPCallShareCouponUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(25937);
        }
      });
      this.tRv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25938);
          Intent localIntent = new Intent();
          paramAnonymousView = IPCallShareCouponUI.this.getString(2131760480) + "&usedcc=";
          Object localObject = com.tencent.mm.plugin.ipcall.model.c.cUg().cUj();
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
              String str = com.tencent.mm.plugin.ipcall.a.a.ajn(((Integer)((List)localObject).get(j)).toString());
              if (bs.isNullOrNil(str)) {
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
            for (localObject = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);; localObject = paramAnonymousView + com.tencent.mm.plugin.ipcall.a.a.ajn(com.tencent.mm.plugin.ipcall.a.c.cVU()))
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
      paramBundle = com.tencent.mm.plugin.ipcall.a.c.cVX();
      if (paramBundle == null) {
        break label1109;
      }
      a(paramBundle);
      refreshView();
      if (!com.tencent.mm.plugin.ipcall.a.c.cVW()) {
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
          Object localObject = ab.iC(ai.getContext());
          if (!bs.isNullOrNil((String)localObject)) {
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
      this.tRz.setText((CharSequence)localObject2);
      this.tRz.setMovementMethod(LinkMovementMethod.getInstance());
      this.tRz.setVisibility(0);
    }
    for (;;)
    {
      paramBundle = (LinearLayout)findViewById(2131301348);
      if ((paramBundle != null) && (this.tRk.getVisibility() == 8) && (this.tRn.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      paramBundle = (LinearLayout)findViewById(2131301350);
      if ((paramBundle != null) && (this.tRr.getVisibility() == 8) && (this.tRs.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      this.tRF.start();
      AppMethodBeat.o(25954);
      return;
      if (com.tencent.mm.m.g.ZY().getInt("WCOPurchaseSwitch", 0) == 1) {}
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
      if (com.tencent.mm.m.g.ZY().getInt("WCOInviteFriend", 0) == 1) {}
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
      this.tRE.setText("0");
      paramBundle = getContext();
      getString(2131755906);
      this.tNC = com.tencent.mm.ui.base.h.b(paramBundle, getString(2131760457), true, new DialogInterface.OnCancelListener()
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
            ac.e("MicroMsg.IPCallShareCouponUI", "IPCallShareCouponUI error: %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
            AppMethodBeat.o(25939);
          }
        }
      });
      break label779;
      label1159:
      ((Spannable)localObject2).setSpan(localObject1, 0, ((Spannable)localObject2).length(), 33);
      break label893;
      label1181:
      this.tRz.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25956);
    super.onDestroy();
    az.agi().b(257, this);
    com.tencent.mm.sdk.b.a.GpY.d(this.tNt);
    this.tRF.tKT = bs.eWj();
    this.tRF.finish();
    AppMethodBeat.o(25956);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25955);
    super.onResume();
    com.tencent.mm.plugin.ipcall.model.g.b.cUX().nr(false);
    AppMethodBeat.o(25955);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25958);
    if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.g))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(((com.tencent.mm.plugin.ipcall.model.e.g)paramn).tKB);
        refreshView();
        if ((this.tNC != null) && (this.tNC.isShowing())) {
          this.tNC.dismiss();
        }
        AppMethodBeat.o(25958);
        return;
      }
      if ((this.tNC != null) && (this.tNC.isShowing()))
      {
        this.tNC.dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI
 * JD-Core Version:    0.7.0.1
 */