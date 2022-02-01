package com.tencent.mm.plugin.forcenotify.c;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/model/FinderBaseMsgItem;", "Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;", "id", "", "title", "desc", "avatar", "Landroid/graphics/Bitmap;", "authIconType", "", "showTimeMs", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;IJ)V", "getAuthIconType", "()I", "setAuthIconType", "(I)V", "getAvatar", "()Landroid/graphics/Bitmap;", "setAvatar", "(Landroid/graphics/Bitmap;)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getItemId", "getItemType", "onBindView", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "", "payloads", "", "", "onFullScreenClick", "view", "Landroid/view/View;", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e
  extends a
{
  private Bitmap Hom;
  private int authIconType;
  private String desc;
  private String title;
  
  public e(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt, long paramLong)
  {
    super(paramString1, paramLong);
    this.title = paramString2;
    this.desc = paramString3;
    this.Hom = paramBitmap;
    this.authIconType = paramInt;
  }
  
  public abstract void a(j paramj);
  
  public final long bZA()
  {
    return 0L;
  }
  
  public final int bZB()
  {
    return 2;
  }
  
  public final Bitmap fwJ()
  {
    return this.Hom;
  }
  
  public final int fwK()
  {
    return this.authIconType;
  }
  
  public final String getDesc()
  {
    return this.desc;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final void hp(View paramView)
  {
    s.u(paramView, "view");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.e
 * JD-Core Version:    0.7.0.1
 */