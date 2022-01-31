package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class j$1
  extends ak
{
  j$1(j paramj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(113521);
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113521);
      return;
      this.odM.Nx.setText(this.odM.odL);
      AppMethodBeat.o(113521);
      return;
      ab.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", new Object[] { Boolean.valueOf(this.odM.odq), Boolean.valueOf(this.odM.odK) });
      if ((!this.odM.odq) && (!this.odM.odK))
      {
        Object localObject = this.odM;
        ((j)localObject).Nx.setTextColor(((j)localObject).odH);
        ((j)localObject).Nx.invalidate();
        int i = ((Integer)paramMessage.obj).intValue();
        if (i == 0)
        {
          this.odM.Nx.setText(this.odM.context.getString(2131304382));
          AppMethodBeat.o(113521);
          return;
        }
        this.odM.Nx.setText(this.odM.context.getResources().getQuantityString(2131361825, i, new Object[] { Integer.valueOf(i) }));
        AppMethodBeat.o(113521);
        return;
        if ((this.odM.odK) || (this.odM.odq))
        {
          removeMessages(3);
          localObject = Message.obtain();
          ((Message)localObject).what = 3;
          ((Message)localObject).obj = paramMessage.obj;
          sendMessage((Message)localObject);
          AppMethodBeat.o(113521);
          return;
        }
        this.odM.odL = this.odM.Nx.getText().toString();
        j.a(this.odM);
        paramMessage = s.nE((String)paramMessage.obj);
        this.odM.Nx.setText(this.odM.context.getString(2131304388, new Object[] { paramMessage }));
        if ((this.odM.odq) || (this.odM.odK))
        {
          j.b(this.odM);
          AppMethodBeat.o(113521);
          return;
          if ((this.odM.odK) || (this.odM.odq))
          {
            removeMessages(4);
            localObject = Message.obtain();
            ((Message)localObject).what = 4;
            ((Message)localObject).obj = paramMessage.obj;
            sendMessage((Message)localObject);
            AppMethodBeat.o(113521);
            return;
          }
          this.odM.odL = this.odM.Nx.getText().toString();
          j.a(this.odM);
          paramMessage = s.nE((String)paramMessage.obj);
          this.odM.Nx.setText(this.odM.context.getString(2131304389, new Object[] { paramMessage }));
          if ((this.odM.odq) || (this.odM.odK))
          {
            j.b(this.odM);
            AppMethodBeat.o(113521);
            return;
            this.odM.odK = true;
            this.odM.odq = false;
            j.a(this.odM);
            paramMessage = s.nE((String)paramMessage.obj);
            this.odM.Nx.setText(this.odM.context.getString(2131304390, new Object[] { paramMessage }));
            AppMethodBeat.o(113521);
            return;
            this.odM.odq = true;
            this.odM.odK = false;
            j.a(this.odM);
            this.odM.Nx.setText(this.odM.context.getString(2131304387));
            AppMethodBeat.o(113521);
            return;
            this.odM.odq = false;
            if (!this.odM.odK)
            {
              this.odM.iS(true);
              AppMethodBeat.o(113521);
              return;
              this.odM.odK = true;
              paramMessage = this.odM;
              paramMessage.Nx.setTextColor(paramMessage.odI);
              paramMessage.Nx.invalidate();
              this.odM.Nx.setText(this.odM.context.getString(2131304392));
              this.odM.odL = this.odM.Nx.getText().toString();
              j.b(this.odM);
              AppMethodBeat.o(113521);
              return;
              paramMessage = this.odM;
              paramMessage.Nx.setTextColor(paramMessage.odJ);
              paramMessage.Nx.invalidate();
              this.odM.Nx.setText(this.odM.context.getString(2131304393));
              AppMethodBeat.o(113521);
              return;
              this.odM.odK = false;
              this.odM.iS(false);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.j.1
 * JD-Core Version:    0.7.0.1
 */