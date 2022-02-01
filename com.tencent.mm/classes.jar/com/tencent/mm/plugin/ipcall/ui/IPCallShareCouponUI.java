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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.model.bg;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.ewj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallShareCouponUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private String mDesc;
  private String mTitle;
  private String mWording;
  private ProgressDialog yuB;
  private IListener yus;
  private String yxP;
  private String yxQ;
  private String yxR;
  private String yxS;
  private String yxT;
  private String yxU;
  private String yxV;
  private TextView yyA;
  private TextView yyB;
  private View yyC;
  private IPCallDynamicTextView yyD;
  private com.tencent.mm.plugin.ipcall.model.f.b yyE;
  private LinkedList<ewj> yyF;
  private boolean yyG;
  private RelativeLayout yyj;
  private TextView yyk;
  private ImageView yyl;
  private RelativeLayout yym;
  private TextView yyn;
  private ImageView yyo;
  private LinearLayout yyp;
  private LinearLayout yyq;
  private LinearLayout yyr;
  private LinearLayout yys;
  private ImageView yyt;
  private LinearLayout yyu;
  private ImageView yyv;
  private TextView yyw;
  private TextView yyx;
  private TextView yyy;
  private ImageView yyz;
  
  public IPCallShareCouponUI()
  {
    AppMethodBeat.i(25953);
    this.yyE = new com.tencent.mm.plugin.ipcall.model.f.b();
    this.yxP = null;
    this.mDesc = null;
    this.yxQ = null;
    this.mTitle = null;
    this.mWording = null;
    this.yxR = null;
    this.yxS = null;
    this.yxT = null;
    this.yxU = null;
    this.yxV = null;
    this.yyF = null;
    this.yus = new IListener() {};
    this.yyG = false;
    AppMethodBeat.o(25953);
  }
  
  private void a(byf parambyf)
  {
    this.yxP = parambyf.MdG;
    this.mDesc = parambyf.Desc;
    this.yxQ = parambyf.MdH;
    this.mTitle = parambyf.Title;
    this.mWording = parambyf.xJH;
    this.yxR = parambyf.MdI;
    this.yxT = parambyf.MdJ;
    this.yxU = parambyf.MdK;
    this.yxV = parambyf.MdL;
    this.yyF = parambyf.Mdr;
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(25957);
    if (!Util.isNullOrNil(this.yxT))
    {
      if (this.yxS == null)
      {
        this.yyD.setValue(this.yxT, this.yxT);
        this.yxS = this.yxT;
      }
    }
    else
    {
      this.yyA.getText();
      this.yyA.setText(this.yxU);
      if (!Util.isNullOrNil(this.yxU)) {
        break label188;
      }
      this.yyA.setVisibility(8);
    }
    StringBuffer localStringBuffer;
    for (;;)
    {
      localStringBuffer = new StringBuffer("");
      if ((this.yyF == null) || (this.yyF.size() <= 0)) {
        break label199;
      }
      Iterator localIterator = this.yyF.iterator();
      while (localIterator.hasNext())
      {
        ewj localewj = (ewj)localIterator.next();
        if ((localewj != null) && (!Util.isNullOrNil(localewj.MVg))) {
          localStringBuffer.append(localewj.MVg).append('\n');
        }
      }
      this.yyD.setValue(this.yxS, this.yxT);
      break;
      label188:
      this.yyA.setVisibility(0);
    }
    label199:
    if (!Util.isNullOrNil(localStringBuffer.toString()))
    {
      if (localStringBuffer.charAt(localStringBuffer.length() - 1) == '\n') {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      this.yyB.setText(localStringBuffer.toString());
      this.yyB.setVisibility(0);
    }
    while ((this.yyA.getVisibility() == 0) && (this.yyB.getVisibility() == 0))
    {
      this.yyC.setVisibility(0);
      AppMethodBeat.o(25957);
      return;
      this.yyB.setText("");
      this.yyB.setVisibility(8);
    }
    this.yyC.setVisibility(8);
    AppMethodBeat.o(25957);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495097;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25954);
    super.onCreate(paramBundle);
    bg.azz().a(257, this);
    EventCenter.instance.addListener(this.yus);
    setMMTitle(2131761953);
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
    addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25943);
        paramAnonymousMenuItem = com.tencent.mm.plugin.ipcall.a.c.ebR();
        int i;
        if ((paramAnonymousMenuItem != null) && (!Util.isNullOrNil(paramAnonymousMenuItem.MdQ))) {
          if (com.tencent.mm.n.h.aqJ().getInt("WCOWebPayListSwitch", 0) > 0)
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
            paramAnonymousMenuItem[0] = IPCallShareCouponUI.this.getString(2131761952);
            paramAnonymousMenuItem[1] = IPCallShareCouponUI.this.getString(2131761895);
            paramAnonymousMenuItem[2] = IPCallShareCouponUI.this.getString(2131761874);
            IPCallShareCouponUI.a(IPCallShareCouponUI.this, true);
          }
        }
        for (;;)
        {
          com.tencent.mm.ui.base.h.b(IPCallShareCouponUI.this.getContext(), null, paramAnonymousMenuItem, null, new h.d()
          {
            public final void oj(int paramAnonymous2Int)
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
          paramAnonymousMenuItem[0] = IPCallShareCouponUI.this.getString(2131761895);
          paramAnonymousMenuItem[1] = IPCallShareCouponUI.this.getString(2131761874);
          IPCallShareCouponUI.a(IPCallShareCouponUI.this, false);
        }
      }
    });
    this.yyD = ((IPCallDynamicTextView)findViewById(2131297230));
    this.yyj = ((RelativeLayout)findViewById(2131306620));
    this.yyk = ((TextView)findViewById(2131306643));
    this.yyl = ((ImageView)findViewById(2131306630));
    bg.aVF();
    if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NVo, Boolean.FALSE)).booleanValue()) {
      this.yyl.setVisibility(0);
    }
    bg.aVF();
    paramBundle = (String)com.tencent.mm.model.c.azQ().get(ar.a.NVn, "");
    this.yyk.setText(paramBundle);
    this.yym = ((RelativeLayout)findViewById(2131306321));
    this.yyn = ((TextView)findViewById(2131305760));
    this.yyo = ((ImageView)findViewById(2131305757));
    bg.aVF();
    paramBundle = (String)com.tencent.mm.model.c.azQ().get(ar.a.NVp, "");
    this.yyn.setText(paramBundle);
    this.yyA = ((TextView)findViewById(2131299276));
    this.yyB = ((TextView)findViewById(2131305755));
    this.yyC = findViewById(2131307934);
    this.yyp = ((LinearLayout)findViewById(2131300189));
    this.yyz = ((ImageView)findViewById(2131305309));
    bg.aVF();
    if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NVq, Boolean.FALSE)).booleanValue()) {
      this.yyz.setVisibility(0);
    }
    this.yyw = ((TextView)findViewById(2131305481));
    this.yyx = ((TextView)findViewById(2131296593));
    this.yyy = ((TextView)findViewById(2131308444));
    this.yyq = ((LinearLayout)findViewById(2131307801));
    this.yyr = ((LinearLayout)findViewById(2131305199));
    this.yyu = ((LinearLayout)findViewById(2131307475));
    this.yyv = ((ImageView)findViewById(2131307476));
    this.yys = ((LinearLayout)findViewById(2131304952));
    this.yyt = ((ImageView)findViewById(2131304953));
    bg.aVF();
    if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NVw, Boolean.FALSE)).booleanValue()) {
      this.yyt.setVisibility(0);
    }
    int i;
    label559:
    label587:
    label593:
    label614:
    Object localObject1;
    label779:
    Object localObject2;
    if (com.tencent.mm.plugin.ipcall.a.c.ebQ())
    {
      i = 1;
      if (i != 0) {
        this.yyj.setVisibility(8);
      }
      if ((com.tencent.mm.plugin.ipcall.a.c.ebQ()) || (com.tencent.mm.n.h.aqJ().getInt("WCOPackagePurchaseSwitch", 0) == 0)) {
        break label1059;
      }
      i = 1;
      if (i != 0) {
        this.yym.setVisibility(0);
      }
      if (com.tencent.mm.n.h.aqJ().getInt("WCOAccountDetailSwitch", 0) != 1) {
        break label1064;
      }
      i = 1;
      if (i == 0) {
        break label1069;
      }
      i = 1;
      if (i != 0) {
        this.yyp.setVisibility(8);
      }
      if (!com.tencent.mm.plugin.ipcall.a.c.ebQ()) {
        break label1074;
      }
      i = 1;
      if (i != 0) {
        this.yyq.setVisibility(8);
      }
      this.yyw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25946);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          IPCallShareCouponUI.d(IPCallShareCouponUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25946);
        }
      });
      this.yyx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25947);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          IPCallShareCouponUI.e(IPCallShareCouponUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25947);
        }
      });
      this.yyp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25948);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          IPCallShareCouponUI.f(IPCallShareCouponUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25948);
        }
      });
      this.yyq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25949);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          com.tencent.mm.plugin.report.service.h.CyF.a(13340, new Object[] { Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallShareCouponCardUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25949);
        }
      });
      this.yys.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25950);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          bg.aVF();
          if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NVw, Boolean.FALSE)).booleanValue())
          {
            bg.aVF();
            com.tencent.mm.plugin.ipcall.model.f.i.am(4, -1, ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.NVx, Integer.valueOf(-1))).intValue());
          }
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.NVx, Integer.valueOf(-1));
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.NVw, Boolean.FALSE);
          IPCallShareCouponUI.g(IPCallShareCouponUI.this).setVisibility(8);
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallMsgUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25950);
        }
      });
      this.yyr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25951);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallMyGiftCardUI.class);
          paramAnonymousView = IPCallShareCouponUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25951);
        }
      });
      this.yyj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25952);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          bg.aVF();
          if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NVo, Boolean.FALSE)).booleanValue() == true) {
            com.tencent.mm.plugin.ipcall.model.f.i.am(3, -1, -1);
          }
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.NVo, Boolean.FALSE);
          IPCallShareCouponUI.a(IPCallShareCouponUI.this).setVisibility(8);
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallRechargeUI.class);
          paramAnonymousView = IPCallShareCouponUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25952);
        }
      });
      this.yym.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25937);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = new Intent();
          ((Intent)localObject).setClass(IPCallShareCouponUI.this.getContext(), IPCallPackageUI.class);
          paramAnonymousView = IPCallShareCouponUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25937);
        }
      });
      this.yyu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25938);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          Intent localIntent = new Intent();
          paramAnonymousView = IPCallShareCouponUI.this.getString(2131761925) + "&usedcc=";
          localObject = com.tencent.mm.plugin.ipcall.model.c.ead().eag();
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
              String str = com.tencent.mm.plugin.ipcall.a.a.aCw(((Integer)((List)localObject).get(j)).toString());
              if (Util.isNullOrNil(str)) {
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
              for (localObject = paramAnonymousView.substring(0, paramAnonymousView.length() - 1);; localObject = paramAnonymousView + com.tencent.mm.plugin.ipcall.a.a.aCw(com.tencent.mm.plugin.ipcall.a.c.ebO()))
              {
                localIntent.putExtra("rawUrl", (String)localObject);
                localIntent.putExtra("showShare", false);
                com.tencent.mm.br.c.b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25938);
                return;
              }
            }
          }
        }
      });
      paramBundle = com.tencent.mm.plugin.ipcall.a.c.ebR();
      if (paramBundle == null) {
        break label1109;
      }
      a(paramBundle);
      refreshView();
      if (!com.tencent.mm.plugin.ipcall.a.c.ebQ()) {
        break label1181;
      }
      paramBundle = getString(2131762009);
      localObject1 = getString(2131762008);
      localObject2 = paramBundle + (String)localObject1;
      localObject1 = new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25940);
          ((TextView)paramAnonymousView).setHighlightColor(IPCallShareCouponUI.this.getResources().getColor(2131101287));
          Object localObject = "https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?t=weixin_phone/notice";
          String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
          paramAnonymousView = (View)localObject;
          if (!Util.isNullOrNil(str)) {
            paramAnonymousView = (String)localObject + "&wechat_real_lang=" + str;
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
          ((Intent)localObject).putExtra("showShare", false);
          com.tencent.mm.br.c.b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
          AppMethodBeat.o(25940);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(25941);
          paramAnonymousTextPaint.setColor(IPCallShareCouponUI.this.getResources().getColor(2131100685));
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
      this.yyy.setText((CharSequence)localObject2);
      this.yyy.setMovementMethod(LinkMovementMethod.getInstance());
      this.yyy.setVisibility(0);
    }
    for (;;)
    {
      paramBundle = (LinearLayout)findViewById(2131303069);
      if ((paramBundle != null) && (this.yyj.getVisibility() == 8) && (this.yym.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      paramBundle = (LinearLayout)findViewById(2131303071);
      if ((paramBundle != null) && (this.yyq.getVisibility() == 8) && (this.yyr.getVisibility() == 8)) {
        paramBundle.setVisibility(8);
      }
      this.yyE.start();
      AppMethodBeat.o(25954);
      return;
      if (com.tencent.mm.n.h.aqJ().getInt("WCOPurchaseSwitch", 0) == 1) {}
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
      if (com.tencent.mm.n.h.aqJ().getInt("WCOInviteFriend", 0) == 1) {}
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
      this.yyD.setText("0");
      paramBundle = getContext();
      getString(2131755998);
      this.yuB = com.tencent.mm.ui.base.h.a(paramBundle, getString(2131761902), true, new DialogInterface.OnCancelListener()
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
            Log.e("MicroMsg.IPCallShareCouponUI", "IPCallShareCouponUI error: %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
            AppMethodBeat.o(25939);
          }
        }
      });
      break label779;
      label1159:
      ((Spannable)localObject2).setSpan(localObject1, 0, ((Spannable)localObject2).length(), 33);
      break label893;
      label1181:
      this.yyy.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25956);
    super.onDestroy();
    bg.azz().b(257, this);
    EventCenter.instance.removeListener(this.yus);
    this.yyE.yrT = Util.nowMilliSecond();
    this.yyE.finish();
    AppMethodBeat.o(25956);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25955);
    super.onResume();
    com.tencent.mm.plugin.ipcall.model.g.b.eaU().qy(false);
    AppMethodBeat.o(25955);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(25958);
    if ((paramq instanceof g))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(((g)paramq).yrB);
        refreshView();
        if ((this.yuB != null) && (this.yuB.isShowing())) {
          this.yuB.dismiss();
        }
        AppMethodBeat.o(25958);
        return;
      }
      if ((this.yuB != null) && (this.yuB.isShowing()))
      {
        this.yuB.dismiss();
        com.tencent.mm.ui.base.h.d(getContext(), getString(2131761900), getString(2131761893), new DialogInterface.OnClickListener()
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