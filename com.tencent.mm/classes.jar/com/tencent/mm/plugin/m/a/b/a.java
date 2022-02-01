package com.tencent.mm.plugin.m.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  String kjy;
  d uAk;
  com.tencent.mm.ui.widget.picker.b uAl;
  c uAm;
  String uAn;
  String uAo;
  ArrayList<String> uAp;
  public a.a uAq;
  String value;
  
  public a(Map<String, ?> paramMap)
  {
    AppMethodBeat.i(123786);
    this.uAp = new ArrayList();
    this.kjy = "selector";
    ag(paramMap);
    AppMethodBeat.o(123786);
  }
  
  private void ag(Map<String, ?> paramMap)
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
          this.kjy = ((Map.Entry)localObject).getValue().toString();
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
      this.uAn = ((Map.Entry)localObject).getValue().toString();
      continue;
      this.uAo = ((Map.Entry)localObject).getValue().toString();
      continue;
      localObject = ((Map.Entry)localObject).getValue().toString();
      if (!bs.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).replaceAll("\\u005B\"", "").replaceAll("\"]", "");
        ac.i("Picker", "range is :%s", new Object[] { localObject });
        this.uAp.clear();
        this.uAp.addAll(Arrays.asList(((String)localObject).split("\"|,|\"")));
        continue;
        this.value = ((Map.Entry)localObject).getValue().toString();
      }
    }
    AppMethodBeat.o(123787);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(123788);
    ac.d("Picker", "hide");
    com.tencent.mm.plugin.m.a.c.b.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123785);
        String str = a.this.kjy;
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
          if (a.this.uAm != null)
          {
            a.this.uAm.hide();
            AppMethodBeat.o(123785);
            return;
            if (a.this.uAl != null)
            {
              a.this.uAl.hide();
              AppMethodBeat.o(123785);
              return;
              if (a.this.uAk != null) {
                a.this.uAk.hide();
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(123788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.b.a
 * JD-Core Version:    0.7.0.1
 */