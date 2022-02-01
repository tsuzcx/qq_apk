package com.tencent.mm.plugin.m.a.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
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
    Object localObject = this.trY.jIX;
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
      this.trY.trT = new c(this.val$context, this.trY.trW);
      i = bt.getInt(this.trY.value, 0);
      if ((i >= 0) && (i < this.trY.trW.size())) {
        this.trY.trT.aaR(i);
      }
      this.trY.trT.HIW = new c.a()
      {
        public final void onResult(boolean paramAnonymousBoolean, Object paramAnonymousObject1, Object paramAnonymousObject2)
        {
          AppMethodBeat.i(123781);
          a.1.this.trY.hide();
          if (a.1.this.trY.trX != null)
          {
            paramAnonymousObject2 = a.1.this.trY.trX;
            if (!paramAnonymousBoolean) {
              break label74;
            }
          }
          label74:
          for (paramAnonymousObject1 = String.valueOf(a.1.this.trY.trT.ffZ());; paramAnonymousObject1 = "")
          {
            paramAnonymousObject2.q(paramAnonymousBoolean, paramAnonymousObject1);
            AppMethodBeat.o(123781);
            return;
          }
        }
      };
      this.trY.trT.show();
      AppMethodBeat.o(123784);
      return;
      this.trY.trS = new b(this.val$context);
      int j;
      int k;
      if (!bt.isNullOrNil(this.trY.trU))
      {
        localObject = this.trY.trU.split("-");
        if (localObject.length == 3)
        {
          i = bt.getInt(localObject[0], 0);
          j = bt.a(Integer.valueOf(bt.aGh(localObject[1])), 1);
          k = bt.getInt(localObject[2], 0);
          this.trY.trS.aN(i, j, k);
        }
      }
      if (!bt.isNullOrNil(this.trY.trV))
      {
        localObject = this.trY.trV.split("-");
        if (localObject.length == 3)
        {
          i = bt.getInt(localObject[0], 0);
          j = bt.a(Integer.valueOf(bt.aGh(localObject[1])), 1);
          k = bt.getInt(localObject[2], 0);
          this.trY.trS.aO(i, j, k);
        }
      }
      if (!bt.isNullOrNil(this.trY.value))
      {
        localObject = this.trY.value.split("-");
        if (localObject.length == 3)
        {
          i = bt.getInt(localObject[0], 0);
          j = bt.a(Integer.valueOf(bt.aGh(localObject[1])), 1);
          k = bt.getInt(localObject[2], 0);
          this.trY.trS.aM(i, j, k);
        }
      }
      this.trY.trS.HIQ = new b.a()
      {
        public final void onResult(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(123782);
          a.1.this.trY.hide();
          a.a locala;
          if (a.1.this.trY.trX != null)
          {
            locala = a.1.this.trY.trX;
            if (!paramAnonymousBoolean) {
              break label93;
            }
          }
          label93:
          for (String str = String.format("%04d-%02d-%02d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });; str = "")
          {
            locala.q(paramAnonymousBoolean, str);
            AppMethodBeat.o(123782);
            return;
          }
        }
      };
      this.trY.trS.show();
      AppMethodBeat.o(123784);
      return;
      this.trY.trR = new d(this.val$context);
      if (!bt.isNullOrNil(this.trY.trU))
      {
        localObject = this.trY.trU.split(":");
        if (localObject.length == 2)
        {
          i = bt.a(Integer.valueOf(bt.aGh(localObject[0])), 0);
          j = bt.a(Integer.valueOf(bt.aGh(localObject[1])), 0);
          this.trY.trR.setMinTime(i, j);
        }
      }
      if (!bt.isNullOrNil(this.trY.trV))
      {
        localObject = this.trY.trV.split(":");
        if (localObject.length == 2)
        {
          i = bt.a(Integer.valueOf(bt.aGh(localObject[0])), 0);
          j = bt.a(Integer.valueOf(bt.aGh(localObject[1])), 0);
          this.trY.trR.setMaxTime(i, j);
        }
      }
      if (!bt.isNullOrNil(this.trY.value))
      {
        localObject = this.trY.value.split(":");
        if (localObject.length == 2)
        {
          i = bt.a(Integer.valueOf(bt.aGh(localObject[0])), 0);
          j = bt.a(Integer.valueOf(bt.aGh(localObject[1])), 0);
          this.trY.trR.jM(i, j);
        }
      }
      this.trY.trR.HJc = new d.a()
      {
        public final void a(boolean paramAnonymousBoolean, Object paramAnonymousObject)
        {
          AppMethodBeat.i(123783);
          a.1.this.trY.hide();
          a.a locala;
          if (a.1.this.trY.trX != null)
          {
            locala = a.1.this.trY.trX;
            if (!paramAnonymousBoolean) {
              break label62;
            }
          }
          label62:
          for (paramAnonymousObject = String.valueOf(paramAnonymousObject);; paramAnonymousObject = "")
          {
            locala.q(paramAnonymousBoolean, paramAnonymousObject);
            AppMethodBeat.o(123783);
            return;
          }
        }
      };
      this.trY.trR.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.b.a.1
 * JD-Core Version:    0.7.0.1
 */