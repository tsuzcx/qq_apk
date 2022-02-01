package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.f.d;
import com.tencent.mm.plugin.ipcall.model.h.f;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.ewh;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g
  extends i
{
  private CharSequence Hn;
  View jBN;
  private ScrollView lTw;
  private Activity mActivity;
  private Context mContext;
  private MMHandler mHandler;
  private ArrayList<a> mItemList;
  private View.OnClickListener mOnClickListener;
  private int thx;
  private int thy;
  private int yvJ;
  private int yvK;
  private long yvL;
  private LinearLayout yvM;
  private LinearLayout yvN;
  private RelativeLayout yvO;
  private RelativeLayout yvP;
  private RelativeLayout yvQ;
  private ImageView yvR;
  private ImageView yvS;
  private ImageView yvT;
  private int yvU;
  private FrameLayout yvV;
  private FlowLayout yvW;
  private Button yvX;
  private Button yvY;
  private PasterEditText yvZ;
  private Button ywa;
  private Button ywb;
  private TextView ywc;
  private Animation ywd;
  private int ywe;
  private int ywf;
  
  public g(Activity paramActivity, Context paramContext, int paramInt, long paramLong)
  {
    super(paramContext, 2131821772);
    AppMethodBeat.i(25778);
    this.yvJ = 0;
    this.mHandler = new MMHandler();
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25771);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (paramAnonymousView == g.b(g.this)) {
          g.a(g.this, 1);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25771);
          return;
          if (paramAnonymousView == g.c(g.this)) {
            g.a(g.this, 2);
          } else if (paramAnonymousView == g.d(g.this)) {
            g.a(g.this, 3);
          }
        }
      }
    };
    this.thy = 2131232434;
    this.thx = 2131100402;
    this.ywe = 2131232431;
    this.ywf = 2131101427;
    setCancelable(false);
    this.mContext = paramContext;
    this.yvK = paramInt;
    this.yvL = paramLong;
    this.mActivity = paramActivity;
    this.jBN = View.inflate(this.mContext, 2131495106, null);
    this.yvM = ((LinearLayout)this.jBN.findViewById(2131303067));
    this.yvN = ((LinearLayout)this.jBN.findViewById(2131303068));
    this.ywd = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), 2130771981);
    this.ywd.setDuration(200L);
    this.ywd.setStartOffset(100L);
    this.yvV = ((FrameLayout)this.jBN.findViewById(2131301592));
    this.yvW = ((FlowLayout)this.jBN.findViewById(2131301591));
    this.yvX = ((Button)this.jBN.findViewById(2131298994));
    this.yvY = ((Button)this.jBN.findViewById(2131298995));
    this.yvZ = ((PasterEditText)this.jBN.findViewById(2131299004));
    this.yvX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25772);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        g.this.dismiss();
        d.a(-1, 1, -1, "", 0, -1, -1, g.e(g.this), g.f(g.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25772);
      }
    });
    this.yvY.setOnClickListener(new g.5(this));
    Object localObject1 = com.tencent.mm.plugin.ipcall.model.e.eak();
    if (((com.tencent.mm.plugin.ipcall.model.e)localObject1).yoE == null)
    {
      Log.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
      com.tencent.mm.pluginsdk.j.a.a.b.gnC();
      paramActivity = com.tencent.mm.pluginsdk.j.a.a.b.kC(39, 1);
      if (Util.isNullOrNil(paramActivity)) {
        break label555;
      }
      paramActivity = s.aW(paramActivity, 0, -1);
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.ipcall.model.e)localObject1).bG(paramActivity);
      }
    }
    else
    {
      if (((com.tencent.mm.plugin.ipcall.model.e)localObject1).yoE == null) {
        break label596;
      }
      paramActivity = LocaleUtil.loadApplicationLanguageSettings(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
      if ((!"language_default".equalsIgnoreCase(paramActivity)) || (Locale.getDefault() == null)) {
        break label1124;
      }
      paramActivity = Locale.getDefault().toString();
    }
    label457:
    label596:
    label1124:
    for (;;)
    {
      Object localObject2 = ((com.tencent.mm.plugin.ipcall.model.e)localObject1).yoE.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramContext = (f)((Iterator)localObject2).next();
        if (paramActivity.equalsIgnoreCase(paramContext.ysG))
        {
          Log.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.model.e)localObject1).yoE.size()) });
          paramActivity = paramContext;
        }
      }
      for (;;)
      {
        if (paramActivity != null)
        {
          paramContext = paramActivity.ysH;
          paramActivity = new ArrayList();
          paramContext = paramContext.iterator();
          for (;;)
          {
            if (paramContext.hasNext())
            {
              localObject1 = (com.tencent.mm.plugin.ipcall.model.h.e)paramContext.next();
              localObject2 = new a();
              ((a)localObject2).Id = ((com.tencent.mm.plugin.ipcall.model.h.e)localObject1).Id;
              ((a)localObject2).xJH = ((com.tencent.mm.plugin.ipcall.model.h.e)localObject1).xJH;
              ((a)localObject2).ywh = false;
              paramActivity.add(localObject2);
              continue;
              Log.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
              break;
              Log.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
              break;
              Log.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.model.e)localObject1).yoE.size()) });
              paramActivity = null;
              break label457;
            }
          }
          this.mItemList = paramActivity;
          paramActivity = this.mItemList.iterator();
          while (paramActivity.hasNext())
          {
            paramContext = (a)paramActivity.next();
            localObject1 = this.yvW;
            localObject2 = new TextView(getContext());
            ((TextView)localObject2).setTextSize(0, getContext().getResources().getDimension(2131166342) * com.tencent.mm.cb.a.ez(getContext()));
            ((TextView)localObject2).setBackgroundResource(this.thy);
            ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(this.thx));
            ((TextView)localObject2).setTag(paramContext);
            ((TextView)localObject2).setGravity(17);
            ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView)localObject2).setSingleLine();
            ((TextView)localObject2).setText(paramContext.xJH);
            ((TextView)localObject2).setOnClickListener(new g.6(this));
            ((FlowLayout)localObject1).addView((View)localObject2);
          }
        }
      }
      this.yvO = ((RelativeLayout)this.jBN.findViewById(2131303072));
      this.yvP = ((RelativeLayout)this.jBN.findViewById(2131303073));
      this.yvQ = ((RelativeLayout)this.jBN.findViewById(2131303074));
      this.yvO.setOnClickListener(this.mOnClickListener);
      this.yvP.setOnClickListener(this.mOnClickListener);
      this.yvQ.setOnClickListener(this.mOnClickListener);
      this.yvR = ((ImageView)this.jBN.findViewById(2131302618));
      this.yvS = ((ImageView)this.jBN.findViewById(2131302619));
      this.yvT = ((ImageView)this.jBN.findViewById(2131302620));
      this.yvU = 0;
      Pi(this.yvU);
      this.ywa = ((Button)this.jBN.findViewById(2131302703));
      this.ywb = ((Button)this.jBN.findViewById(2131302704));
      this.ywc = ((TextView)this.jBN.findViewById(2131302706));
      paramActivity = c.ebR();
      if (paramActivity != null) {}
      for (paramActivity = String.format(this.mContext.getString(2131761997), new Object[] { paramActivity.MdN });; paramActivity = null)
      {
        if (Util.isNullOrNil(paramActivity)) {
          this.ywc.setVisibility(4);
        }
        for (;;)
        {
          this.ywa.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25775);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              g.this.dismiss();
              d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, -1, 1, g.e(g.this), g.f(g.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25775);
            }
          });
          this.ywb.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25776);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
              g.this.dismiss();
              localObject = new Intent();
              ((Intent)localObject).putExtra("IPCallShareCouponCardUI_KFrom", 2);
              ((Intent)localObject).setClass(g.i(g.this), IPCallShareCouponCardUI.class);
              paramAnonymousView = g.i(g.this);
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, 1, -1, g.e(g.this), g.f(g.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25776);
            }
          });
          this.lTw = ((ScrollView)this.jBN.findViewById(2131300590));
          paramActivity = ((ViewGroup)this.mActivity.findViewById(16908290)).getChildAt(0);
          paramActivity.getViewTreeObserver().addOnGlobalLayoutListener(new g.1(this, paramActivity));
          AppMethodBeat.o(25778);
          return;
          this.ywc.setVisibility(0);
          this.ywc.setText(paramActivity);
        }
      }
    }
  }
  
  private void Pi(int paramInt)
  {
    AppMethodBeat.i(25780);
    this.yvU = paramInt;
    if (paramInt == 0)
    {
      this.yvR.setVisibility(4);
      this.yvS.setVisibility(4);
      this.yvT.setVisibility(4);
      this.yvY.setEnabled(false);
      Pl(0);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 1)
    {
      this.yvR.setVisibility(0);
      this.yvS.setVisibility(4);
      this.yvT.setVisibility(4);
      this.yvY.setEnabled(true);
      Pl(1);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 2)
    {
      this.yvR.setVisibility(0);
      this.yvS.setVisibility(0);
      this.yvT.setVisibility(4);
      this.yvY.setEnabled(true);
      Pl(1);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 3)
    {
      this.yvR.setVisibility(0);
      this.yvS.setVisibility(0);
      this.yvT.setVisibility(0);
      this.yvY.setEnabled(true);
      Pl(0);
    }
    AppMethodBeat.o(25780);
  }
  
  private String Pj(int paramInt)
  {
    AppMethodBeat.i(25781);
    String str = "";
    if (paramInt == 3)
    {
      AppMethodBeat.o(25781);
      return "";
    }
    if (!Util.isNullOrNil(this.yvZ.getText().toString().trim())) {
      str = "0";
    }
    Object localObject;
    if (this.mItemList != null)
    {
      Iterator localIterator = this.mItemList.iterator();
      for (;;)
      {
        localObject = str;
        if (!localIterator.hasNext()) {
          break label145;
        }
        localObject = (a)localIterator.next();
        if (!((a)localObject).ywh) {
          break label153;
        }
        if (!str.equals("")) {
          break;
        }
        str = ((a)localObject).Id;
      }
      str = str + "_" + ((a)localObject).Id;
    }
    label145:
    label153:
    for (;;)
    {
      break;
      localObject = str;
      AppMethodBeat.o(25781);
      return localObject;
    }
  }
  
  private LinkedList<ewh> Pk(int paramInt)
  {
    AppMethodBeat.i(25782);
    LinkedList localLinkedList = new LinkedList();
    if (paramInt == 3)
    {
      AppMethodBeat.o(25782);
      return localLinkedList;
    }
    Object localObject1 = this.yvZ.getText().toString().trim();
    Object localObject2;
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject2 = new ewh();
      ((ewh)localObject2).ID = 0;
      ((ewh)localObject2).iAc = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (this.mItemList != null)
    {
      localObject1 = this.mItemList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        if (((a)localObject2).ywh)
        {
          ewh localewh = new ewh();
          try
          {
            localewh.ID = Util.getInt(((a)localObject2).Id, 0);
            localLinkedList.add(localewh);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            Log.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + ((a)localObject2).Id);
          }
        }
      }
    }
    AppMethodBeat.o(25782);
    return localLinkedList;
  }
  
  private void Pl(int paramInt)
  {
    AppMethodBeat.i(25785);
    if (paramInt == 0)
    {
      this.yvM.setVisibility(0);
      this.yvN.setVisibility(4);
      if (this.yvJ == 1)
      {
        ((LinearLayout.LayoutParams)this.yvV.getLayoutParams()).height = 0;
        this.yvV.requestLayout();
      }
      Util.hideVKB(this.jBN);
    }
    for (;;)
    {
      this.yvJ = paramInt;
      AppMethodBeat.o(25785);
      return;
      if (paramInt == 1)
      {
        this.yvM.setVisibility(0);
        this.yvN.setVisibility(4);
        if (this.yvJ == 0)
        {
          ((LinearLayout.LayoutParams)this.yvV.getLayoutParams()).height = -2;
          this.yvV.requestLayout();
          this.yvV.startAnimation(this.ywd);
        }
      }
      else if (paramInt == 2)
      {
        this.yvM.setVisibility(4);
        this.yvN.setVisibility(0);
        Util.hideVKB(this.jBN);
      }
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(25784);
    try
    {
      super.dismiss();
      AppMethodBeat.o(25784);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(25784);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25779);
    super.onCreate(paramBundle);
    setContentView(this.jBN);
    getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    Pl(0);
    AppMethodBeat.o(25779);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Hn = paramCharSequence;
      return;
    }
    this.Hn = null;
  }
  
  public final void show()
  {
    AppMethodBeat.i(25783);
    super.show();
    AppMethodBeat.o(25783);
  }
  
  public static final class a
  {
    public String Id;
    public String xJH;
    public boolean ywh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g
 * JD-Core Version:    0.7.0.1
 */