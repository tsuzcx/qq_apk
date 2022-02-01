package com.tencent.mm.plugin.m.a.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.ui.widget.picker.d;
import com.tencent.mm.ui.widget.picker.d.a;
import java.util.ArrayList;

public final class a$1
  implements Runnable
{
  public a$1(a parama, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(123784);
    Object localObject = this.uAr.kjy;
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(123784);
      return;
      if (!((String)localObject).equals("selector")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject).equals("date")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject).equals("time")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject).equals("multiSelector")) {
        break;
      }
      i = 3;
      break;
      if (!((String)localObject).equals("region")) {
        break;
      }
      i = 4;
      break;
      this.uAr.uAm = new c(this.val$context, this.uAr.uAp);
      i = bs.getInt(this.uAr.value, 0);
      if ((i >= 0) && (i < this.uAr.uAp.size())) {
        this.uAr.uAm.adc(i);
      }
      this.uAr.uAm.Jjt = new c.a()
      {
        public final void onResult(boolean paramAnonymousBoolean, Object paramAnonymousObject1, Object paramAnonymousObject2)
        {
          AppMethodBeat.i(123781);
          a.1.this.uAr.hide();
          if (a.1.this.uAr.uAq != null)
          {
            paramAnonymousObject2 = a.1.this.uAr.uAq;
            if (!paramAnonymousBoolean) {
              break label74;
            }
          }
          label74:
          for (paramAnonymousObject1 = String.valueOf(a.1.this.uAr.uAm.fvY());; paramAnonymousObject1 = "")
          {
            paramAnonymousObject2.r(paramAnonymousBoolean, paramAnonymousObject1);
            AppMethodBeat.o(123781);
            return;
          }
        }
      };
      this.uAr.uAm.show();
      AppMethodBeat.o(123784);
      return;
      this.uAr.uAl = new b(this.val$context);
      int j;
      int k;
      if (!bs.isNullOrNil(this.uAr.uAn))
      {
        localObject = this.uAr.uAn.split("-");
        if (localObject.length == 3)
        {
          i = bs.getInt(localObject[0], 0);
          j = bs.a(Integer.valueOf(bs.aLy(localObject[1])), 1);
          k = bs.getInt(localObject[2], 0);
          this.uAr.uAl.aP(i, j, k);
        }
      }
      if (!bs.isNullOrNil(this.uAr.uAo))
      {
        localObject = this.uAr.uAo.split("-");
        if (localObject.length == 3)
        {
          i = bs.getInt(localObject[0], 0);
          j = bs.a(Integer.valueOf(bs.aLy(localObject[1])), 1);
          k = bs.getInt(localObject[2], 0);
          this.uAr.uAl.aQ(i, j, k);
        }
      }
      if (!bs.isNullOrNil(this.uAr.value))
      {
        localObject = this.uAr.value.split("-");
        if (localObject.length == 3)
        {
          i = bs.getInt(localObject[0], 0);
          j = bs.a(Integer.valueOf(bs.aLy(localObject[1])), 1);
          k = bs.getInt(localObject[2], 0);
          this.uAr.uAl.aO(i, j, k);
        }
      }
      this.uAr.uAl.Jjn = new b.a()
      {
        public final void onResult(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(123782);
          a.1.this.uAr.hide();
          a.a locala;
          if (a.1.this.uAr.uAq != null)
          {
            locala = a.1.this.uAr.uAq;
            if (!paramAnonymousBoolean) {
              break label93;
            }
          }
          label93:
          for (String str = String.format("%04d-%02d-%02d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });; str = "")
          {
            locala.r(paramAnonymousBoolean, str);
            AppMethodBeat.o(123782);
            return;
          }
        }
      };
      this.uAr.uAl.show();
      AppMethodBeat.o(123784);
      return;
      this.uAr.uAk = new d(this.val$context);
      if (!bs.isNullOrNil(this.uAr.uAn))
      {
        localObject = this.uAr.uAn.split(":");
        if (localObject.length == 2)
        {
          i = bs.a(Integer.valueOf(bs.aLy(localObject[0])), 0);
          j = bs.a(Integer.valueOf(bs.aLy(localObject[1])), 0);
          this.uAr.uAk.setMinTime(i, j);
        }
      }
      if (!bs.isNullOrNil(this.uAr.uAo))
      {
        localObject = this.uAr.uAo.split(":");
        if (localObject.length == 2)
        {
          i = bs.a(Integer.valueOf(bs.aLy(localObject[0])), 0);
          j = bs.a(Integer.valueOf(bs.aLy(localObject[1])), 0);
          this.uAr.uAk.setMaxTime(i, j);
        }
      }
      if (!bs.isNullOrNil(this.uAr.value))
      {
        localObject = this.uAr.value.split(":");
        if (localObject.length == 2)
        {
          i = bs.a(Integer.valueOf(bs.aLy(localObject[0])), 0);
          j = bs.a(Integer.valueOf(bs.aLy(localObject[1])), 0);
          this.uAr.uAk.jY(i, j);
        }
      }
      this.uAr.uAk.Jjz = new d.a()
      {
        public final void a(boolean paramAnonymousBoolean, Object paramAnonymousObject)
        {
          AppMethodBeat.i(123783);
          a.1.this.uAr.hide();
          a.a locala;
          if (a.1.this.uAr.uAq != null)
          {
            locala = a.1.this.uAr.uAq;
            if (!paramAnonymousBoolean) {
              break label62;
            }
          }
          label62:
          for (paramAnonymousObject = String.valueOf(paramAnonymousObject);; paramAnonymousObject = "")
          {
            locala.r(paramAnonymousBoolean, paramAnonymousObject);
            AppMethodBeat.o(123783);
            return;
          }
        }
      };
      this.uAr.uAk.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.b.a.1
 * JD-Core Version:    0.7.0.1
 */