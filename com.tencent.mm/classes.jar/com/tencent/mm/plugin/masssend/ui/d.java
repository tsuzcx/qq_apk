package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class d
  implements j
{
  private Context context;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean bhC()
  {
    return false;
  }
  
  public final boolean bhD()
  {
    return false;
  }
  
  public final void bhE() {}
  
  public final void m(EmojiInfo paramEmojiInfo)
  {
    Toast.makeText(this.context, this.context.getString(R.l.mass_send_custom_emoji_not_support), 0).show();
  }
  
  public final void n(EmojiInfo paramEmojiInfo)
  {
    Toast.makeText(this.context, this.context.getString(R.l.mass_send_custom_emoji_not_support), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.d
 * JD-Core Version:    0.7.0.1
 */