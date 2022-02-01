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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.model.bc;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.ipcall.model.f.i;
import com.tencent.mm.protocal.protobuf.blu;
import com.tencent.mm.protocal.protobuf.ecc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private com.tencent.mm.sdk.b.c vbS;
  private ProgressDialog vcb;
  private RelativeLayout vfK;
  private TextView vfL;
  private ImageView vfM;
  private RelativeLayout vfN;
  private TextView vfO;
  private ImageView vfP;
  private LinearLayout vfQ;
  private LinearLayout vfR;
  private LinearLayout vfS;
  private LinearLayout vfT;
  private ImageView vfU;
  private LinearLayout vfV;
  private ImageView vfW;
  private TextView vfX;
  private TextView vfY;
  private TextView vfZ;
  private String vfq;
  private String vfr;
  private String vfs;
  private String vft;
  private String vfu;
  private String vfv;
  private String vfw;
  private ImageView vga;
  private TextView vgb;
  private TextView vgc;
  private View vgd;
  private IPCallDynamicTextView vge;
  private com.tencent.mm.plugin.ipcall.model.f.b vgf;
  private LinkedList<ecc> vgg;
  private boolean vgh;
  
  public IPCallShareCouponUI()
  {
    AppMethodBeat.i(25953);
    this.vgf = new com.tencent.mm.plugin.ipcall.model.f.b();
    this.vfq = null;
    this.mDesc = null;
    this.vfr = null;
    this.mTitle = null;
    this.mWording = null;
    this.vfs = null;
    this.vft = null;
    this.vfu = null;
    this.vfv = null;
    this.vfw = null;
    this.vgg = null;
    this.vbS = new com.tencent.mm.sdk.b.c() {};
    this.vgh = false;
    AppMethodBeat.o(25953);
  }
  
  private void a(blu paramblu)
  {
    this.vfq = paramblu.GYO;
    this.mDesc = paramblu.Desc;
    this.vfr = paramblu.GYP;
    this.mTitle = paramblu.Title;
    this.mWording = paramblu.urq;
    this.vfs = paramblu.GYQ;
    this.vfu = paramblu.GYR;
    this.vfv = paramblu.GYS;
    this.vfw = paramblu.GYT;
    this.vgg = paramblu.GYB;
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(25957);
    if (!bu.isNullOrNil(this.vfu))
    {
      if (this.vft == null)
      {
        this.vge.setValue(this.vfu, this.vfu);
        this.vft = this.vfu;
      }
    }
    else
    {
      this.vgb.getText();
      this.vgb.setText(this.vfv);
      if (!bu.isNullOrNil(this.vfv)) {
        break label188;
      }
      this.vgb.setVisibility(8);
    }
    StringBuffer localStringBuffer;
    for (;;)
    {
      localStringBuffer = new StringBuffer("");
      if ((this.vgg == null) || (this.vgg.size() <= 0)) {
        break label199;
      }
      Iterator localIterator = this.vgg.iterator();
      while (localIterator.hasNext())
      {
        ecc localecc = (ecc)localIterator.next();
        if ((localecc != null) && (!bu.isNullOrNil(localecc.HJs))) {
          localStringBuffer.append(localecc.HJs).append('\n');
        }
      }
      this.vge.setValue(this.vft, this.vfu);
      break;
      label188:
      this.vgb.setVisibility(0);
    }
    label199:
    if (!bu.isNullOrNil(localStringBuffer.toString()))
    {
      if (localStringBuffer.charAt(localStringBuffer.length() - 1) == '\n') {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      this.vgc.setText(localStringBuffer.toString());
      this.vgc.setVisibility(0);
    }
    while ((this.vgb.getVisibility() == 0) && (this.vgc.getVisibility() == 0))
    {
      this.vgd.setVisibility(0);
      AppMethodBeat.o(25957);
      return;
      this.vgc.setText("");
      this.vgc.setVisibility(8);
    }
    this.vgd.setVisibility(8);
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
    bc.ajj().a(257, this);
    com.tencent.mm.sdk.b.a.IvT.c(this.vbS);
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
        paramAnonymousMenuItem = com.tencent.mm.plugin.ipcall.a.c.dia();
        int i;
        if ((paramAnonymousMenuItem != null) && (!bu.isNullOrNil(paramAnonymousMenuItem.GYY))) {
          if (com.tencent.mm.n.g.acL().getInt("WCOWebPayListSwitch", 0) > 0)
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
            public final void lh(int paramAnonymous2Int)
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
    this.vge = ((IPCallDynamicTextView)findViewById(2131297085));
    this.vfK = ((RelativeLayout)findViewById(2131303817));
    this.vfL = ((TextView)findViewById(2131303836));
    this.vfM = ((ImageView)findViewById(2131303823));
    bc.aCg();
    if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.INl, Boolean.FALSE)).booleanValue()) {
      this.vfM.setVisibility(0);
    }
    bc.aCg();
    paramBundle = (String)com.tencent.mm.model.c.ajA().get(am.a.INk, "");
    this.vfL.setText(paramBundle);
    this.vfN = ((RelativeLayout)findViewById(2131303546));
    this.vfO = ((TextView)findViewById(2131303123));
    this.vfP = ((ImageView)findViewById(2131303120));
    bc.aCg();
    paramBundle = (String)com.tencent.mm.model.c.ajA().get(am.a.INm, "");
    this.vfO.setText(paramBundle);
    this.vgb = ((TextView)findViewById(2131298812));
    this.vgc = ((TextView)findViewById(2131303118));
    this.vgd = findViewById(2131304848);
    this.vfQ = ((LinearLayout)findViewById(2131299541));
    this.vga = ((ImageView)findViewById(2131302741));
    bc.aCg();
    if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.INn, Boolean.FALSE)).booleanValue()) {
      this.vga.setVisibility(0);
    }
    this.vfX = ((TextView)findViewById(2131302899));
    this.vfY = ((TextView)findViewById(2131296519));
    this.vfZ = ((TextView)findViewById(2131305240));
    this.vfR = ((LinearLayout)findViewById(2131304739));
    this.vfS = ((LinearLayout)findViewById(2131302648));
    this.vfV = ((LinearLayout)findViewById(2131304479));
    this.vfW = ((ImageView)findViewById(2131304480));
    this.vfT = ((LinearLayout)findViewById(2131302523));
    this.vfU = ((ImageView)findViewById(2131302524));
    bc.aCg();
    if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.INt, Boolean.FALSE)).booleanValue()) {
      this.vfU.setVisibility(0);
    }
    int i;
    label559:
    label587:
    label593:
    label614:
    Object localObject1;
    label779:
    Object localObject2;
    if (com.tencent.mm.plugin.ipcall.a.c.dhZ())
    {
      i = 1;
      if (i != 0) {
        this.vfK.setVisibility(8);
      }
      if ((com.tencent.mm.plugin.ipcall.a.c.dhZ()) || (com.tencent.mm.n.g.acL().getInt("WCOPackagePurchaseSwitch", 0) == 0)) {
        break label1059;
      }
      i = 1;
      if (i != 0) {
        this.vfN.setVisibility(0);
      }
      if (com.tencent.mm.n.g.acL().getInt("WCOAccountDetailSwitch", 0) != 1) {
        break label1064;
      }
      i = 1;
      if (i == 0) {
        break label1069;
      }
      i = 1;
      if (i != 0) {
        this.vfQ.setVisibility(8);
      }
      if (!com.tencent.mm.plugin.ipcall.a.c.dhZ()) {
        break label1074;
      }
      i = 1;
      if (i != 0) {
        this.vfR.setVisibility(8);
      }
      this.vfX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25946);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          IPCallShareCouponUI.d(IPCallShareCouponUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25946);
        }
      });
      this.vfY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25947);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          IPCallShareCouponUI.e(IPCallShareCouponUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25947);
        }
      });
      this.vfQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25948);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          IPCallShareCouponUI.f(IPCallShareCouponUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25948);
        }
      });
      this.vfR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25949);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          com.tencent.mm.plugin.report.service.g.yxI.f(13340, new Object[] { Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallShareCouponCardUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25949);
        }
      });
      this.vfT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25950);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          bc.aCg();
          if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.INt, Boolean.FALSE)).booleanValue())
          {
            bc.aCg();
            i.ah(4, -1, ((Integer)com.tencent.mm.model.c.ajA().get(am.a.INu, Integer.valueOf(-1))).intValue());
          }
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.INu, Integer.valueOf(-1));
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.INt, Boolean.FALSE);
          IPCallShareCouponUI.g(IPCallShareCouponUI.this).setVisibility(8);
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallMsgUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25950);
        }
      });
      this.vfS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25951);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallMyGiftCardUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25951);
        }
      });
      this.vfK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25952);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          bc.aCg();
          if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.INl, Boolean.FALSE)).booleanValue() == true) {
            i.ah(3, -1, -1);
          }
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(am.a.INl, Boolean.FALSE);
          IPCallShareCouponUI.a(IPCallShareCouponUI.this).setVisibility(8);
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallRechargeUI.class);
          paramAnonymousView = IPCallShareCouponUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25952);
        }
      });
      this.vfN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25937);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallPackageUI.class);
          paramAnonymousView = IPCallShareCouponUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25937);
        }
      });
      this.vfV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25938);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          Intent localIntent = new Intent();
          paramAnonymousView = IPCallShareCouponUI.this.getString(2131760480) + "&usedcc=";
          localObject = com.tencent.mm.plugin.ipcall.model.c.dgj().dgm();
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
              String str = com.tencent.mm.plugin.ipcall.a.a.apc(((Integer)((List)localObject).get(j)).toString());
              if (bu.isNullOrNil(str)) {
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
              for (localObject = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);; localObject = paramAnonymousView + com.tencent.mm.plugin.ipcall.a.a.apc(com.tencent.mm.plugin.ipcall.a.c.dhX()))
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
      paramBundle = com.tencent.mm.plugin.ipcall.a.c.dia();
      if (paramBundle == null) {
        break label1109;
      }
      a(paramBundle);
      refreshView();
      if (!com.tencent.mm.plugin.ipcall.a.c.dhZ()) {
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
          Object localObject = ad.iR(ak.getContext());
          if (!bu.isNullOrNil((String)localObject)) {
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
      this.vfZ.setText((CharSequence)localObject2);
      this.vfZ.setMovementMethod(LinkMovementMethod.getInstance());
      this.vfZ.setVisibility(0);
    }
    for (;;)
    {
      paramBundle = (LinearLayout)findViewById(2131301348);
      if ((paramBundle != null) && (this.vfK.getVisibility() == 8) && (this.vfN.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      paramBundle = (LinearLayout)findViewById(2131301350);
      if ((paramBundle != null) && (this.vfR.getVisibility() == 8) && (this.vfS.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      this.vgf.start();
      AppMethodBeat.o(25954);
      return;
      if (com.tencent.mm.n.g.acL().getInt("WCOPurchaseSwitch", 0) == 1) {}
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
      if (com.tencent.mm.n.g.acL().getInt("WCOInviteFriend", 0) == 1) {}
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
      this.vge.setText("0");
      paramBundle = getContext();
      getString(2131755906);
      this.vcb = h.b(paramBundle, getString(2131760457), true, new DialogInterface.OnCancelListener()
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
            ae.e("MicroMsg.IPCallShareCouponUI", "IPCallShareCouponUI error: %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
            AppMethodBeat.o(25939);
          }
        }
      });
      break label779;
      label1159:
      ((Spannable)localObject2).setSpan(localObject1, 0, ((Spannable)localObject2).length(), 33);
      break label893;
      label1181:
      this.vfZ.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25956);
    super.onDestroy();
    bc.ajj().b(257, this);
    com.tencent.mm.sdk.b.a.IvT.d(this.vbS);
    this.vgf.uZt = bu.fpO();
    this.vgf.finish();
    AppMethodBeat.o(25956);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25955);
    super.onResume();
    com.tencent.mm.plugin.ipcall.model.g.b.dha().nP(false);
    AppMethodBeat.o(25955);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25958);
    if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.g))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(((com.tencent.mm.plugin.ipcall.model.e.g)paramn).uZb);
        refreshView();
        if ((this.vcb != null) && (this.vcb.isShowing())) {
          this.vcb.dismiss();
        }
        AppMethodBeat.o(25958);
        return;
      }
      if ((this.vcb != null) && (this.vcb.isShowing()))
      {
        this.vcb.dismiss();
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