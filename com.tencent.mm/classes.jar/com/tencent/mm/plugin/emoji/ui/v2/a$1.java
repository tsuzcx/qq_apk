package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.sdk.platformtools.ah;

final class a$1
  extends ah
{
  a$1(a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    a locala = this.jgg;
    switch (paramMessage.what)
    {
    }
    do
    {
      String str;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (locala.iYq == null);
              locala.iYq.notifyDataSetChanged();
              return;
            } while ((locala.iYq == null) || (paramMessage.getData() == null));
            str = paramMessage.getData().getString("product_id");
          } while (str == null);
          i = paramMessage.getData().getInt("progress");
          locala.iYq.bu(str, i);
          return;
        } while ((locala.iYq == null) || (paramMessage.getData() == null));
        str = paramMessage.getData().getString("product_id");
      } while (str == null);
      int i = paramMessage.getData().getInt("status");
      locala.iYq.bt(str, i);
      return;
    } while (locala.jbh == null);
    locala.jbh.aJr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.a.1
 * JD-Core Version:    0.7.0.1
 */