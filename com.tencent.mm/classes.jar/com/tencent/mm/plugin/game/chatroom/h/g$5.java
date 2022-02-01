package com.tencent.mm.plugin.game.chatroom.h;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.Color;
import com.tencent.mm.plugin.game.autogen.chatroom.TagInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.UserRole;
import com.tencent.mm.plugin.game.chatroom.b.b.a;
import com.tencent.mm.plugin.game.chatroom.b.c;
import com.tencent.mm.plugin.game.chatroom.e;
import com.tencent.mm.plugin.game.chatroom.f.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

final class g$5
  implements b.a
{
  g$5(g paramg) {}
  
  public final void ac(final Map<String, c> paramMap)
  {
    AppMethodBeat.i(211386);
    if ((paramMap != null) && (paramMap.containsKey(this.Cvu.Cvf.from_username)))
    {
      paramMap = (c)paramMap.get(this.Cvu.Cvf.from_username);
      g.a(this.Cvu, paramMap);
      g.c(this.Cvu).post(new Runnable()
      {
        public final void run()
        {
          int k = 0;
          AppMethodBeat.i(210751);
          g.c(g.5.this.Cvu).setText(l.c(g.5.this.Cvu.mContext, paramMap.getNickName()));
          Object localObject = paramMap.evv();
          label237:
          int j;
          if (localObject != null)
          {
            g.d(g.5.this.Cvu).setVisibility(0);
            String str = g.5.this.Cvu.mContext.getString(f.h.Cut, new Object[] { ((TagInfo)localObject).desc });
            g.d(g.5.this.Cvu).setText(l.c(g.5.this.Cvu.mContext, str));
            localObject = ((TagInfo)localObject).color;
            if (localObject != null)
            {
              i = e.aIQ(Util.nullAsNil(((Color)localObject).dark_color));
              if (i != -1) {
                g.d(g.5.this.Cvu).setTextColor(i);
              }
            }
            localObject = paramMap.evw();
            if ((localObject == null) || (Util.isNullOrNil(((UserRole)localObject).desc))) {
              break label357;
            }
            g.e(g.5.this.Cvu).setText(((UserRole)localObject).desc);
            i = e.aIQ(Util.nullAsNil(((UserRole)localObject).word_color));
            if (i != -1) {
              break label338;
            }
            i = 0;
            int m = e.aIQ(Util.nullAsNil(((UserRole)localObject).background_color));
            if (m == -1) {
              break label357;
            }
            localObject = (GradientDrawable)g.e(g.5.this.Cvu).getBackground();
            j = i;
            if (localObject != null)
            {
              ((GradientDrawable)localObject).setColor(m);
              j = i;
            }
            label290:
            localObject = g.e(g.5.this.Cvu);
            if (j == 0) {
              break label362;
            }
          }
          label338:
          label357:
          label362:
          for (int i = k;; i = 8)
          {
            ((TextView)localObject).setVisibility(i);
            AppMethodBeat.o(210751);
            return;
            g.d(g.5.this.Cvu).setVisibility(8);
            break;
            g.e(g.5.this.Cvu).setTextColor(i);
            i = 1;
            break label237;
            j = 0;
            break label290;
          }
        }
      });
    }
    AppMethodBeat.o(211386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.g.5
 * JD-Core Version:    0.7.0.1
 */