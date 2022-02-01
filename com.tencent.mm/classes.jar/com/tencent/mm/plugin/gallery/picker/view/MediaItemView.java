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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.a.b;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;)V", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "getHolder", "()Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "setHolder", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;)V", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "setLoader", "(Lcom/tencent/mm/loader/Loader;)V", "onItemMediaSelectedListener", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "getOnItemMediaSelectedListener", "()Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "setOnItemMediaSelectedListener", "(Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;)V", "selectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "selectedSet", "Ljava/util/HashSet;", "getSelectedSet", "()Ljava/util/HashSet;", "setSelectedSet", "(Ljava/util/HashSet;)V", "animVisible", "", "v", "Landroid/view/View;", "targetVisibility", "isAnim", "", "disableSelected", "enableSelected", "getLayoutId", "isSelectedEnable", "media", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)Z", "onCovert", "covertType", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;Lcom/tencent/mm/loader/Loader;I)V", "onCreateView", "onSelectItem", "isSelected", "Companion", "OnItemMediaSelectedListener", "plugin-gallery_release"})
public abstract class MediaItemView<T extends GalleryItem.MediaItem>
  extends FrameLayout
{
  public static final MediaItemView.a sOb = new MediaItemView.a((byte)0);
  public d<T> fOT;
  public ArrayList<T> gIv;
  private b<?> sLS;
  public HashSet<T> sLT;
  public a sLr;
  public b sMR;
  
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
  
  private static void d(View paramView, int paramInt, boolean paramBoolean)
  {
    ac.d("MediaItemView", "[animVisible] isAnim=" + paramBoolean + " view=" + paramView.hashCode());
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
    paramView = paramView.animate().withStartAction((Runnable)new MediaItemView.c(paramView, paramInt)).withEndAction((Runnable)new MediaItemView.d(paramView, paramInt)).setDuration(300L);
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
    this.sMR = paramb;
    paramb.ej(paramT);
    if ((paramInt == 0) || (paramInt == 1))
    {
      paramd = (CheckBox)paramb.adJ(2131302204);
      k.g(paramd, "mediaSelectBox");
      paramb = this.sLT;
      if (paramb == null) {
        k.aVY("selectedSet");
      }
      paramd.setChecked(paramb.contains(paramT));
      if ((paramT.getType() == 1) && (paramd.isChecked()))
      {
        bool1 = true;
        paramd.setSelected(bool1);
        paramb = this.sLr;
        if (paramb == null) {
          k.aVY("adapter");
        }
        if (!paramb.sLB) {
          break label384;
        }
        paramb = this.gIv;
        if (paramb == null) {
          k.aVY("selectedList");
        }
        if ((paramb.size() <= 0) || (!paramd.isChecked()) || (paramT.getType() != 1)) {
          break label384;
        }
        paramb = this.gIv;
        if (paramb == null) {
          k.aVY("selectedList");
        }
        paramb = (CharSequence)String.valueOf(paramb.indexOf(paramT) + 1);
        label193:
        paramd.setText(paramb);
      }
    }
    else
    {
      k.h(paramT, "media");
      paramb = this.sLT;
      if (paramb == null) {
        k.aVY("selectedSet");
      }
      if (paramb.size() < 9) {
        break label394;
      }
      paramb = this.sLT;
      if (paramb == null) {
        k.aVY("selectedSet");
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
      paramb = this.sMR;
      if (paramb == null) {
        k.aVY("holder");
      }
      paramb = paramb.adJ(2131302220);
      paramT = this.sMR;
      if (paramT == null) {
        k.aVY("holder");
      }
      paramT = (CheckBox)paramT.adJ(2131302204);
      paramd = this.sMR;
      if (paramd == null) {
        k.aVY("holder");
      }
      paramd = paramd.adJ(2131302213);
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
      paramb = this.gIv;
      if (paramb == null) {
        k.aVY("selectedList");
      }
      paramb = (GalleryItem.MediaItem)j.iP((List)paramb);
      if (paramb != null)
      {
        if ((paramb.getType() == 2) && (paramb.sKk != paramT.sKk) && (paramT.getType() != 2))
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
      paramb = this.sMR;
      if (paramb == null) {
        k.aVY("holder");
      }
      paramb = paramb.adJ(2131302220);
      paramT = this.sMR;
      if (paramT == null) {
        k.aVY("holder");
      }
      paramT = (CheckBox)paramT.adJ(2131302204);
      paramd = this.sMR;
      if (paramd == null) {
        k.aVY("holder");
      }
      paramd = paramd.adJ(2131302213);
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
    a locala = this.sLr;
    if (locala == null) {
      k.aVY("adapter");
    }
    return locala;
  }
  
  public final b getHolder()
  {
    b localb = this.sMR;
    if (localb == null) {
      k.aVY("holder");
    }
    return localb;
  }
  
  public abstract int getLayoutId();
  
  public final d<T> getLoader()
  {
    d locald = this.fOT;
    if (locald == null) {
      k.aVY("loader");
    }
    return locald;
  }
  
  public final b<?> getOnItemMediaSelectedListener()
  {
    return this.sLS;
  }
  
  public final ArrayList<T> getSelectedList()
  {
    ArrayList localArrayList = this.gIv;
    if (localArrayList == null) {
      k.aVY("selectedList");
    }
    return localArrayList;
  }
  
  public final HashSet<T> getSelectedSet()
  {
    HashSet localHashSet = this.sLT;
    if (localHashSet == null) {
      k.aVY("selectedSet");
    }
    return localHashSet;
  }
  
  public final void mw(boolean paramBoolean)
  {
    Object localObject = this.sMR;
    if (localObject == null) {
      k.aVY("holder");
    }
    localObject = (CheckBox)((b)localObject).adJ(2131302204);
    k.g(localObject, "mediaSelectBox");
    if (((CheckBox)localObject).isEnabled()) {
      ((CheckBox)localObject).setChecked(paramBoolean);
    }
  }
  
  public final void setAdapter(a parama)
  {
    k.h(parama, "<set-?>");
    this.sLr = parama;
  }
  
  public final void setHolder(b paramb)
  {
    k.h(paramb, "<set-?>");
    this.sMR = paramb;
  }
  
  public final void setLoader(d<T> paramd)
  {
    k.h(paramd, "<set-?>");
    this.fOT = paramd;
  }
  
  public final void setOnItemMediaSelectedListener(b<?> paramb)
  {
    this.sLS = paramb;
  }
  
  public final void setSelectedList(ArrayList<T> paramArrayList)
  {
    k.h(paramArrayList, "<set-?>");
    this.gIv = paramArrayList;
  }
  
  public final void setSelectedSet(HashSet<T> paramHashSet)
  {
    k.h(paramHashSet, "<set-?>");
    this.sLT = paramHashSet;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "E", "", "onMediaSelected", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;Ljava/lang/Object;)V", "onMediaUnSelected", "plugin-gallery_release"})
  public static abstract interface b<E>
  {
    public abstract void a(b paramb, E paramE);
    
    public abstract void b(b paramb, E paramE);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  public static final class e
    implements CompoundButton.OnCheckedChangeListener
  {
    public e(MediaItemView paramMediaItemView, HashSet paramHashSet, ArrayList paramArrayList, d paramd) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(164951);
      paramCompoundButton = (GalleryItem.MediaItem)this.sOd.getHolder().fzs();
      if (paramBoolean != this.sOe.contains(paramCompoundButton))
      {
        if (paramBoolean)
        {
          if (this.sOe.add(paramCompoundButton)) {
            this.sOf.add(paramCompoundButton);
          }
          localObject1 = this.sOd;
          localObject2 = this.sOd.getHolder();
          k.g(paramCompoundButton, "media");
          MediaItemView.a((MediaItemView)localObject1, (b)localObject2, paramCompoundButton, this.sOg);
          paramCompoundButton = this.sOd.getOnItemMediaSelectedListener();
          if (paramCompoundButton != null)
          {
            localObject1 = this.sOd.getHolder();
            localObject2 = this.sOd.getHolder().fzs();
            k.g(localObject2, "holder.getAssociatedObject()");
            paramCompoundButton.b((b)localObject1, localObject2);
            AppMethodBeat.o(164951);
            return;
          }
          AppMethodBeat.o(164951);
          return;
        }
        this.sOe.remove(paramCompoundButton);
        this.sOf.remove(paramCompoundButton);
        Object localObject1 = this.sOd;
        Object localObject2 = this.sOd.getHolder();
        k.g(paramCompoundButton, "media");
        MediaItemView.a((MediaItemView)localObject1, (b)localObject2, paramCompoundButton, this.sOg);
        paramCompoundButton = this.sOd.getOnItemMediaSelectedListener();
        if (paramCompoundButton != null)
        {
          localObject1 = this.sOd.getHolder();
          localObject2 = this.sOd.getHolder().fzs();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MediaItemView
 * JD-Core Version:    0.7.0.1
 */