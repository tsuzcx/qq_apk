package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.b;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseAdapter
{
  Context context;
  boolean dcq;
  ArrayList<b> fQh;
  int rXN;
  int sjI;
  boolean smb;
  int smc;
  int smd;
  int sme;
  int smf;
  private int smg;
  boolean smh;
  boolean smi;
  private ArrayList<d> smj;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(42373);
    this.dcq = false;
    this.smb = false;
    this.sjI = 0;
    this.smc = 0;
    this.smd = 0;
    this.sme = 0;
    this.smf = 0;
    this.rXN = 0;
    this.smh = false;
    this.smi = false;
    this.context = paramContext;
    this.fQh = null;
    this.smg = paramContext.getResources().getColor(2131100452);
    AppMethodBeat.o(42373);
  }
  
  private String acU(String paramString)
  {
    AppMethodBeat.i(42378);
    if (this.smj == null) {
      this.smj = new ArrayList();
    }
    for (;;)
    {
      paramString = new StringBuilder(paramString);
      d locald = new d((byte)0);
      for (int i = paramString.indexOf("<em>"); i >= 0; i = paramString.indexOf("<em>"))
      {
        locald.start = i;
        paramString.delete(i, i + 4);
        i = paramString.indexOf("</em>");
        if (i < 0) {
          break;
        }
        locald.end = i;
        paramString.delete(i, i + 5);
        this.smj.add(locald);
      }
      this.smj.clear();
    }
    paramString = paramString.toString();
    AppMethodBeat.o(42378);
    return paramString;
  }
  
  private void b(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(42379);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = new SpannableString(acU(paramString));
      Iterator localIterator = this.smj.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald.start < locald.end) {
          paramString.setSpan(new ForegroundColorSpan(this.smg), locald.start, locald.end, 33);
        }
      }
      paramTextView.setText(paramString);
      paramTextView.setVisibility(0);
      AppMethodBeat.o(42379);
      return;
    }
    paramTextView.setVisibility(8);
    AppMethodBeat.o(42379);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(42374);
    if (this.fQh == null)
    {
      AppMethodBeat.o(42374);
      return 0;
    }
    int i = this.fQh.size();
    AppMethodBeat.o(42374);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(42375);
    Object localObject = this.fQh.get(paramInt);
    AppMethodBeat.o(42375);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(42376);
    paramInt = ((b)getItem(paramInt)).type;
    AppMethodBeat.o(42376);
    return paramInt;
  }
  
  public final View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42377);
    b localb = (b)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = new a((byte)0);
      paramView = this.context;
      switch (localb.type)
      {
      case 4: 
      default: 
        paramInt = 0;
        localObject2 = View.inflate(paramView, paramInt, null);
        ((a)localObject1).contentView = ((View)localObject2).findViewById(2131300476);
        ((a)localObject1).st = ((ImageView)((View)localObject2).findViewById(2131300479));
        ((a)localObject1).smn = ((TextView)((View)localObject2).findViewById(2131300481));
        ((a)localObject1).smo = ((TextView)((View)localObject2).findViewById(2131300474));
        ((a)localObject1).smp = ((TextView)((View)localObject2).findViewById(2131300477));
        ((a)localObject1).smq = ((TextView)((View)localObject2).findViewById(2131300482));
        ((a)localObject1).smr = ((View)localObject2).findViewById(2131300478);
        ((a)localObject1).sms = ((TextView)((View)localObject2).findViewById(2131305132));
        ((a)localObject1).smt = ((TextView)((View)localObject2).findViewById(2131298858));
        ((View)localObject2).setTag(localObject1);
        paramViewGroup = (ViewGroup)localObject1;
        paramView = (View)localObject2;
        if (((a)localObject1).smn != null)
        {
          paramViewGroup = (ViewGroup)localObject1;
          paramView = (View)localObject2;
          if (((a)localObject1).smp != null)
          {
            paramView = ((a)localObject1).smn;
            paramViewGroup = ((a)localObject1).smp;
            paramView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
            {
              public final void onGlobalLayout()
              {
                AppMethodBeat.i(42369);
                if (paramView.getLineCount() > 1)
                {
                  paramView.setMaxLines(2);
                  paramViewGroup.setMaxLines(1);
                  AppMethodBeat.o(42369);
                  return;
                }
                paramViewGroup.setMaxLines(2);
                AppMethodBeat.o(42369);
              }
            });
            paramView = (View)localObject2;
            paramViewGroup = (ViewGroup)localObject1;
          }
        }
        label291:
        switch (localb.type)
        {
        case 4: 
        default: 
          label340:
          switch (localb.type)
          {
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(42377);
      return paramView;
      paramInt = 2131494377;
      break;
      paramInt = 2131494384;
      break;
      paramInt = 2131494383;
      break;
      paramInt = 2131494379;
      break;
      paramInt = 2131494380;
      break;
      paramInt = 2131494382;
      break;
      paramViewGroup = (a)paramView.getTag();
      break label291;
      if (!bt.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).hjS = false;
        ((e.a.a)localObject1).hjU = false;
        e.cEB().a(paramViewGroup.st, localb.iconUrl, ((e.a.a)localObject1).cEC());
      }
      b(paramViewGroup.smn, localb.name);
      b(paramViewGroup.smo, localb.smu);
      b(paramViewGroup.smp, localb.iaz);
      break label340;
      if (!bt.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).hjS = false;
        ((e.a.a)localObject1).hjU = false;
        ((e.a.a)localObject1).soD = true;
        e.cEB().a(paramViewGroup.st, localb.iconUrl, ((e.a.a)localObject1).cEC());
        paramViewGroup.st.setVisibility(0);
        label604:
        b(paramViewGroup.smn, localb.name);
        b(paramViewGroup.smp, localb.iaz);
        if (bt.isNullOrNil(localb.gOQ)) {
          break label724;
        }
        paramViewGroup.sms.setText(k.c(this.context, localb.gOQ));
        paramViewGroup.sms.setVisibility(0);
      }
      for (;;)
      {
        if (localb.createTime <= 0L) {
          break label736;
        }
        paramViewGroup.smt.setText(b.k(this.context, localb.createTime * 1000L));
        paramViewGroup.smt.setVisibility(0);
        break;
        paramViewGroup.st.setVisibility(8);
        break label604;
        label724:
        paramViewGroup.sms.setVisibility(8);
      }
      label736:
      paramViewGroup.smt.setVisibility(8);
      break label340;
      if (!bt.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).hjS = false;
        ((e.a.a)localObject1).hjU = false;
        e.cEB().a(paramViewGroup.st, localb.iconUrl, ((e.a.a)localObject1).cEC());
      }
      b(paramViewGroup.smn, localb.name);
      b(paramViewGroup.smo, localb.smu);
      b(paramViewGroup.smp, localb.iaz);
      localObject1 = paramViewGroup.smq;
      localObject2 = localb.smx;
      StringBuilder localStringBuilder = new StringBuilder();
      if (!bt.gL((List)localObject2))
      {
        int i = ((LinkedList)localObject2).size();
        paramInt = 0;
        while (paramInt < i - 1)
        {
          localStringBuilder.append((String)((LinkedList)localObject2).get(paramInt) + "\n");
          paramInt += 1;
        }
        localStringBuilder.append((String)((LinkedList)localObject2).get(i - 1));
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(localStringBuilder.toString());
        break label340;
      }
      ((TextView)localObject1).setVisibility(8);
      break label340;
      paramViewGroup.smp.setText(localb.name);
      break label340;
      paramViewGroup.st.setImageResource(2131691139);
      paramViewGroup.smn.setText(localb.name);
      break label340;
      if (localb.smB) {
        paramViewGroup.contentView.setBackgroundResource(2131231820);
      }
      for (;;)
      {
        paramInt = this.context.getResources().getDimensionPixelSize(2131165553);
        paramViewGroup.contentView.setPadding(0, paramInt, 0, paramInt);
        break;
        paramViewGroup.contentView.setBackgroundResource(2131231818);
      }
      if (localb.smA) {
        paramViewGroup.smr.setVisibility(8);
      } else {
        paramViewGroup.smr.setVisibility(0);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 7;
  }
  
  public final void reset()
  {
    this.rXN = 0;
    this.smh = false;
  }
  
  static final class a
  {
    public View contentView;
    TextView smn;
    TextView smo;
    TextView smp;
    TextView smq;
    View smr;
    TextView sms;
    TextView smt;
    ImageView st;
  }
  
  public static final class b
  {
    public int actionType;
    public String appId;
    public long createTime;
    public String dcm;
    public String gOQ;
    public String iaz;
    public String iconUrl;
    public String name;
    public boolean smA = false;
    public boolean smB = false;
    public r.c smC;
    public String smu;
    public ann smv;
    public String smw;
    public LinkedList<String> smx;
    public int smy;
    public int smz;
    public int type;
    
    public static b a(anm paramanm)
    {
      AppMethodBeat.i(42371);
      b localb = new b();
      localb.type = 2;
      localb.name = paramanm.Title;
      localb.iaz = paramanm.Desc;
      localb.iconUrl = paramanm.ThumbUrl;
      localb.smw = paramanm.Doo;
      localb.smy = paramanm.DoI;
      localb.smz = paramanm.DoJ;
      localb.appId = paramanm.hnC;
      localb.gOQ = paramanm.scR;
      localb.createTime = paramanm.CJd;
      localb.smC = new r.c(paramanm.Doo, (byte)0);
      AppMethodBeat.o(42371);
      return localb;
    }
    
    public static b bh(int paramInt, String paramString)
    {
      AppMethodBeat.i(42370);
      b localb = new b();
      localb.type = paramInt;
      localb.name = paramString;
      localb.smC = new r.c();
      AppMethodBeat.o(42370);
      return localb;
    }
  }
  
  public static final class c
  {
    public int actionType;
    String appId;
    int dvS;
    int position;
    String smD;
    String smE;
    int smy;
    int smz;
    int type;
    
    public c() {}
    
    public c(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(42372);
      this.actionType = paramInt1;
      this.type = paramInt2;
      this.appId = paramString1;
      if (paramInt1 == 2) {
        this.smD = paramString2;
      }
      AppMethodBeat.o(42372);
    }
    
    public c(String paramString)
    {
      this.actionType = 2;
      this.smD = paramString;
    }
    
    public c(String paramString, byte paramByte)
    {
      this.actionType = 2;
      this.type = 3;
      this.smD = paramString;
    }
  }
  
  final class d
  {
    int end = -1;
    int start = -1;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.r
 * JD-Core Version:    0.7.0.1
 */