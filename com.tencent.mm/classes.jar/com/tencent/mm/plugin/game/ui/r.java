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
import com.tencent.mm.protocal.protobuf.avc;
import com.tencent.mm.protocal.protobuf.avd;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseAdapter
{
  Context context;
  boolean dmj;
  ArrayList<b> gqc;
  int uBu;
  boolean uDM;
  int uDN;
  int uDO;
  int uDP;
  int uDQ;
  private int uDR;
  boolean uDS;
  boolean uDT;
  private ArrayList<d> uDU;
  int uoD;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(42373);
    this.dmj = false;
    this.uDM = false;
    this.uBu = 0;
    this.uDN = 0;
    this.uDO = 0;
    this.uDP = 0;
    this.uDQ = 0;
    this.uoD = 0;
    this.uDS = false;
    this.uDT = false;
    this.context = paramContext;
    this.gqc = null;
    this.uDR = paramContext.getResources().getColor(2131100452);
    AppMethodBeat.o(42373);
  }
  
  private String anm(String paramString)
  {
    AppMethodBeat.i(42378);
    if (this.uDU == null) {
      this.uDU = new ArrayList();
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
        this.uDU.add(locald);
      }
      this.uDU.clear();
    }
    paramString = paramString.toString();
    AppMethodBeat.o(42378);
    return paramString;
  }
  
  private void b(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(42379);
    if (!bu.isNullOrNil(paramString))
    {
      paramString = new SpannableString(anm(paramString));
      Iterator localIterator = this.uDU.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald.start < locald.end) {
          paramString.setSpan(new ForegroundColorSpan(this.uDR), locald.start, locald.end, 33);
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
    if (this.gqc == null)
    {
      AppMethodBeat.o(42374);
      return 0;
    }
    int i = this.gqc.size();
    AppMethodBeat.o(42374);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(42375);
    Object localObject = this.gqc.get(paramInt);
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
        ((a)localObject1).vl = ((ImageView)((View)localObject2).findViewById(2131300479));
        ((a)localObject1).uDY = ((TextView)((View)localObject2).findViewById(2131300481));
        ((a)localObject1).uDZ = ((TextView)((View)localObject2).findViewById(2131300474));
        ((a)localObject1).uEa = ((TextView)((View)localObject2).findViewById(2131300477));
        ((a)localObject1).uEb = ((TextView)((View)localObject2).findViewById(2131300482));
        ((a)localObject1).uEc = ((View)localObject2).findViewById(2131300478);
        ((a)localObject1).uEd = ((TextView)((View)localObject2).findViewById(2131305132));
        ((a)localObject1).uEe = ((TextView)((View)localObject2).findViewById(2131298858));
        ((View)localObject2).setTag(localObject1);
        paramViewGroup = (ViewGroup)localObject1;
        paramView = (View)localObject2;
        if (((a)localObject1).uDY != null)
        {
          paramViewGroup = (ViewGroup)localObject1;
          paramView = (View)localObject2;
          if (((a)localObject1).uEa != null)
          {
            paramView = ((a)localObject1).uDY;
            paramViewGroup = ((a)localObject1).uEa;
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
      if (!bu.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).igi = false;
        ((e.a.a)localObject1).igk = false;
        e.ddh().a(paramViewGroup.vl, localb.iconUrl, ((e.a.a)localObject1).ddi());
      }
      b(paramViewGroup.uDY, localb.name);
      b(paramViewGroup.uDZ, localb.uEf);
      b(paramViewGroup.uEa, localb.iWF);
      break label340;
      if (!bu.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).igi = false;
        ((e.a.a)localObject1).igk = false;
        ((e.a.a)localObject1).uHh = true;
        e.ddh().a(paramViewGroup.vl, localb.iconUrl, ((e.a.a)localObject1).ddi());
        paramViewGroup.vl.setVisibility(0);
        label604:
        b(paramViewGroup.uDY, localb.name);
        b(paramViewGroup.uEa, localb.iWF);
        if (bu.isNullOrNil(localb.hKA)) {
          break label724;
        }
        paramViewGroup.uEd.setText(k.c(this.context, localb.hKA));
        paramViewGroup.uEd.setVisibility(0);
      }
      for (;;)
      {
        if (localb.createTime <= 0L) {
          break label736;
        }
        paramViewGroup.uEe.setText(b.m(this.context, localb.createTime * 1000L));
        paramViewGroup.uEe.setVisibility(0);
        break;
        paramViewGroup.vl.setVisibility(8);
        break label604;
        label724:
        paramViewGroup.uEd.setVisibility(8);
      }
      label736:
      paramViewGroup.uEe.setVisibility(8);
      break label340;
      if (!bu.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).igi = false;
        ((e.a.a)localObject1).igk = false;
        e.ddh().a(paramViewGroup.vl, localb.iconUrl, ((e.a.a)localObject1).ddi());
      }
      b(paramViewGroup.uDY, localb.name);
      b(paramViewGroup.uDZ, localb.uEf);
      b(paramViewGroup.uEa, localb.iWF);
      localObject1 = paramViewGroup.uEb;
      localObject2 = localb.uEi;
      StringBuilder localStringBuilder = new StringBuilder();
      if (!bu.ht((List)localObject2))
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
      paramViewGroup.uEa.setText(localb.name);
      break label340;
      paramViewGroup.vl.setImageResource(2131691139);
      paramViewGroup.uDY.setText(localb.name);
      break label340;
      if (localb.uEm) {
        paramViewGroup.contentView.setBackgroundResource(2131231820);
      }
      for (;;)
      {
        paramInt = this.context.getResources().getDimensionPixelSize(2131165553);
        paramViewGroup.contentView.setPadding(0, paramInt, 0, paramInt);
        break;
        paramViewGroup.contentView.setBackgroundResource(2131231818);
      }
      if (localb.uEl) {
        paramViewGroup.uEc.setVisibility(8);
      } else {
        paramViewGroup.uEc.setVisibility(0);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 7;
  }
  
  public final void reset()
  {
    this.uoD = 0;
    this.uDS = false;
  }
  
  static final class a
  {
    public View contentView;
    TextView uDY;
    TextView uDZ;
    TextView uEa;
    TextView uEb;
    View uEc;
    TextView uEd;
    TextView uEe;
    ImageView vl;
  }
  
  public static final class b
  {
    public int actionType;
    public String appId;
    public long createTime;
    public String dmf;
    public String hKA;
    public String iWF;
    public String iconUrl;
    public String name;
    public int type;
    public String uEf;
    public avd uEg;
    public String uEh;
    public LinkedList<String> uEi;
    public int uEj;
    public int uEk;
    public boolean uEl = false;
    public boolean uEm = false;
    public r.c uEn;
    
    public static b a(avc paramavc)
    {
      AppMethodBeat.i(42371);
      b localb = new b();
      localb.type = 2;
      localb.name = paramavc.Title;
      localb.iWF = paramavc.Desc;
      localb.iconUrl = paramavc.ThumbUrl;
      localb.uEh = paramavc.GLO;
      localb.uEj = paramavc.GMi;
      localb.uEk = paramavc.GMj;
      localb.appId = paramavc.ikm;
      localb.hKA = paramavc.uuo;
      localb.createTime = paramavc.FZN;
      localb.uEn = new r.c(paramavc.GLO, (byte)0);
      AppMethodBeat.o(42371);
      return localb;
    }
    
    public static b bo(int paramInt, String paramString)
    {
      AppMethodBeat.i(42370);
      b localb = new b();
      localb.type = paramInt;
      localb.name = paramString;
      localb.uEn = new r.c();
      AppMethodBeat.o(42370);
      return localb;
    }
  }
  
  public static final class c
  {
    public int actionType;
    String appId;
    int dGL;
    int position;
    int type;
    int uEj;
    int uEk;
    String uEo;
    String uEp;
    
    public c() {}
    
    public c(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(42372);
      this.actionType = paramInt1;
      this.type = paramInt2;
      this.appId = paramString1;
      if (paramInt1 == 2) {
        this.uEo = paramString2;
      }
      AppMethodBeat.o(42372);
    }
    
    public c(String paramString)
    {
      this.actionType = 2;
      this.uEo = paramString;
    }
    
    public c(String paramString, byte paramByte)
    {
      this.actionType = 2;
      this.type = 3;
      this.uEo = paramString;
    }
  }
  
  final class d
  {
    int end = -1;
    int start = -1;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.r
 * JD-Core Version:    0.7.0.1
 */