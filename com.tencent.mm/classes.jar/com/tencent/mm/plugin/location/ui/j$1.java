package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.map.a.g;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class j$1
  extends ah
{
  j$1(j paramj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 9: 
      do
      {
        do
        {
          Object localObject;
          do
          {
            do
            {
              return;
              this.lGz.NI.setText(this.lGz.lGy);
              return;
              y.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", new Object[] { Boolean.valueOf(this.lGz.lGd), Boolean.valueOf(this.lGz.lGx) });
            } while ((this.lGz.lGd) || (this.lGz.lGx));
            localObject = this.lGz;
            ((j)localObject).NI.setTextColor(((j)localObject).lGu);
            ((j)localObject).NI.invalidate();
            int i = ((Integer)paramMessage.obj).intValue();
            if (i == 0)
            {
              this.lGz.NI.setText(this.lGz.context.getString(a.h.track_none_contact_num));
              return;
            }
            this.lGz.NI.setText(this.lGz.context.getResources().getQuantityString(a.g.track_contact_num, i, new Object[] { Integer.valueOf(i) }));
            return;
            if ((this.lGz.lGx) || (this.lGz.lGd))
            {
              removeMessages(3);
              localObject = Message.obtain();
              ((Message)localObject).what = 3;
              ((Message)localObject).obj = paramMessage.obj;
              sendMessage((Message)localObject);
              return;
            }
            this.lGz.lGy = this.lGz.NI.getText().toString();
            j.a(this.lGz);
            paramMessage = r.gV((String)paramMessage.obj);
            this.lGz.NI.setText(this.lGz.context.getString(a.h.track_somebody_enter, new Object[] { paramMessage }));
          } while ((!this.lGz.lGd) && (!this.lGz.lGx));
          j.b(this.lGz);
          return;
          if ((this.lGz.lGx) || (this.lGz.lGd))
          {
            removeMessages(4);
            localObject = Message.obtain();
            ((Message)localObject).what = 4;
            ((Message)localObject).obj = paramMessage.obj;
            sendMessage((Message)localObject);
            return;
          }
          this.lGz.lGy = this.lGz.NI.getText().toString();
          j.a(this.lGz);
          paramMessage = r.gV((String)paramMessage.obj);
          this.lGz.NI.setText(this.lGz.context.getString(a.h.track_somebody_exit, new Object[] { paramMessage }));
        } while ((!this.lGz.lGd) && (!this.lGz.lGx));
        j.b(this.lGz);
        return;
        this.lGz.lGx = true;
        this.lGz.lGd = false;
        j.a(this.lGz);
        paramMessage = r.gV((String)paramMessage.obj);
        this.lGz.NI.setText(this.lGz.context.getString(a.h.track_somebody_saying, new Object[] { paramMessage }));
        return;
        this.lGz.lGd = true;
        this.lGz.lGx = false;
        j.a(this.lGz);
        this.lGz.NI.setText(this.lGz.context.getString(a.h.track_self_saying));
        return;
        this.lGz.lGd = false;
      } while (this.lGz.lGx);
      this.lGz.hi(true);
      return;
    case 7: 
      this.lGz.lGx = true;
      paramMessage = this.lGz;
      paramMessage.NI.setTextColor(paramMessage.lGv);
      paramMessage.NI.invalidate();
      this.lGz.NI.setText(this.lGz.context.getString(a.h.track_talk_conflict));
      this.lGz.lGy = this.lGz.NI.getText().toString();
      j.b(this.lGz);
      return;
    case 8: 
      paramMessage = this.lGz;
      paramMessage.NI.setTextColor(paramMessage.lGw);
      paramMessage.NI.invalidate();
      this.lGz.NI.setText(this.lGz.context.getString(a.h.track_talk_preparing));
      return;
    }
    this.lGz.lGx = false;
    this.lGz.hi(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.j.1
 * JD-Core Version:    0.7.0.1
 */