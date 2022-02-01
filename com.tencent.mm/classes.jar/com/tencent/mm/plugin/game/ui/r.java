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
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseAdapter
{
  boolean cZP;
  Context context;
  ArrayList<b> fUc;
  int tfF;
  int trB;
  boolean ttU;
  int ttV;
  int ttW;
  int ttX;
  int ttY;
  private int ttZ;
  boolean tua;
  boolean tub;
  private ArrayList<d> tuc;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(42373);
    this.cZP = false;
    this.ttU = false;
    this.trB = 0;
    this.ttV = 0;
    this.ttW = 0;
    this.ttX = 0;
    this.ttY = 0;
    this.tfF = 0;
    this.tua = false;
    this.tub = false;
    this.context = paramContext;
    this.fUc = null;
    this.ttZ = paramContext.getResources().getColor(2131100452);
    AppMethodBeat.o(42373);
  }
  
  private String ahM(String paramString)
  {
    AppMethodBeat.i(42378);
    if (this.tuc == null) {
      this.tuc = new ArrayList();
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
        this.tuc.add(locald);
      }
      this.tuc.clear();
    }
    paramString = paramString.toString();
    AppMethodBeat.o(42378);
    return paramString;
  }
  
  private void b(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(42379);
    if (!bs.isNullOrNil(paramString))
    {
      paramString = new SpannableString(ahM(paramString));
      Iterator localIterator = this.tuc.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald.start < locald.end) {
          paramString.setSpan(new ForegroundColorSpan(this.ttZ), locald.start, locald.end, 33);
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
    if (this.fUc == null)
    {
      AppMethodBeat.o(42374);
      return 0;
    }
    int i = this.fUc.size();
    AppMethodBeat.o(42374);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(42375);
    Object localObject = this.fUc.get(paramInt);
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
        ((a)localObject1).ts = ((ImageView)((View)localObject2).findViewById(2131300479));
        ((a)localObject1).tug = ((TextView)((View)localObject2).findViewById(2131300481));
        ((a)localObject1).tuh = ((TextView)((View)localObject2).findViewById(2131300474));
        ((a)localObject1).tui = ((TextView)((View)localObject2).findViewById(2131300477));
        ((a)localObject1).tuj = ((TextView)((View)localObject2).findViewById(2131300482));
        ((a)localObject1).tuk = ((View)localObject2).findViewById(2131300478);
        ((a)localObject1).tul = ((TextView)((View)localObject2).findViewById(2131305132));
        ((a)localObject1).tum = ((TextView)((View)localObject2).findViewById(2131298858));
        ((View)localObject2).setTag(localObject1);
        paramViewGroup = (ViewGroup)localObject1;
        paramView = (View)localObject2;
        if (((a)localObject1).tug != null)
        {
          paramViewGroup = (ViewGroup)localObject1;
          paramView = (View)localObject2;
          if (((a)localObject1).tui != null)
          {
            paramView = ((a)localObject1).tug;
            paramViewGroup = ((a)localObject1).tui;
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
      if (!bs.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).hKv = false;
        ((e.a.a)localObject1).hKx = false;
        e.cRL().a(paramViewGroup.ts, localb.iconUrl, ((e.a.a)localObject1).cRM());
      }
      b(paramViewGroup.tug, localb.name);
      b(paramViewGroup.tuh, localb.tun);
      b(paramViewGroup.tui, localb.iAC);
      break label340;
      if (!bs.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).hKv = false;
        ((e.a.a)localObject1).hKx = false;
        ((e.a.a)localObject1).tww = true;
        e.cRL().a(paramViewGroup.ts, localb.iconUrl, ((e.a.a)localObject1).cRM());
        paramViewGroup.ts.setVisibility(0);
        label604:
        b(paramViewGroup.tug, localb.name);
        b(paramViewGroup.tui, localb.iAC);
        if (bs.isNullOrNil(localb.hpq)) {
          break label724;
        }
        paramViewGroup.tul.setText(k.c(this.context, localb.hpq));
        paramViewGroup.tul.setVisibility(0);
      }
      for (;;)
      {
        if (localb.createTime <= 0L) {
          break label736;
        }
        paramViewGroup.tum.setText(b.l(this.context, localb.createTime * 1000L));
        paramViewGroup.tum.setVisibility(0);
        break;
        paramViewGroup.ts.setVisibility(8);
        break label604;
        label724:
        paramViewGroup.tul.setVisibility(8);
      }
      label736:
      paramViewGroup.tum.setVisibility(8);
      break label340;
      if (!bs.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).hKv = false;
        ((e.a.a)localObject1).hKx = false;
        e.cRL().a(paramViewGroup.ts, localb.iconUrl, ((e.a.a)localObject1).cRM());
      }
      b(paramViewGroup.tug, localb.name);
      b(paramViewGroup.tuh, localb.tun);
      b(paramViewGroup.tui, localb.iAC);
      localObject1 = paramViewGroup.tuj;
      localObject2 = localb.tuq;
      StringBuilder localStringBuilder = new StringBuilder();
      if (!bs.gY((List)localObject2))
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
      paramViewGroup.tui.setText(localb.name);
      break label340;
      paramViewGroup.ts.setImageResource(2131691139);
      paramViewGroup.tug.setText(localb.name);
      break label340;
      if (localb.tuu) {
        paramViewGroup.contentView.setBackgroundResource(2131231820);
      }
      for (;;)
      {
        paramInt = this.context.getResources().getDimensionPixelSize(2131165553);
        paramViewGroup.contentView.setPadding(0, paramInt, 0, paramInt);
        break;
        paramViewGroup.contentView.setBackgroundResource(2131231818);
      }
      if (localb.tut) {
        paramViewGroup.tuk.setVisibility(8);
      } else {
        paramViewGroup.tuk.setVisibility(0);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 7;
  }
  
  public final void reset()
  {
    this.tfF = 0;
    this.tua = false;
  }
  
  static final class a
  {
    public View contentView;
    ImageView ts;
    TextView tug;
    TextView tuh;
    TextView tui;
    TextView tuj;
    View tuk;
    TextView tul;
    TextView tum;
  }
  
  public static final class b
  {
    public int actionType;
    public String appId;
    public String cZL;
    public long createTime;
    public String hpq;
    public String iAC;
    public String iconUrl;
    public String name;
    public String tun;
    public aqr tuo;
    public String tup;
    public LinkedList<String> tuq;
    public int tur;
    public int tus;
    public boolean tut = false;
    public boolean tuu = false;
    public r.c tuv;
    public int type;
    
    public static b a(aqq paramaqq)
    {
      AppMethodBeat.i(42371);
      b localb = new b();
      localb.type = 2;
      localb.name = paramaqq.Title;
      localb.iAC = paramaqq.Desc;
      localb.iconUrl = paramaqq.ThumbUrl;
      localb.tup = paramaqq.EJo;
      localb.tur = paramaqq.EJI;
      localb.tus = paramaqq.EJJ;
      localb.appId = paramaqq.hOf;
      localb.hpq = paramaqq.tkL;
      localb.createTime = paramaqq.EbF;
      localb.tuv = new r.c(paramaqq.EJo, (byte)0);
      AppMethodBeat.o(42371);
      return localb;
    }
    
    public static b bm(int paramInt, String paramString)
    {
      AppMethodBeat.i(42370);
      b localb = new b();
      localb.type = paramInt;
      localb.name = paramString;
      localb.tuv = new r.c();
      AppMethodBeat.o(42370);
      return localb;
    }
  }
  
  public static final class c
  {
    public int actionType;
    String appId;
    int dtF;
    int position;
    int tur;
    int tus;
    String tuw;
    String tux;
    int type;
    
    public c() {}
    
    public c(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(42372);
      this.actionType = paramInt1;
      this.type = paramInt2;
      this.appId = paramString1;
      if (paramInt1 == 2) {
        this.tuw = paramString2;
      }
      AppMethodBeat.o(42372);
    }
    
    public c(String paramString)
    {
      this.actionType = 2;
      this.tuw = paramString;
    }
    
    public c(String paramString, byte paramByte)
    {
      this.actionType = 2;
      this.type = 3;
      this.tuw = paramString;
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