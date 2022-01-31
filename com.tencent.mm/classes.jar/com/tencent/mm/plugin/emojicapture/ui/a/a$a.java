package com.tencent.mm.plugin.emojicapture.ui.a;

import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.emojicapture.model.a.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "plugin-emojicapture_release"})
public abstract class a$a
  extends RecyclerView.v
{
  final TextView gJk;
  final ImageView iTH;
  
  public a$a(View paramView)
  {
    super(localObject);
    this.iTH = ((ImageView)localObject.findViewById(2131823556));
    this.gJk = ((TextView)localObject.findViewById(2131823557));
    localObject.setOnClickListener((View.OnClickListener)new a.a.1(this, localObject));
  }
  
  public abstract void b(b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.a.a
 * JD-Core Version:    0.7.0.1
 */