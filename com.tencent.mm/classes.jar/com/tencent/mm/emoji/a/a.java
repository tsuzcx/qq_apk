package com.tencent.mm.emoji.a;

import android.graphics.RectF;
import android.view.View;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "", "getItemEmojiRect", "Landroid/graphics/RectF;", "msgId", "", "animKey", "", "getItemTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "itemView", "Landroid/view/View;", "getMsgAnimKey", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getParentView", "getViewByMsgId", "Companion", "plugin-emojisdk_release"})
public abstract interface a
{
  public static final a.a jFJ = a.a.jFK;
  
  public abstract View Fl(long paramLong);
  
  public abstract RectF a(long paramLong, String paramString);
  
  public abstract MMNeat7extView c(View paramView, String paramString);
  
  public abstract List<String> q(ca paramca);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */