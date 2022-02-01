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
import com.tencent.mm.protocal.protobuf.aum;
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseAdapter
{
  Context context;
  boolean dlh;
  ArrayList<b> gnG;
  int udv;
  int upY;
  boolean usA;
  private ArrayList<d> usB;
  boolean ust;
  int usu;
  int usv;
  int usw;
  int usx;
  private int usy;
  boolean usz;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(42373);
    this.dlh = false;
    this.ust = false;
    this.upY = 0;
    this.usu = 0;
    this.usv = 0;
    this.usw = 0;
    this.usx = 0;
    this.udv = 0;
    this.usz = false;
    this.usA = false;
    this.context = paramContext;
    this.gnG = null;
    this.usy = paramContext.getResources().getColor(2131100452);
    AppMethodBeat.o(42373);
  }
  
  private String amm(String paramString)
  {
    AppMethodBeat.i(42378);
    if (this.usB == null) {
      this.usB = new ArrayList();
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
        this.usB.add(locald);
      }
      this.usB.clear();
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
      paramString = new SpannableString(amm(paramString));
      Iterator localIterator = this.usB.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald.start < locald.end) {
          paramString.setSpan(new ForegroundColorSpan(this.usy), locald.start, locald.end, 33);
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
    if (this.gnG == null)
    {
      AppMethodBeat.o(42374);
      return 0;
    }
    int i = this.gnG.size();
    AppMethodBeat.o(42374);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(42375);
    Object localObject = this.gnG.get(paramInt);
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
        ((a)localObject1).usF = ((TextView)((View)localObject2).findViewById(2131300481));
        ((a)localObject1).usG = ((TextView)((View)localObject2).findViewById(2131300474));
        ((a)localObject1).usH = ((TextView)((View)localObject2).findViewById(2131300477));
        ((a)localObject1).usI = ((TextView)((View)localObject2).findViewById(2131300482));
        ((a)localObject1).usJ = ((View)localObject2).findViewById(2131300478);
        ((a)localObject1).usK = ((TextView)((View)localObject2).findViewById(2131305132));
        ((a)localObject1).usL = ((TextView)((View)localObject2).findViewById(2131298858));
        ((View)localObject2).setTag(localObject1);
        paramViewGroup = (ViewGroup)localObject1;
        paramView = (View)localObject2;
        if (((a)localObject1).usF != null)
        {
          paramViewGroup = (ViewGroup)localObject1;
          paramView = (View)localObject2;
          if (((a)localObject1).usH != null)
          {
            paramView = ((a)localObject1).usF;
            paramViewGroup = ((a)localObject1).usH;
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
        ((e.a.a)localObject1).idp = false;
        ((e.a.a)localObject1).idr = false;
        e.dav().a(paramViewGroup.vl, localb.iconUrl, ((e.a.a)localObject1).daw());
      }
      b(paramViewGroup.usF, localb.name);
      b(paramViewGroup.usG, localb.usM);
      b(paramViewGroup.usH, localb.iTM);
      break label340;
      if (!bt.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).idp = false;
        ((e.a.a)localObject1).idr = false;
        ((e.a.a)localObject1).uvI = true;
        e.dav().a(paramViewGroup.vl, localb.iconUrl, ((e.a.a)localObject1).daw());
        paramViewGroup.vl.setVisibility(0);
        label604:
        b(paramViewGroup.usF, localb.name);
        b(paramViewGroup.usH, localb.iTM);
        if (bt.isNullOrNil(localb.hHI)) {
          break label724;
        }
        paramViewGroup.usK.setText(k.c(this.context, localb.hHI));
        paramViewGroup.usK.setVisibility(0);
      }
      for (;;)
      {
        if (localb.createTime <= 0L) {
          break label736;
        }
        paramViewGroup.usL.setText(b.l(this.context, localb.createTime * 1000L));
        paramViewGroup.usL.setVisibility(0);
        break;
        paramViewGroup.vl.setVisibility(8);
        break label604;
        label724:
        paramViewGroup.usK.setVisibility(8);
      }
      label736:
      paramViewGroup.usL.setVisibility(8);
      break label340;
      if (!bt.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).idp = false;
        ((e.a.a)localObject1).idr = false;
        e.dav().a(paramViewGroup.vl, localb.iconUrl, ((e.a.a)localObject1).daw());
      }
      b(paramViewGroup.usF, localb.name);
      b(paramViewGroup.usG, localb.usM);
      b(paramViewGroup.usH, localb.iTM);
      localObject1 = paramViewGroup.usI;
      localObject2 = localb.usP;
      StringBuilder localStringBuilder = new StringBuilder();
      if (!bt.hj((List)localObject2))
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
      paramViewGroup.usH.setText(localb.name);
      break label340;
      paramViewGroup.vl.setImageResource(2131691139);
      paramViewGroup.usF.setText(localb.name);
      break label340;
      if (localb.usT) {
        paramViewGroup.contentView.setBackgroundResource(2131231820);
      }
      for (;;)
      {
        paramInt = this.context.getResources().getDimensionPixelSize(2131165553);
        paramViewGroup.contentView.setPadding(0, paramInt, 0, paramInt);
        break;
        paramViewGroup.contentView.setBackgroundResource(2131231818);
      }
      if (localb.usS) {
        paramViewGroup.usJ.setVisibility(8);
      } else {
        paramViewGroup.usJ.setVisibility(0);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 7;
  }
  
  public final void reset()
  {
    this.udv = 0;
    this.usz = false;
  }
  
  static final class a
  {
    public View contentView;
    TextView usF;
    TextView usG;
    TextView usH;
    TextView usI;
    View usJ;
    TextView usK;
    TextView usL;
    ImageView vl;
  }
  
  public static final class b
  {
    public int actionType;
    public String appId;
    public long createTime;
    public String dld;
    public String hHI;
    public String iTM;
    public String iconUrl;
    public String name;
    public int type;
    public String usM;
    public aun usN;
    public String usO;
    public LinkedList<String> usP;
    public int usQ;
    public int usR;
    public boolean usS = false;
    public boolean usT = false;
    public r.c usU;
    
    public static b a(aum paramaum)
    {
      AppMethodBeat.i(42371);
      b localb = new b();
      localb.type = 2;
      localb.name = paramaum.Title;
      localb.iTM = paramaum.Desc;
      localb.iconUrl = paramaum.ThumbUrl;
      localb.usO = paramaum.Gsq;
      localb.usQ = paramaum.GsK;
      localb.usR = paramaum.GsL;
      localb.appId = paramaum.iht;
      localb.hHI = paramaum.uiR;
      localb.createTime = paramaum.FHr;
      localb.usU = new r.c(paramaum.Gsq, (byte)0);
      AppMethodBeat.o(42371);
      return localb;
    }
    
    public static b bp(int paramInt, String paramString)
    {
      AppMethodBeat.i(42370);
      b localb = new b();
      localb.type = paramInt;
      localb.name = paramString;
      localb.usU = new r.c();
      AppMethodBeat.o(42370);
      return localb;
    }
  }
  
  public static final class c
  {
    public int actionType;
    String appId;
    int dFG;
    int position;
    int type;
    int usQ;
    int usR;
    String usV;
    String usW;
    
    public c() {}
    
    public c(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(42372);
      this.actionType = paramInt1;
      this.type = paramInt2;
      this.appId = paramString1;
      if (paramInt1 == 2) {
        this.usV = paramString2;
      }
      AppMethodBeat.o(42372);
    }
    
    public c(String paramString)
    {
      this.actionType = 2;
      this.usV = paramString;
    }
    
    public c(String paramString, byte paramByte)
    {
      this.actionType = 2;
      this.type = 3;
      this.usV = paramString;
    }
  }
  
  final class d
  {
    int end = -1;
    int start = -1;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.r
 * JD-Core Version:    0.7.0.1
 */