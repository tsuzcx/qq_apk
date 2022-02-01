package com.tencent.mm.plugin.gallery.picker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;)V", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "getHolder", "()Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "setHolder", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;)V", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "setLoader", "(Lcom/tencent/mm/loader/Loader;)V", "onItemMediaSelectedListener", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "getOnItemMediaSelectedListener", "()Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "setOnItemMediaSelectedListener", "(Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;)V", "selectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "selectedSet", "Ljava/util/HashSet;", "getSelectedSet", "()Ljava/util/HashSet;", "setSelectedSet", "(Ljava/util/HashSet;)V", "animVisible", "", "v", "Landroid/view/View;", "targetVisibility", "isAnim", "", "disableSelected", "enableSelected", "getLayoutId", "isSelectedEnable", "media", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)Z", "onCovert", "covertType", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;Lcom/tencent/mm/loader/Loader;I)V", "onCreateView", "onSelectItem", "isSelected", "Companion", "OnItemMediaSelectedListener", "plugin-gallery_release"})
public abstract class MediaItemView<T extends GalleryItem.MediaItem>
  extends FrameLayout
{
  public static final a BZe = new a((byte)0);
  private b<?> BWX;
  public HashSet<T> BWY;
  public a BWw;
  public b BXW;
  public d<T> jGC;
  public ArrayList<T> kMn;
  
  public MediaItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MediaItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MediaItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static void e(View paramView, final int paramInt, boolean paramBoolean)
  {
    Log.d("MediaItemView", "[animVisible] isAnim=" + paramBoolean + " view=" + paramView.hashCode());
    if (paramView.getVisibility() == paramInt) {
      return;
    }
    if (!paramBoolean)
    {
      paramView.setVisibility(paramInt);
      paramView.setAlpha(1.0F);
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.cancel();
    }
    paramView = paramView.animate().withStartAction((Runnable)new c(paramView, paramInt)).withEndAction((Runnable)new d(paramView, paramInt)).setDuration(300L);
    if ((paramInt == 4) || (paramInt == 8)) {}
    for (float f = 0.0F;; f = 1.0F)
    {
      paramView.alpha(f).start();
      return;
    }
  }
  
  public void a(b paramb, T paramT, d<T> paramd, int paramInt)
  {
    boolean bool2 = true;
    p.k(paramb, "holder");
    p.k(paramT, "media");
    p.k(paramd, "loader");
    this.BXW = paramb;
    paramb.ez(paramT);
    if ((paramInt == 0) || (paramInt == 1))
    {
      paramd = (CheckBox)paramb.RD(b.e.media_cbx);
      p.j(paramd, "mediaSelectBox");
      paramb = this.BWY;
      if (paramb == null) {
        p.bGy("selectedSet");
      }
      paramd.setChecked(paramb.contains(paramT));
      if ((paramT.getType() == 1) && (paramd.isChecked()))
      {
        bool1 = true;
        paramd.setSelected(bool1);
        paramb = this.BWw;
        if (paramb == null) {
          p.bGy("adapter");
        }
        if (!paramb.BWG) {
          break label386;
        }
        paramb = this.kMn;
        if (paramb == null) {
          p.bGy("selectedList");
        }
        if ((paramb.size() <= 0) || (!paramd.isChecked()) || (paramT.getType() != 1)) {
          break label386;
        }
        paramb = this.kMn;
        if (paramb == null) {
          p.bGy("selectedList");
        }
        paramb = (CharSequence)String.valueOf(paramb.indexOf(paramT) + 1);
        label194:
        paramd.setText(paramb);
      }
    }
    else
    {
      p.k(paramT, "media");
      paramb = this.BWY;
      if (paramb == null) {
        p.bGy("selectedSet");
      }
      if (paramb.size() < 9) {
        break label396;
      }
      paramb = this.BWY;
      if (paramb == null) {
        p.bGy("selectedSet");
      }
      bool1 = paramb.contains(paramT);
      label249:
      if (!bool1) {
        break label500;
      }
      if (paramInt != 2) {
        break label494;
      }
    }
    label386:
    label396:
    label494:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramb = this.BXW;
      if (paramb == null) {
        p.bGy("holder");
      }
      paramb = paramb.RD(b.e.media_select_area);
      paramT = this.BXW;
      if (paramT == null) {
        p.bGy("holder");
      }
      paramT = (CheckBox)paramT.RD(b.e.media_cbx);
      paramd = this.BXW;
      if (paramd == null) {
        p.bGy("holder");
      }
      paramd = paramd.RD(b.e.media_mask_area);
      p.j(paramT, "mediaSelectBox");
      e((View)paramT, 0, bool1);
      p.j(paramd, "mediaMaskArea");
      e(paramd, 4, bool1);
      paramT.setEnabled(true);
      p.j(paramb, "mediaSelectArea");
      paramb.setEnabled(true);
      return;
      bool1 = false;
      break;
      paramb = (CharSequence)"";
      break label194;
      paramb = this.kMn;
      if (paramb == null) {
        p.bGy("selectedList");
      }
      paramb = (GalleryItem.MediaItem)j.lp((List)paramb);
      if (paramb != null)
      {
        if ((paramb.getType() == 2) && (paramb.BVl != paramT.BVl) && (paramT.getType() != 2))
        {
          bool1 = false;
          break label249;
        }
        if ((paramb.getType() == 1) && (paramT.getType() == 2))
        {
          bool1 = false;
          break label249;
        }
        bool1 = true;
        break label249;
      }
      bool1 = true;
      break label249;
    }
    label500:
    if (paramInt == 2) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramb = this.BXW;
      if (paramb == null) {
        p.bGy("holder");
      }
      paramb = paramb.RD(b.e.media_select_area);
      paramT = this.BXW;
      if (paramT == null) {
        p.bGy("holder");
      }
      paramT = (CheckBox)paramT.RD(b.e.media_cbx);
      paramd = this.BXW;
      if (paramd == null) {
        p.bGy("holder");
      }
      paramd = paramd.RD(b.e.media_mask_area);
      p.j(paramT, "mediaSelectBox");
      e((View)paramT, 4, bool1);
      p.j(paramd, "mediaGrepArea");
      e(paramd, 0, bool1);
      paramT.setSelected(false);
      paramT.setChecked(false);
      paramT.setEnabled(false);
      p.j(paramb, "mediaSelectArea");
      paramb.setEnabled(false);
      return;
    }
  }
  
  public final a getAdapter()
  {
    a locala = this.BWw;
    if (locala == null) {
      p.bGy("adapter");
    }
    return locala;
  }
  
  public final b getHolder()
  {
    b localb = this.BXW;
    if (localb == null) {
      p.bGy("holder");
    }
    return localb;
  }
  
  public abstract int getLayoutId();
  
  public final d<T> getLoader()
  {
    d locald = this.jGC;
    if (locald == null) {
      p.bGy("loader");
    }
    return locald;
  }
  
  public final b<?> getOnItemMediaSelectedListener()
  {
    return this.BWX;
  }
  
  public final ArrayList<T> getSelectedList()
  {
    ArrayList localArrayList = this.kMn;
    if (localArrayList == null) {
      p.bGy("selectedList");
    }
    return localArrayList;
  }
  
  public final HashSet<T> getSelectedSet()
  {
    HashSet localHashSet = this.BWY;
    if (localHashSet == null) {
      p.bGy("selectedSet");
    }
    return localHashSet;
  }
  
  public final void rT(boolean paramBoolean)
  {
    Object localObject = this.BXW;
    if (localObject == null) {
      p.bGy("holder");
    }
    localObject = (CheckBox)((b)localObject).RD(b.e.media_cbx);
    p.j(localObject, "mediaSelectBox");
    if (((CheckBox)localObject).isEnabled()) {
      ((CheckBox)localObject).setChecked(paramBoolean);
    }
  }
  
  public final void setAdapter(a parama)
  {
    p.k(parama, "<set-?>");
    this.BWw = parama;
  }
  
  public final void setHolder(b paramb)
  {
    p.k(paramb, "<set-?>");
    this.BXW = paramb;
  }
  
  public final void setLoader(d<T> paramd)
  {
    p.k(paramd, "<set-?>");
    this.jGC = paramd;
  }
  
  public final void setOnItemMediaSelectedListener(b<?> paramb)
  {
    this.BWX = paramb;
  }
  
  public final void setSelectedList(ArrayList<T> paramArrayList)
  {
    p.k(paramArrayList, "<set-?>");
    this.kMn = paramArrayList;
  }
  
  public final void setSelectedSet(HashSet<T> paramHashSet)
  {
    p.k(paramHashSet, "<set-?>");
    this.BWY = paramHashSet;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$Companion;", "", "()V", "TAG", "", "plugin-gallery_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "E", "", "onMediaSelected", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;Ljava/lang/Object;)V", "onMediaUnSelected", "plugin-gallery_release"})
  public static abstract interface b<E>
  {
    public abstract void a(b paramb, E paramE);
    
    public abstract void b(b paramb, E paramE);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "run"})
  static final class c
    implements Runnable
  {
    c(View paramView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(164949);
      this.jLx.setVisibility(0);
      View localView = this.jLx;
      if ((paramInt == 4) || (paramInt == 8)) {}
      for (float f = 1.0F;; f = 0.0F)
      {
        localView.setAlpha(f);
        AppMethodBeat.o(164949);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "run"})
  static final class d
    implements Runnable
  {
    d(View paramView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(164950);
      this.jLx.setVisibility(paramInt);
      this.jLx.setAlpha(1.0F);
      AppMethodBeat.o(164950);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  public static final class e
    implements CompoundButton.OnCheckedChangeListener
  {
    public e(MediaItemView paramMediaItemView, HashSet paramHashSet, ArrayList paramArrayList, d paramd) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(164951);
      paramCompoundButton = (GalleryItem.MediaItem)this.BZg.getHolder().ihX();
      if (paramBoolean != this.BZh.contains(paramCompoundButton))
      {
        if (paramBoolean)
        {
          if (this.BZh.add(paramCompoundButton)) {
            this.BZi.add(paramCompoundButton);
          }
          localObject1 = this.BZg;
          localObject2 = this.BZg.getHolder();
          p.j(paramCompoundButton, "media");
          MediaItemView.a((MediaItemView)localObject1, (b)localObject2, paramCompoundButton, this.BZj);
          paramCompoundButton = this.BZg.getOnItemMediaSelectedListener();
          if (paramCompoundButton != null)
          {
            localObject1 = this.BZg.getHolder();
            localObject2 = this.BZg.getHolder().ihX();
            p.j(localObject2, "holder.getAssociatedObject()");
            paramCompoundButton.b((b)localObject1, localObject2);
            AppMethodBeat.o(164951);
            return;
          }
          AppMethodBeat.o(164951);
          return;
        }
        this.BZh.remove(paramCompoundButton);
        this.BZi.remove(paramCompoundButton);
        Object localObject1 = this.BZg;
        Object localObject2 = this.BZg.getHolder();
        p.j(paramCompoundButton, "media");
        MediaItemView.a((MediaItemView)localObject1, (b)localObject2, paramCompoundButton, this.BZj);
        paramCompoundButton = this.BZg.getOnItemMediaSelectedListener();
        if (paramCompoundButton != null)
        {
          localObject1 = this.BZg.getHolder();
          localObject2 = this.BZg.getHolder().ihX();
          p.j(localObject2, "holder.getAssociatedObject()");
          paramCompoundButton.a((b)localObject1, localObject2);
          AppMethodBeat.o(164951);
          return;
        }
      }
      AppMethodBeat.o(164951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MediaItemView
 * JD-Core Version:    0.7.0.1
 */