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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.model.ba;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.ipcall.model.f.i;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.eal;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallShareCouponUI
  extends MMActivity
  implements f
{
  private String mDesc;
  private String mTitle;
  private String mWording;
  private com.tencent.mm.sdk.b.c uQg;
  private ProgressDialog uQp;
  private String uTD;
  private String uTE;
  private String uTF;
  private String uTG;
  private String uTH;
  private String uTI;
  private String uTJ;
  private RelativeLayout uTX;
  private TextView uTY;
  private ImageView uTZ;
  private RelativeLayout uUa;
  private TextView uUb;
  private ImageView uUc;
  private LinearLayout uUd;
  private LinearLayout uUe;
  private LinearLayout uUf;
  private LinearLayout uUg;
  private ImageView uUh;
  private LinearLayout uUi;
  private ImageView uUj;
  private TextView uUk;
  private TextView uUl;
  private TextView uUm;
  private ImageView uUn;
  private TextView uUo;
  private TextView uUp;
  private View uUq;
  private IPCallDynamicTextView uUr;
  private com.tencent.mm.plugin.ipcall.model.f.b uUs;
  private LinkedList<eal> uUt;
  private boolean uUu;
  
  public IPCallShareCouponUI()
  {
    AppMethodBeat.i(25953);
    this.uUs = new com.tencent.mm.plugin.ipcall.model.f.b();
    this.uTD = null;
    this.mDesc = null;
    this.uTE = null;
    this.mTitle = null;
    this.mWording = null;
    this.uTF = null;
    this.uTG = null;
    this.uTH = null;
    this.uTI = null;
    this.uTJ = null;
    this.uUt = null;
    this.uQg = new com.tencent.mm.sdk.b.c() {};
    this.uUu = false;
    AppMethodBeat.o(25953);
  }
  
  private void a(blc paramblc)
  {
    this.uTD = paramblc.GFm;
    this.mDesc = paramblc.Desc;
    this.uTE = paramblc.GFn;
    this.mTitle = paramblc.Title;
    this.mWording = paramblc.uOt;
    this.uTF = paramblc.GFo;
    this.uTH = paramblc.GFp;
    this.uTI = paramblc.GFq;
    this.uTJ = paramblc.GFr;
    this.uUt = paramblc.GEZ;
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(25957);
    if (!bt.isNullOrNil(this.uTH))
    {
      if (this.uTG == null)
      {
        this.uUr.setValue(this.uTH, this.uTH);
        this.uTG = this.uTH;
      }
    }
    else
    {
      this.uUo.getText();
      this.uUo.setText(this.uTI);
      if (!bt.isNullOrNil(this.uTI)) {
        break label188;
      }
      this.uUo.setVisibility(8);
    }
    StringBuffer localStringBuffer;
    for (;;)
    {
      localStringBuffer = new StringBuffer("");
      if ((this.uUt == null) || (this.uUt.size() <= 0)) {
        break label199;
      }
      Iterator localIterator = this.uUt.iterator();
      while (localIterator.hasNext())
      {
        eal localeal = (eal)localIterator.next();
        if ((localeal != null) && (!bt.isNullOrNil(localeal.HpQ))) {
          localStringBuffer.append(localeal.HpQ).append('\n');
        }
      }
      this.uUr.setValue(this.uTG, this.uTH);
      break;
      label188:
      this.uUo.setVisibility(0);
    }
    label199:
    if (!bt.isNullOrNil(localStringBuffer.toString()))
    {
      if (localStringBuffer.charAt(localStringBuffer.length() - 1) == '\n') {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      this.uUp.setText(localStringBuffer.toString());
      this.uUp.setVisibility(0);
    }
    while ((this.uUo.getVisibility() == 0) && (this.uUp.getVisibility() == 0))
    {
      this.uUq.setVisibility(0);
      AppMethodBeat.o(25957);
      return;
      this.uUp.setText("");
      this.uUp.setVisibility(8);
    }
    this.uUq.setVisibility(8);
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
    ba.aiU().a(257, this);
    com.tencent.mm.sdk.b.a.IbL.c(this.uQg);
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
        paramAnonymousMenuItem = com.tencent.mm.plugin.ipcall.a.c.dfi();
        int i;
        if ((paramAnonymousMenuItem != null) && (!bt.isNullOrNil(paramAnonymousMenuItem.GFw))) {
          if (com.tencent.mm.n.g.acA().getInt("WCOWebPayListSwitch", 0) > 0)
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
          h.b(IPCallShareCouponUI.this.getContext(), null, paramAnonymousMenuItem, null, new h.c()
          {
            public final void lf(int paramAnonymous2Int)
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
    this.uUr = ((IPCallDynamicTextView)findViewById(2131297085));
    this.uTX = ((RelativeLayout)findViewById(2131303817));
    this.uTY = ((TextView)findViewById(2131303836));
    this.uTZ = ((ImageView)findViewById(2131303823));
    ba.aBQ();
    if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.IsP, Boolean.FALSE)).booleanValue()) {
      this.uTZ.setVisibility(0);
    }
    ba.aBQ();
    paramBundle = (String)com.tencent.mm.model.c.ajl().get(al.a.IsO, "");
    this.uTY.setText(paramBundle);
    this.uUa = ((RelativeLayout)findViewById(2131303546));
    this.uUb = ((TextView)findViewById(2131303123));
    this.uUc = ((ImageView)findViewById(2131303120));
    ba.aBQ();
    paramBundle = (String)com.tencent.mm.model.c.ajl().get(al.a.IsQ, "");
    this.uUb.setText(paramBundle);
    this.uUo = ((TextView)findViewById(2131298812));
    this.uUp = ((TextView)findViewById(2131303118));
    this.uUq = findViewById(2131304848);
    this.uUd = ((LinearLayout)findViewById(2131299541));
    this.uUn = ((ImageView)findViewById(2131302741));
    ba.aBQ();
    if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.IsR, Boolean.FALSE)).booleanValue()) {
      this.uUn.setVisibility(0);
    }
    this.uUk = ((TextView)findViewById(2131302899));
    this.uUl = ((TextView)findViewById(2131296519));
    this.uUm = ((TextView)findViewById(2131305240));
    this.uUe = ((LinearLayout)findViewById(2131304739));
    this.uUf = ((LinearLayout)findViewById(2131302648));
    this.uUi = ((LinearLayout)findViewById(2131304479));
    this.uUj = ((ImageView)findViewById(2131304480));
    this.uUg = ((LinearLayout)findViewById(2131302523));
    this.uUh = ((ImageView)findViewById(2131302524));
    ba.aBQ();
    if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.IsX, Boolean.FALSE)).booleanValue()) {
      this.uUh.setVisibility(0);
    }
    int i;
    label559:
    label587:
    label593:
    label614:
    Object localObject1;
    label779:
    Object localObject2;
    if (com.tencent.mm.plugin.ipcall.a.c.dfh())
    {
      i = 1;
      if (i != 0) {
        this.uTX.setVisibility(8);
      }
      if ((com.tencent.mm.plugin.ipcall.a.c.dfh()) || (com.tencent.mm.n.g.acA().getInt("WCOPackagePurchaseSwitch", 0) == 0)) {
        break label1059;
      }
      i = 1;
      if (i != 0) {
        this.uUa.setVisibility(0);
      }
      if (com.tencent.mm.n.g.acA().getInt("WCOAccountDetailSwitch", 0) != 1) {
        break label1064;
      }
      i = 1;
      if (i == 0) {
        break label1069;
      }
      i = 1;
      if (i != 0) {
        this.uUd.setVisibility(8);
      }
      if (!com.tencent.mm.plugin.ipcall.a.c.dfh()) {
        break label1074;
      }
      i = 1;
      if (i != 0) {
        this.uUe.setVisibility(8);
      }
      this.uUk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25946);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          IPCallShareCouponUI.d(IPCallShareCouponUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25946);
        }
      });
      this.uUl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25947);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          IPCallShareCouponUI.e(IPCallShareCouponUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25947);
        }
      });
      this.uUd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25948);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          IPCallShareCouponUI.f(IPCallShareCouponUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25948);
        }
      });
      this.uUe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25949);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          com.tencent.mm.plugin.report.service.g.yhR.f(13340, new Object[] { Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallShareCouponCardUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25949);
        }
      });
      this.uUg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25950);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          ba.aBQ();
          if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.IsX, Boolean.FALSE)).booleanValue())
          {
            ba.aBQ();
            i.ah(4, -1, ((Integer)com.tencent.mm.model.c.ajl().get(al.a.IsY, Integer.valueOf(-1))).intValue());
          }
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.IsY, Integer.valueOf(-1));
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.IsX, Boolean.FALSE);
          IPCallShareCouponUI.g(IPCallShareCouponUI.this).setVisibility(8);
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallMsgUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25950);
        }
      });
      this.uUf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25951);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallMyGiftCardUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25951);
        }
      });
      this.uTX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25952);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          ba.aBQ();
          if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.IsP, Boolean.FALSE)).booleanValue() == true) {
            i.ah(3, -1, -1);
          }
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(al.a.IsP, Boolean.FALSE);
          IPCallShareCouponUI.a(IPCallShareCouponUI.this).setVisibility(8);
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallRechargeUI.class);
          paramAnonymousView = IPCallShareCouponUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25952);
        }
      });
      this.uUa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25937);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallPackageUI.class);
          paramAnonymousView = IPCallShareCouponUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25937);
        }
      });
      this.uUi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25938);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          Intent localIntent = new Intent();
          paramAnonymousView = IPCallShareCouponUI.this.getString(2131760480) + "&usedcc=";
          localObject = com.tencent.mm.plugin.ipcall.model.c.ddr().ddu();
          int i;
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            i = ((List)localObject).size();
            if (i <= 5) {
              break label286;
            }
            i = 5;
          }
          label283:
          label286:
          for (;;)
          {
            int j = 0;
            if (j < i)
            {
              String str = com.tencent.mm.plugin.ipcall.a.a.aoa(((Integer)((List)localObject).get(j)).toString());
              if (bt.isNullOrNil(str)) {
                break label283;
              }
              paramAnonymousView = paramAnonymousView + str + "|";
            }
            for (;;)
            {
              j += 1;
              break;
              localObject = paramAnonymousView;
              if (paramAnonymousView.endsWith("|")) {}
              for (localObject = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);; localObject = paramAnonymousView + com.tencent.mm.plugin.ipcall.a.a.aoa(com.tencent.mm.plugin.ipcall.a.c.dff()))
              {
                localIntent.putExtra("rawUrl", (String)localObject);
                localIntent.putExtra("showShare", false);
                d.b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25938);
                return;
              }
            }
          }
        }
      });
      paramBundle = com.tencent.mm.plugin.ipcall.a.c.dfi();
      if (paramBundle == null) {
        break label1109;
      }
      a(paramBundle);
      refreshView();
      if (!com.tencent.mm.plugin.ipcall.a.c.dfh()) {
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
          Object localObject = ac.iM(aj.getContext());
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
      this.uUm.setText((CharSequence)localObject2);
      this.uUm.setMovementMethod(LinkMovementMethod.getInstance());
      this.uUm.setVisibility(0);
    }
    for (;;)
    {
      paramBundle = (LinearLayout)findViewById(2131301348);
      if ((paramBundle != null) && (this.uTX.getVisibility() == 8) && (this.uUa.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      paramBundle = (LinearLayout)findViewById(2131301350);
      if ((paramBundle != null) && (this.uUe.getVisibility() == 8) && (this.uUf.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      this.uUs.start();
      AppMethodBeat.o(25954);
      return;
      if (com.tencent.mm.n.g.acA().getInt("WCOPurchaseSwitch", 0) == 1) {}
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
      if (com.tencent.mm.n.g.acA().getInt("WCOInviteFriend", 0) == 1) {}
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
      this.uUr.setText("0");
      paramBundle = getContext();
      getString(2131755906);
      this.uQp = h.b(paramBundle, getString(2131760457), true, new DialogInterface.OnCancelListener()
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
      this.uUm.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25956);
    super.onDestroy();
    ba.aiU().b(257, this);
    com.tencent.mm.sdk.b.a.IbL.d(this.uQg);
    this.uUs.uNG = bt.flT();
    this.uUs.finish();
    AppMethodBeat.o(25956);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25955);
    super.onResume();
    com.tencent.mm.plugin.ipcall.model.g.b.dei().nL(false);
    AppMethodBeat.o(25955);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25958);
    if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.g))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(((com.tencent.mm.plugin.ipcall.model.e.g)paramn).uNo);
        refreshView();
        if ((this.uQp != null) && (this.uQp.isShowing())) {
          this.uQp.dismiss();
        }
        AppMethodBeat.o(25958);
        return;
      }
      if ((this.uQp != null) && (this.uQp.isShowing()))
      {
        this.uQp.dismiss();
        h.d(getContext(), getString(2131760455), getString(2131760448), new DialogInterface.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponUI
 * JD-Core Version:    0.7.0.1
 */