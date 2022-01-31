package com.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a
  extends Handler
{
  private final int blI = 2001;
  private final int blJ = 2002;
  private final int blK = 2003;
  private final int blL = 2004;
  private final int blM = 2005;
  private final int blN = 2006;
  
  public a$a(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = 2005;
    AppMethodBeat.i(118245);
    new StringBuilder("what = ").append(paramMessage.what);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(118245);
      return;
      if (this.blH.blE != null)
      {
        this.blH.blE.sZ();
        AppMethodBeat.o(118245);
        return;
        if (this.blH.blE != null)
        {
          this.blH.blE.sZ();
          AppMethodBeat.o(118245);
          return;
          if (this.blH.blE != null)
          {
            this.blH.blE.sZ();
            AppMethodBeat.o(118245);
            return;
            if (this.blH.blE != null) {
              this.blH.blE.bC(0, paramMessage.arg1);
            }
            removeMessages(8);
            AppMethodBeat.o(118245);
            return;
            if (this.blH.blE != null) {
              switch (paramMessage.arg1)
              {
              default: 
                i = 2020;
              }
            }
            for (;;)
            {
              this.blH.blE.bC(i, -1);
              removeMessages(8);
              AppMethodBeat.o(118245);
              return;
              i = 2002;
              continue;
              i = 2003;
              continue;
              i = 2000;
              continue;
              i = 2006;
            }
            if (this.blH.blE != null) {
              this.blH.blE.bC(2001, -1);
            }
            removeMessages(8);
            this.blH.abort();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */