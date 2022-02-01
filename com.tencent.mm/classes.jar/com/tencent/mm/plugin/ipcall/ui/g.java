package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
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
import com.tencent.mm.pluginsdk.h.a.a.b;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g
  extends com.tencent.mm.ui.base.i
{
  private CharSequence Eo;
  View hIZ;
  private ScrollView jPx;
  private Activity mActivity;
  private Context mContext;
  private ap mHandler;
  private ArrayList<a> mItemList;
  private View.OnClickListener mOnClickListener;
  private int qhe;
  private int qhf;
  private int sHd;
  private int sHe;
  private long sHf;
  private LinearLayout sHg;
  private LinearLayout sHh;
  private RelativeLayout sHi;
  private RelativeLayout sHj;
  private RelativeLayout sHk;
  private ImageView sHl;
  private ImageView sHm;
  private ImageView sHn;
  private int sHo;
  private FrameLayout sHp;
  private FlowLayout sHq;
  private Button sHr;
  private Button sHs;
  private PasterEditText sHt;
  private Button sHu;
  private Button sHv;
  private TextView sHw;
  private Animation sHx;
  private int sHy;
  private int sHz;
  
  public g(final Activity paramActivity, Context paramContext, int paramInt, long paramLong)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(25778);
    this.sHd = 0;
    this.mHandler = new ap();
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25771);
        if (paramAnonymousView == g.b(g.this))
        {
          g.a(g.this, 1);
          AppMethodBeat.o(25771);
          return;
        }
        if (paramAnonymousView == g.c(g.this))
        {
          g.a(g.this, 2);
          AppMethodBeat.o(25771);
          return;
        }
        if (paramAnonymousView == g.d(g.this)) {
          g.a(g.this, 3);
        }
        AppMethodBeat.o(25771);
      }
    };
    this.qhf = 2131232305;
    this.qhe = 2131100367;
    this.sHy = 2131232302;
    this.sHz = 2131101182;
    setCancelable(false);
    this.mContext = paramContext;
    this.sHe = paramInt;
    this.sHf = paramLong;
    this.mActivity = paramActivity;
    this.hIZ = View.inflate(this.mContext, 2131494514, null);
    this.sHg = ((LinearLayout)this.hIZ.findViewById(2131301346));
    this.sHh = ((LinearLayout)this.hIZ.findViewById(2131301347));
    this.sHx = AnimationUtils.loadAnimation(aj.getContext(), 2130771981);
    this.sHx.setDuration(200L);
    this.sHx.setStartOffset(100L);
    this.sHp = ((FrameLayout)this.hIZ.findViewById(2131300141));
    this.sHq = ((FlowLayout)this.hIZ.findViewById(2131300140));
    this.sHr = ((Button)this.hIZ.findViewById(2131298559));
    this.sHs = ((Button)this.hIZ.findViewById(2131298560));
    this.sHt = ((PasterEditText)this.hIZ.findViewById(2131298569));
    this.sHr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25772);
        g.this.dismiss();
        d.a(-1, 1, -1, "", 0, -1, -1, g.e(g.this), g.f(g.this));
        AppMethodBeat.o(25772);
      }
    });
    this.sHs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25773);
        g.g(g.this);
        AppMethodBeat.o(25773);
      }
    });
    Object localObject1 = com.tencent.mm.plugin.ipcall.model.e.cHc();
    if (((com.tencent.mm.plugin.ipcall.model.e)localObject1).szT == null)
    {
      ad.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
      b.ewn();
      paramActivity = b.iN(39, 1);
      if (bt.isNullOrNil(paramActivity)) {
        break label558;
      }
      paramActivity = com.tencent.mm.vfs.i.aR(paramActivity, 0, -1);
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.ipcall.model.e)localObject1).bo(paramActivity);
      }
    }
    else
    {
      if (((com.tencent.mm.plugin.ipcall.model.e)localObject1).szT == null) {
        break label599;
      }
      paramActivity = aj.getContext().getSharedPreferences(aj.eFD(), 0);
      aj.getContext();
      paramActivity = ac.g(paramActivity);
      if ((!"language_default".equalsIgnoreCase(paramActivity)) || (Locale.getDefault() == null)) {
        break label1127;
      }
      paramActivity = Locale.getDefault().toString();
    }
    label460:
    label599:
    label1127:
    for (;;)
    {
      Object localObject2 = ((com.tencent.mm.plugin.ipcall.model.e)localObject1).szT.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramContext = (f)((Iterator)localObject2).next();
        if (paramActivity.equalsIgnoreCase(paramContext.sEa))
        {
          ad.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.model.e)localObject1).szT.size()) });
          paramActivity = paramContext;
        }
      }
      for (;;)
      {
        if (paramActivity != null)
        {
          paramContext = paramActivity.sEb;
          paramActivity = new ArrayList();
          paramContext = paramContext.iterator();
          for (;;)
          {
            if (paramContext.hasNext())
            {
              localObject1 = (com.tencent.mm.plugin.ipcall.model.h.e)paramContext.next();
              localObject2 = new a();
              ((a)localObject2).Id = ((com.tencent.mm.plugin.ipcall.model.h.e)localObject1).Id;
              ((a)localObject2).sDZ = ((com.tencent.mm.plugin.ipcall.model.h.e)localObject1).sDZ;
              ((a)localObject2).sHB = false;
              paramActivity.add(localObject2);
              continue;
              ad.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
              break;
              ad.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
              break;
              ad.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.model.e)localObject1).szT.size()) });
              paramActivity = null;
              break label460;
            }
          }
          this.mItemList = paramActivity;
          paramActivity = this.mItemList.iterator();
          while (paramActivity.hasNext())
          {
            paramContext = (a)paramActivity.next();
            localObject1 = this.sHq;
            localObject2 = new TextView(getContext());
            ((TextView)localObject2).setTextSize(0, getContext().getResources().getDimension(2131166295) * com.tencent.mm.cd.a.dT(getContext()));
            ((TextView)localObject2).setBackgroundResource(this.qhf);
            ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(this.qhe));
            ((TextView)localObject2).setTag(paramContext);
            ((TextView)localObject2).setGravity(17);
            ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView)localObject2).setSingleLine();
            ((TextView)localObject2).setText(paramContext.sDZ);
            ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(25774);
                g.a locala = (g.a)paramAnonymousView.getTag();
                if (!locala.sHB) {}
                for (locala.sHB = true;; locala.sHB = false)
                {
                  g.a(g.this, (TextView)paramAnonymousView);
                  AppMethodBeat.o(25774);
                  return;
                }
              }
            });
            ((FlowLayout)localObject1).addView((View)localObject2);
          }
        }
      }
      this.sHi = ((RelativeLayout)this.hIZ.findViewById(2131301351));
      this.sHj = ((RelativeLayout)this.hIZ.findViewById(2131301352));
      this.sHk = ((RelativeLayout)this.hIZ.findViewById(2131301353));
      this.sHi.setOnClickListener(this.mOnClickListener);
      this.sHj.setOnClickListener(this.mOnClickListener);
      this.sHk.setOnClickListener(this.mOnClickListener);
      this.sHl = ((ImageView)this.hIZ.findViewById(2131300980));
      this.sHm = ((ImageView)this.hIZ.findViewById(2131300981));
      this.sHn = ((ImageView)this.hIZ.findViewById(2131300982));
      this.sHo = 0;
      Fq(this.sHo);
      this.sHu = ((Button)this.hIZ.findViewById(2131301049));
      this.sHv = ((Button)this.hIZ.findViewById(2131301050));
      this.sHw = ((TextView)this.hIZ.findViewById(2131301052));
      paramActivity = c.cIM();
      if (paramActivity != null) {}
      for (paramActivity = String.format(this.mContext.getString(2131760552), new Object[] { paramActivity.DAA });; paramActivity = null)
      {
        if (bt.isNullOrNil(paramActivity)) {
          this.sHw.setVisibility(4);
        }
        for (;;)
        {
          this.sHu.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25775);
              g.this.dismiss();
              d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, -1, 1, g.e(g.this), g.f(g.this));
              AppMethodBeat.o(25775);
            }
          });
          this.sHv.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25776);
              g.this.dismiss();
              Object localObject = new Intent();
              ((Intent)localObject).putExtra("IPCallShareCouponCardUI_KFrom", 2);
              ((Intent)localObject).setClass(g.i(g.this), IPCallShareCouponCardUI.class);
              paramAnonymousView = g.i(g.this);
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, 1, -1, g.e(g.this), g.f(g.this));
              AppMethodBeat.o(25776);
            }
          });
          this.jPx = ((ScrollView)this.hIZ.findViewById(2131299891));
          paramActivity = ((ViewGroup)this.mActivity.findViewById(16908290)).getChildAt(0);
          paramActivity.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public final void onGlobalLayout()
            {
              AppMethodBeat.i(25769);
              Object localObject = new Rect();
              paramActivity.getWindowVisibleDisplayFrame((Rect)localObject);
              if (paramActivity.getRootView().getHeight() - (((Rect)localObject).bottom - ((Rect)localObject).top) > 100)
              {
                localObject = g.this;
                ((g)localObject).hIZ.postDelayed(new g.2((g)localObject), 100L);
              }
              AppMethodBeat.o(25769);
            }
          });
          AppMethodBeat.o(25778);
          return;
          this.sHw.setVisibility(0);
          this.sHw.setText(paramActivity);
        }
      }
    }
  }
  
  private void Fq(int paramInt)
  {
    AppMethodBeat.i(25780);
    this.sHo = paramInt;
    if (paramInt == 0)
    {
      this.sHl.setVisibility(4);
      this.sHm.setVisibility(4);
      this.sHn.setVisibility(4);
      this.sHs.setEnabled(false);
      Ft(0);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 1)
    {
      this.sHl.setVisibility(0);
      this.sHm.setVisibility(4);
      this.sHn.setVisibility(4);
      this.sHs.setEnabled(true);
      Ft(1);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 2)
    {
      this.sHl.setVisibility(0);
      this.sHm.setVisibility(0);
      this.sHn.setVisibility(4);
      this.sHs.setEnabled(true);
      Ft(1);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 3)
    {
      this.sHl.setVisibility(0);
      this.sHm.setVisibility(0);
      this.sHn.setVisibility(0);
      this.sHs.setEnabled(true);
      Ft(0);
    }
    AppMethodBeat.o(25780);
  }
  
  private String Fr(int paramInt)
  {
    AppMethodBeat.i(25781);
    String str = "";
    if (paramInt == 3)
    {
      AppMethodBeat.o(25781);
      return "";
    }
    if (!bt.isNullOrNil(this.sHt.getText().toString().trim())) {
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
        if (!((a)localObject).sHB) {
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
  
  private LinkedList<doy> Fs(int paramInt)
  {
    AppMethodBeat.i(25782);
    LinkedList localLinkedList = new LinkedList();
    if (paramInt == 3)
    {
      AppMethodBeat.o(25782);
      return localLinkedList;
    }
    Object localObject1 = this.sHt.getText().toString().trim();
    Object localObject2;
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject2 = new doy();
      ((doy)localObject2).ID = 0;
      ((doy)localObject2).gKr = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (this.mItemList != null)
    {
      localObject1 = this.mItemList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        if (((a)localObject2).sHB)
        {
          doy localdoy = new doy();
          try
          {
            localdoy.ID = bt.getInt(((a)localObject2).Id, 0);
            localLinkedList.add(localdoy);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            ad.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + ((a)localObject2).Id);
          }
        }
      }
    }
    AppMethodBeat.o(25782);
    return localLinkedList;
  }
  
  private void Ft(int paramInt)
  {
    AppMethodBeat.i(25785);
    if (paramInt == 0)
    {
      this.sHg.setVisibility(0);
      this.sHh.setVisibility(4);
      if (this.sHd == 1)
      {
        ((LinearLayout.LayoutParams)this.sHp.getLayoutParams()).height = 0;
        this.sHp.requestLayout();
      }
      bt.hideVKB(this.hIZ);
    }
    for (;;)
    {
      this.sHd = paramInt;
      AppMethodBeat.o(25785);
      return;
      if (paramInt == 1)
      {
        this.sHg.setVisibility(0);
        this.sHh.setVisibility(4);
        if (this.sHd == 0)
        {
          ((LinearLayout.LayoutParams)this.sHp.getLayoutParams()).height = -2;
          this.sHp.requestLayout();
          this.sHp.startAnimation(this.sHx);
        }
      }
      else if (paramInt == 2)
      {
        this.sHg.setVisibility(4);
        this.sHh.setVisibility(0);
        bt.hideVKB(this.hIZ);
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
      ad.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(25784);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25779);
    super.onCreate(paramBundle);
    setContentView(this.hIZ);
    getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    Ft(0);
    AppMethodBeat.o(25779);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Eo = paramCharSequence;
      return;
    }
    this.Eo = null;
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
    public String sDZ;
    public boolean sHB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g
 * JD-Core Version:    0.7.0.1
 */