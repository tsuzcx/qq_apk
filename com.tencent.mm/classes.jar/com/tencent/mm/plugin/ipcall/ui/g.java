package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.ipcall.a.e.d;
import com.tencent.mm.plugin.ipcall.a.g.f;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.pluginsdk.g.a.a.b;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.protocal.c.chm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g
  extends Dialog
{
  private CharSequence BM;
  private ScrollView gqx;
  View ipf;
  private int keS = R.e.feedback_white_tag_color;
  private int keT = R.g.feedback_white_tab_selector;
  private int lvT = 0;
  private int lvU;
  private long lvV;
  private LinearLayout lvW;
  private LinearLayout lvX;
  private RelativeLayout lvY;
  private RelativeLayout lvZ;
  private RelativeLayout lwa;
  private ImageView lwb;
  private ImageView lwc;
  private ImageView lwd;
  private int lwe;
  private FrameLayout lwf;
  private FlowLayout lwg;
  private Button lwh;
  private Button lwi;
  private PasterEditText lwj;
  private Button lwk;
  private Button lwl;
  private TextView lwm;
  private Animation lwn;
  private int lwo = R.g.feedback_green_tab_selector;
  private int lwp = R.e.white_text_color;
  private Activity mActivity;
  private Context mContext;
  private ah mHandler = new ah();
  private ArrayList<g.a> mItemList;
  private View.OnClickListener mOnClickListener = new g.3(this);
  
  public g(Activity paramActivity, Context paramContext, int paramInt, long paramLong)
  {
    super(paramContext, R.m.mmalertdialog);
    setCancelable(false);
    this.mContext = paramContext;
    this.lvU = paramInt;
    this.lvV = paramLong;
    this.mActivity = paramActivity;
    this.ipf = View.inflate(this.mContext, R.i.ipcall_feedback_dialog_ui, null);
    this.lvW = ((LinearLayout)this.ipf.findViewById(R.h.layoutFeedback));
    this.lvX = ((LinearLayout)this.ipf.findViewById(R.h.layoutInvite));
    this.lwn = AnimationUtils.loadAnimation(ae.getContext(), R.a.alpha_in);
    this.lwn.setDuration(200L);
    this.lwn.setStartOffset(100L);
    bcZ();
    this.lvY = ((RelativeLayout)this.ipf.findViewById(R.h.layoutStar_1));
    this.lvZ = ((RelativeLayout)this.ipf.findViewById(R.h.layoutStar_2));
    this.lwa = ((RelativeLayout)this.ipf.findViewById(R.h.layoutStar_3));
    this.lvY.setOnClickListener(this.mOnClickListener);
    this.lvZ.setOnClickListener(this.mOnClickListener);
    this.lwa.setOnClickListener(this.mOnClickListener);
    this.lwb = ((ImageView)this.ipf.findViewById(R.h.imgStar_1));
    this.lwc = ((ImageView)this.ipf.findViewById(R.h.imgStar_2));
    this.lwd = ((ImageView)this.ipf.findViewById(R.h.imgStar_3));
    this.lwe = 0;
    sM(this.lwe);
    this.lwk = ((Button)this.ipf.findViewById(R.h.invite_dialog_btn_cancel));
    this.lwl = ((Button)this.ipf.findViewById(R.h.invite_dialog_btn_invite));
    this.lwm = ((TextView)this.ipf.findViewById(R.h.invite_dialog_msg_content_tv));
    paramActivity = c.bdt();
    if (paramActivity != null) {}
    for (paramActivity = String.format(this.mContext.getString(R.l.ipcall_share_coupon_card_content_desc), new Object[] { paramActivity.tiK });; paramActivity = null)
    {
      if (bk.bl(paramActivity)) {
        this.lwm.setVisibility(4);
      }
      for (;;)
      {
        this.lwk.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            g.this.dismiss();
            d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, -1, 1, g.e(g.this), g.f(g.this));
          }
        });
        this.lwl.setOnClickListener(new g.8(this));
        this.gqx = ((ScrollView)this.ipf.findViewById(R.h.feedback_dialog_scrollview));
        paramActivity = ((ViewGroup)this.mActivity.findViewById(16908290)).getChildAt(0);
        paramActivity.getViewTreeObserver().addOnGlobalLayoutListener(new g.1(this, paramActivity));
        return;
        this.lwm.setVisibility(0);
        this.lwm.setText(paramActivity);
      }
    }
  }
  
  private void bcZ()
  {
    this.lwf = ((FrameLayout)this.ipf.findViewById(R.h.flowLayoutParent));
    this.lwg = ((FlowLayout)this.ipf.findViewById(R.h.flowLayout));
    this.lwh = ((Button)this.ipf.findViewById(R.h.confirm_dialog_btn_cancel));
    this.lwi = ((Button)this.ipf.findViewById(R.h.confirm_dialog_btn_commit));
    this.lwj = ((PasterEditText)this.ipf.findViewById(R.h.confirm_dialog_text_et));
    this.lwh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        g.this.dismiss();
        d.a(-1, 1, -1, "", 0, -1, -1, g.e(g.this), g.f(g.this));
      }
    });
    this.lwi.setOnClickListener(new g.5(this));
    Object localObject3 = com.tencent.mm.plugin.ipcall.a.e.bbZ();
    Object localObject1;
    if (((com.tencent.mm.plugin.ipcall.a.e)localObject3).loF == null)
    {
      y.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
      b.c.clv();
      localObject1 = b.eV(39, 1);
      if (bk.bl((String)localObject1)) {
        break label383;
      }
      localObject1 = com.tencent.mm.a.e.d((String)localObject1, 0, -1);
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.ipcall.a.e)localObject3).aA((byte[])localObject1);
      }
    }
    else
    {
      if (((com.tencent.mm.plugin.ipcall.a.e)localObject3).loF == null) {
        break label425;
      }
      localObject1 = x.e(ae.getContext().getSharedPreferences(ae.cqR(), 0));
      if ((!"language_default".equalsIgnoreCase((String)localObject1)) || (Locale.getDefault() == null)) {
        break label593;
      }
      localObject1 = Locale.getDefault().toString();
    }
    label287:
    label425:
    label593:
    for (;;)
    {
      Object localObject4 = ((com.tencent.mm.plugin.ipcall.a.e)localObject3).loF.iterator();
      Object localObject2;
      while (((Iterator)localObject4).hasNext())
      {
        localObject2 = (f)((Iterator)localObject4).next();
        if (((String)localObject1).equalsIgnoreCase(((f)localObject2).lsM))
        {
          y.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", new Object[] { localObject1, Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.e)localObject3).loF.size()) });
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = ((f)localObject1).lsN;
          localObject1 = new ArrayList();
          localObject2 = ((ArrayList)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (com.tencent.mm.plugin.ipcall.a.g.e)((Iterator)localObject2).next();
              localObject4 = new g.a();
              ((g.a)localObject4).lsK = ((com.tencent.mm.plugin.ipcall.a.g.e)localObject3).lsK;
              ((g.a)localObject4).lsL = ((com.tencent.mm.plugin.ipcall.a.g.e)localObject3).lsL;
              ((g.a)localObject4).lwr = false;
              ((ArrayList)localObject1).add(localObject4);
              continue;
              y.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
              break;
              label383:
              y.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
              break;
              y.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", new Object[] { localObject1, Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.e)localObject3).loF.size()) });
              localObject1 = null;
              break label287;
            }
          }
          this.mItemList = ((ArrayList)localObject1);
          localObject1 = this.mItemList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (g.a)((Iterator)localObject1).next();
            localObject3 = this.lwg;
            localObject4 = new TextView(getContext());
            ((TextView)localObject4).setTextSize(0, getContext().getResources().getDimension(R.f.feedback_tag_font_size) * a.cJ(getContext()));
            ((TextView)localObject4).setBackgroundResource(this.keT);
            ((TextView)localObject4).setTextColor(this.mContext.getResources().getColor(this.keS));
            ((TextView)localObject4).setTag(localObject2);
            ((TextView)localObject4).setGravity(17);
            ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView)localObject4).setSingleLine();
            ((TextView)localObject4).setText(((g.a)localObject2).lsL);
            ((TextView)localObject4).setOnClickListener(new g.6(this));
            ((FlowLayout)localObject3).addView((View)localObject4);
          }
        }
      }
      return;
    }
  }
  
  private void sM(int paramInt)
  {
    this.lwe = paramInt;
    if (paramInt == 0)
    {
      this.lwb.setVisibility(4);
      this.lwc.setVisibility(4);
      this.lwd.setVisibility(4);
      this.lwi.setEnabled(false);
      sP(0);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.lwb.setVisibility(0);
        this.lwc.setVisibility(4);
        this.lwd.setVisibility(4);
        this.lwi.setEnabled(true);
        sP(1);
        return;
      }
      if (paramInt == 2)
      {
        this.lwb.setVisibility(0);
        this.lwc.setVisibility(0);
        this.lwd.setVisibility(4);
        this.lwi.setEnabled(true);
        sP(1);
        return;
      }
    } while (paramInt != 3);
    this.lwb.setVisibility(0);
    this.lwc.setVisibility(0);
    this.lwd.setVisibility(0);
    this.lwi.setEnabled(true);
    sP(0);
  }
  
  private String sN(int paramInt)
  {
    String str = "";
    Object localObject;
    if (paramInt == 3)
    {
      localObject = "";
      return localObject;
    }
    if (!bk.bl(this.lwj.getText().toString().trim())) {
      str = "0";
    }
    if (this.mItemList != null)
    {
      Iterator localIterator = this.mItemList.iterator();
      for (;;)
      {
        localObject = str;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (g.a)localIterator.next();
        if (!((g.a)localObject).lwr) {
          break label133;
        }
        if (!str.equals("")) {
          break label102;
        }
        str = ((g.a)localObject).lsK;
      }
      label102:
      str = str + "_" + ((g.a)localObject).lsK;
      label133:
      for (;;)
      {
        break;
      }
    }
    return str;
  }
  
  private LinkedList<chm> sO(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramInt == 3) {
      return localLinkedList;
    }
    Object localObject1 = this.lwj.getText().toString().trim();
    Object localObject2;
    if (!bk.bl((String)localObject1))
    {
      localObject2 = new chm();
      ((chm)localObject2).bxH = 0;
      ((chm)localObject2).kVs = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (this.mItemList != null)
    {
      localObject1 = this.mItemList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (g.a)((Iterator)localObject1).next();
        if (((g.a)localObject2).lwr)
        {
          chm localchm = new chm();
          try
          {
            localchm.bxH = bk.getInt(((g.a)localObject2).lsK, 0);
            localLinkedList.add(localchm);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            y.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + ((g.a)localObject2).lsK);
          }
        }
      }
    }
    return localLinkedList;
  }
  
  private void sP(int paramInt)
  {
    if (paramInt == 0)
    {
      this.lvW.setVisibility(0);
      this.lvX.setVisibility(4);
      if (this.lvT == 1)
      {
        ((LinearLayout.LayoutParams)this.lwf.getLayoutParams()).height = 0;
        this.lwf.requestLayout();
      }
      bk.hideVKB(this.ipf);
    }
    for (;;)
    {
      this.lvT = paramInt;
      return;
      if (paramInt == 1)
      {
        this.lvW.setVisibility(0);
        this.lvX.setVisibility(4);
        if (this.lvT == 0)
        {
          ((LinearLayout.LayoutParams)this.lwf.getLayoutParams()).height = -2;
          this.lwf.requestLayout();
          this.lwf.startAnimation(this.lwn);
        }
      }
      else if (paramInt == 2)
      {
        this.lvW.setVisibility(4);
        this.lvX.setVisibility(0);
        bk.hideVKB(this.ipf);
      }
    }
  }
  
  public final void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + localException.getMessage());
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.ipf);
    getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    sP(0);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.BM = paramCharSequence;
      return;
    }
    this.BM = null;
  }
  
  public final void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g
 * JD-Core Version:    0.7.0.1
 */