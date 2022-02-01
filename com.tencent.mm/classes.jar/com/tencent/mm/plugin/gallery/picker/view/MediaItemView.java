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
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.picker.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.a.b;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;)V", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "getHolder", "()Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "setHolder", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;)V", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "setLoader", "(Lcom/tencent/mm/loader/Loader;)V", "onItemMediaSelectedListener", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "getOnItemMediaSelectedListener", "()Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "setOnItemMediaSelectedListener", "(Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;)V", "selectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "selectedSet", "Ljava/util/HashSet;", "getSelectedSet", "()Ljava/util/HashSet;", "setSelectedSet", "(Ljava/util/HashSet;)V", "animVisible", "", "v", "Landroid/view/View;", "targetVisibility", "isAnim", "", "disableSelected", "enableSelected", "getLayoutId", "isSelectedEnable", "media", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)Z", "onCovert", "covertType", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;Lcom/tencent/mm/loader/Loader;I)V", "onCreateView", "onSelectItem", "isSelected", "Companion", "OnItemMediaSelectedListener", "plugin-gallery_release"})
public abstract class MediaItemView<T extends GalleryItem.MediaItem>
  extends FrameLayout
{
  public static final a rFj = new a((byte)0);
  public d<T> fLh;
  private b<?> rCY;
  public HashSet<T> rCZ;
  public a rCx;
  public b rDZ;
  public ArrayList<T> rDa;
  
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
  
  private static void d(View paramView, final int paramInt, boolean paramBoolean)
  {
    ad.d("MediaItemView", "[animVisible] isAnim=" + paramBoolean + " view=" + paramView.hashCode());
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
    k.h(paramb, "holder");
    k.h(paramT, "media");
    k.h(paramd, "loader");
    this.rDZ = paramb;
    paramb.ei(paramT);
    if ((paramInt == 0) || (paramInt == 1))
    {
      paramd = (CheckBox)paramb.abq(2131302204);
      k.g(paramd, "mediaSelectBox");
      paramb = this.rCZ;
      if (paramb == null) {
        k.aPZ("selectedSet");
      }
      paramd.setChecked(paramb.contains(paramT));
      if ((paramT.getType() == 1) && (paramd.isChecked()))
      {
        bool1 = true;
        paramd.setSelected(bool1);
        paramb = this.rCx;
        if (paramb == null) {
          k.aPZ("adapter");
        }
        if (!paramb.rCH) {
          break label384;
        }
        paramb = this.rDa;
        if (paramb == null) {
          k.aPZ("selectedList");
        }
        if ((paramb.size() <= 0) || (!paramd.isChecked()) || (paramT.getType() != 1)) {
          break label384;
        }
        paramb = this.rDa;
        if (paramb == null) {
          k.aPZ("selectedList");
        }
        paramb = (CharSequence)String.valueOf(paramb.indexOf(paramT) + 1);
        label193:
        paramd.setText(paramb);
      }
    }
    else
    {
      k.h(paramT, "media");
      paramb = this.rCZ;
      if (paramb == null) {
        k.aPZ("selectedSet");
      }
      if (paramb.size() < 9) {
        break label394;
      }
      paramb = this.rCZ;
      if (paramb == null) {
        k.aPZ("selectedSet");
      }
      bool1 = paramb.contains(paramT);
      label248:
      if (!bool1) {
        break label498;
      }
      if (paramInt != 2) {
        break label492;
      }
    }
    label384:
    label394:
    label492:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramb = this.rDZ;
      if (paramb == null) {
        k.aPZ("holder");
      }
      paramb = paramb.abq(2131302220);
      paramT = this.rDZ;
      if (paramT == null) {
        k.aPZ("holder");
      }
      paramT = (CheckBox)paramT.abq(2131302204);
      paramd = this.rDZ;
      if (paramd == null) {
        k.aPZ("holder");
      }
      paramd = paramd.abq(2131302213);
      k.g(paramT, "mediaSelectBox");
      d((View)paramT, 0, bool1);
      k.g(paramd, "mediaMaskArea");
      d(paramd, 4, bool1);
      paramT.setEnabled(true);
      k.g(paramb, "mediaSelectArea");
      paramb.setEnabled(true);
      return;
      bool1 = false;
      break;
      paramb = (CharSequence)"";
      break label193;
      paramb = this.rDa;
      if (paramb == null) {
        k.aPZ("selectedList");
      }
      paramb = (GalleryItem.MediaItem)j.iz((List)paramb);
      if (paramb != null)
      {
        if ((paramb.getType() == 2) && (paramb.rBs != paramT.rBs) && (paramT.getType() != 2))
        {
          bool1 = false;
          break label248;
        }
        if ((paramb.getType() == 1) && (paramT.getType() == 2))
        {
          bool1 = false;
          break label248;
        }
        bool1 = true;
        break label248;
      }
      bool1 = true;
      break label248;
    }
    label498:
    if (paramInt == 2) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramb = this.rDZ;
      if (paramb == null) {
        k.aPZ("holder");
      }
      paramb = paramb.abq(2131302220);
      paramT = this.rDZ;
      if (paramT == null) {
        k.aPZ("holder");
      }
      paramT = (CheckBox)paramT.abq(2131302204);
      paramd = this.rDZ;
      if (paramd == null) {
        k.aPZ("holder");
      }
      paramd = paramd.abq(2131302213);
      k.g(paramT, "mediaSelectBox");
      d((View)paramT, 4, bool1);
      k.g(paramd, "mediaGrepArea");
      d(paramd, 0, bool1);
      paramT.setSelected(false);
      paramT.setChecked(false);
      paramT.setEnabled(false);
      k.g(paramb, "mediaSelectArea");
      paramb.setEnabled(false);
      return;
    }
  }
  
  public final a getAdapter()
  {
    a locala = this.rCx;
    if (locala == null) {
      k.aPZ("adapter");
    }
    return locala;
  }
  
  public final b getHolder()
  {
    b localb = this.rDZ;
    if (localb == null) {
      k.aPZ("holder");
    }
    return localb;
  }
  
  public abstract int getLayoutId();
  
  public final d<T> getLoader()
  {
    d locald = this.fLh;
    if (locald == null) {
      k.aPZ("loader");
    }
    return locald;
  }
  
  public final b<?> getOnItemMediaSelectedListener()
  {
    return this.rCY;
  }
  
  public final ArrayList<T> getSelectedList()
  {
    ArrayList localArrayList = this.rDa;
    if (localArrayList == null) {
      k.aPZ("selectedList");
    }
    return localArrayList;
  }
  
  public final HashSet<T> getSelectedSet()
  {
    HashSet localHashSet = this.rCZ;
    if (localHashSet == null) {
      k.aPZ("selectedSet");
    }
    return localHashSet;
  }
  
  public final void lE(boolean paramBoolean)
  {
    Object localObject = this.rDZ;
    if (localObject == null) {
      k.aPZ("holder");
    }
    localObject = (CheckBox)((b)localObject).abq(2131302204);
    k.g(localObject, "mediaSelectBox");
    if (((CheckBox)localObject).isEnabled()) {
      ((CheckBox)localObject).setChecked(paramBoolean);
    }
  }
  
  public final void setAdapter(a parama)
  {
    k.h(parama, "<set-?>");
    this.rCx = parama;
  }
  
  public final void setHolder(b paramb)
  {
    k.h(paramb, "<set-?>");
    this.rDZ = paramb;
  }
  
  public final void setLoader(d<T> paramd)
  {
    k.h(paramd, "<set-?>");
    this.fLh = paramd;
  }
  
  public final void setOnItemMediaSelectedListener(b<?> paramb)
  {
    this.rCY = paramb;
  }
  
  public final void setSelectedList(ArrayList<T> paramArrayList)
  {
    k.h(paramArrayList, "<set-?>");
    this.rDa = paramArrayList;
  }
  
  public final void setSelectedSet(HashSet<T> paramHashSet)
  {
    k.h(paramHashSet, "<set-?>");
    this.rCZ = paramHashSet;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$Companion;", "", "()V", "TAG", "", "plugin-gallery_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "E", "", "onMediaSelected", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;Ljava/lang/Object;)V", "onMediaUnSelected", "plugin-gallery_release"})
  public static abstract interface b<E>
  {
    public abstract void a(b paramb, E paramE);
    
    public abstract void b(b paramb, E paramE);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "run"})
  static final class c
    implements Runnable
  {
    c(View paramView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(164949);
      this.fPI.setVisibility(0);
      View localView = this.fPI;
      if ((paramInt == 4) || (paramInt == 8)) {}
      for (float f = 1.0F;; f = 0.0F)
      {
        localView.setAlpha(f);
        AppMethodBeat.o(164949);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "run"})
  static final class d
    implements Runnable
  {
    d(View paramView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(164950);
      this.fPI.setVisibility(paramInt);
      this.fPI.setAlpha(1.0F);
      AppMethodBeat.o(164950);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  public static final class e
    implements CompoundButton.OnCheckedChangeListener
  {
    public e(MediaItemView paramMediaItemView, HashSet paramHashSet, ArrayList paramArrayList, d paramd) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(164951);
      paramCompoundButton = (GalleryItem.MediaItem)this.rFl.getHolder().fjf();
      if (paramBoolean != this.rFm.contains(paramCompoundButton))
      {
        if (paramBoolean)
        {
          if (this.rFm.add(paramCompoundButton)) {
            this.rFn.add(paramCompoundButton);
          }
          localObject1 = this.rFl;
          localObject2 = this.rFl.getHolder();
          k.g(paramCompoundButton, "media");
          MediaItemView.a((MediaItemView)localObject1, (b)localObject2, paramCompoundButton, this.rFo);
          paramCompoundButton = this.rFl.getOnItemMediaSelectedListener();
          if (paramCompoundButton != null)
          {
            localObject1 = this.rFl.getHolder();
            localObject2 = this.rFl.getHolder().fjf();
            k.g(localObject2, "holder.getAssociatedObject()");
            paramCompoundButton.b((b)localObject1, localObject2);
            AppMethodBeat.o(164951);
            return;
          }
          AppMethodBeat.o(164951);
          return;
        }
        this.rFm.remove(paramCompoundButton);
        this.rFn.remove(paramCompoundButton);
        Object localObject1 = this.rFl;
        Object localObject2 = this.rFl.getHolder();
        k.g(paramCompoundButton, "media");
        MediaItemView.a((MediaItemView)localObject1, (b)localObject2, paramCompoundButton, this.rFo);
        paramCompoundButton = this.rFl.getOnItemMediaSelectedListener();
        if (paramCompoundButton != null)
        {
          localObject1 = this.rFl.getHolder();
          localObject2 = this.rFl.getHolder().fjf();
          k.g(localObject2, "holder.getAssociatedObject()");
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