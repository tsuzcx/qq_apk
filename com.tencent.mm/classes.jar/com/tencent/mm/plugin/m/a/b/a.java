package com.tencent.mm.plugin.m.a.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.ui.widget.picker.d;
import com.tencent.mm.ui.widget.picker.d.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  String kEw;
  d vCN;
  com.tencent.mm.ui.widget.picker.b vCO;
  c vCP;
  String vCQ;
  String vCR;
  ArrayList<String> vCS;
  public a vCT;
  String value;
  
  public a(Map<String, ?> paramMap)
  {
    AppMethodBeat.i(123786);
    this.vCS = new ArrayList();
    this.kEw = "selector";
    al(paramMap);
    AppMethodBeat.o(123786);
  }
  
  private void al(Map<String, ?> paramMap)
  {
    AppMethodBeat.i(123787);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      label104:
      int i;
      switch (str.hashCode())
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          break;
        case 0: 
          this.kEw = ((Map.Entry)localObject).getValue().toString();
          break;
          if (!str.equals("mode")) {
            break label104;
          }
          i = 0;
          continue;
          if (!str.equals("start")) {
            break label104;
          }
          i = 1;
          continue;
          if (!str.equals("end")) {
            break label104;
          }
          i = 2;
          continue;
          if (!str.equals("range")) {
            break label104;
          }
          i = 3;
          continue;
          if (!str.equals("value")) {
            break label104;
          }
          i = 4;
        }
      }
      this.vCQ = ((Map.Entry)localObject).getValue().toString();
      continue;
      this.vCR = ((Map.Entry)localObject).getValue().toString();
      continue;
      localObject = ((Map.Entry)localObject).getValue().toString();
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).replaceAll("\\u005B\"", "").replaceAll("\"]", "");
        ad.i("Picker", "range is :%s", new Object[] { localObject });
        this.vCS.clear();
        this.vCS.addAll(Arrays.asList(((String)localObject).split("\"|,|\"")));
        continue;
        this.value = ((Map.Entry)localObject).getValue().toString();
      }
    }
    AppMethodBeat.o(123787);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(123788);
    ad.d("Picker", "hide");
    com.tencent.mm.plugin.m.a.c.b.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123785);
        String str = a.this.kEw;
        int i = -1;
        switch (str.hashCode())
        {
        default: 
          switch (i)
          {
          }
          break;
        }
        for (;;)
        {
          AppMethodBeat.o(123785);
          return;
          if (!str.equals("selector")) {
            break;
          }
          i = 0;
          break;
          if (!str.equals("date")) {
            break;
          }
          i = 1;
          break;
          if (!str.equals("time")) {
            break;
          }
          i = 2;
          break;
          if (!str.equals("multiSelector")) {
            break;
          }
          i = 3;
          break;
          if (!str.equals("region")) {
            break;
          }
          i = 4;
          break;
          if (a.this.vCP != null)
          {
            a.this.vCP.hide();
            AppMethodBeat.o(123785);
            return;
            if (a.this.vCO != null)
            {
              a.this.vCO.hide();
              AppMethodBeat.o(123785);
              return;
              if (a.this.vCN != null) {
                a.this.vCN.hide();
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(123788);
  }
  
  public static abstract interface a
  {
    public abstract void n(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.b.a
 * JD-Core Version:    0.7.0.1
 */