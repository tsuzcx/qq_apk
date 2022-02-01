package com.tencent.mm.emoji.a;

import android.graphics.RectF;
import android.view.View;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "", "getItemEmojiRect", "Landroid/graphics/RectF;", "msgId", "", "animKey", "", "getItemTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "itemView", "Landroid/view/View;", "getMsgAnimKey", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getParentView", "getViewByMsgId", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public static final a.a mfw = a.a.mfx;
  
  public abstract RectF b(long paramLong, String paramString);
  
  public abstract MMNeat7extView c(View paramView, String paramString);
  
  public abstract View ht(long paramLong);
  
  public abstract List<String> q(cc paramcc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */