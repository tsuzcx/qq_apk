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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.a.b;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;)V", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "getHolder", "()Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "setHolder", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;)V", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "setLoader", "(Lcom/tencent/mm/loader/Loader;)V", "onItemMediaSelectedListener", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "getOnItemMediaSelectedListener", "()Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "setOnItemMediaSelectedListener", "(Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;)V", "selectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "selectedSet", "Ljava/util/HashSet;", "getSelectedSet", "()Ljava/util/HashSet;", "setSelectedSet", "(Ljava/util/HashSet;)V", "animVisible", "", "v", "Landroid/view/View;", "targetVisibility", "isAnim", "", "disableSelected", "enableSelected", "getLayoutId", "isSelectedEnable", "media", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)Z", "onCovert", "covertType", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;Lcom/tencent/mm/loader/Loader;I)V", "onCreateView", "onSelectItem", "isSelected", "Companion", "OnItemMediaSelectedListener", "plugin-gallery_release"})
public abstract class MediaItemView<T extends GalleryItem.MediaItem>
  extends FrameLayout
{
  public static final MediaItemView.a tVA = new MediaItemView.a((byte)0);
  public d<T> gkL;
  public ArrayList<T> heT;
  public a tSP;
  private b<?> tTq;
  public HashSet<T> tTr;
  public b tUq;
  
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
    ae.d("MediaItemView", "[animVisible] isAnim=" + paramBoolean + " view=" + paramView.hashCode());
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
    p.h(paramb, "holder");
    p.h(paramT, "media");
    p.h(paramd, "loader");
    this.tUq = paramb;
    paramb.ep(paramT);
    if ((paramInt == 0) || (paramInt == 1))
    {
      paramd = (CheckBox)paramb.GD(2131302204);
      p.g(paramd, "mediaSelectBox");
      paramb = this.tTr;
      if (paramb == null) {
        p.bdF("selectedSet");
      }
      paramd.setChecked(paramb.contains(paramT));
      if ((paramT.getType() == 1) && (paramd.isChecked()))
      {
        bool1 = true;
        paramd.setSelected(bool1);
        paramb = this.tSP;
        if (paramb == null) {
          p.bdF("adapter");
        }
        if (!paramb.tSZ) {
          break label384;
        }
        paramb = this.heT;
        if (paramb == null) {
          p.bdF("selectedList");
        }
        if ((paramb.size() <= 0) || (!paramd.isChecked()) || (paramT.getType() != 1)) {
          break label384;
        }
        paramb = this.heT;
        if (paramb == null) {
          p.bdF("selectedList");
        }
        paramb = (CharSequence)String.valueOf(paramb.indexOf(paramT) + 1);
        label193:
        paramd.setText(paramb);
      }
    }
    else
    {
      p.h(paramT, "media");
      paramb = this.tTr;
      if (paramb == null) {
        p.bdF("selectedSet");
      }
      if (paramb.size() < 9) {
        break label394;
      }
      paramb = this.tTr;
      if (paramb == null) {
        p.bdF("selectedSet");
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
      paramb = this.tUq;
      if (paramb == null) {
        p.bdF("holder");
      }
      paramb = paramb.GD(2131302220);
      paramT = this.tUq;
      if (paramT == null) {
        p.bdF("holder");
      }
      paramT = (CheckBox)paramT.GD(2131302204);
      paramd = this.tUq;
      if (paramd == null) {
        p.bdF("holder");
      }
      paramd = paramd.GD(2131302213);
      p.g(paramT, "mediaSelectBox");
      d((View)paramT, 0, bool1);
      p.g(paramd, "mediaMaskArea");
      d(paramd, 4, bool1);
      paramT.setEnabled(true);
      p.g(paramb, "mediaSelectArea");
      paramb.setEnabled(true);
      return;
      bool1 = false;
      break;
      paramb = (CharSequence)"";
      break label193;
      paramb = this.heT;
      if (paramb == null) {
        p.bdF("selectedList");
      }
      paramb = (GalleryItem.MediaItem)j.jm((List)paramb);
      if (paramb != null)
      {
        if ((paramb.getType() == 2) && (paramb.tRM != paramT.tRM) && (paramT.getType() != 2))
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
      paramb = this.tUq;
      if (paramb == null) {
        p.bdF("holder");
      }
      paramb = paramb.GD(2131302220);
      paramT = this.tUq;
      if (paramT == null) {
        p.bdF("holder");
      }
      paramT = (CheckBox)paramT.GD(2131302204);
      paramd = this.tUq;
      if (paramd == null) {
        p.bdF("holder");
      }
      paramd = paramd.GD(2131302213);
      p.g(paramT, "mediaSelectBox");
      d((View)paramT, 4, bool1);
      p.g(paramd, "mediaGrepArea");
      d(paramd, 0, bool1);
      paramT.setSelected(false);
      paramT.setChecked(false);
      paramT.setEnabled(false);
      p.g(paramb, "mediaSelectArea");
      paramb.setEnabled(false);
      return;
    }
  }
  
  public final a getAdapter()
  {
    a locala = this.tSP;
    if (locala == null) {
      p.bdF("adapter");
    }
    return locala;
  }
  
  public final b getHolder()
  {
    b localb = this.tUq;
    if (localb == null) {
      p.bdF("holder");
    }
    return localb;
  }
  
  public abstract int getLayoutId();
  
  public final d<T> getLoader()
  {
    d locald = this.gkL;
    if (locald == null) {
      p.bdF("loader");
    }
    return locald;
  }
  
  public final b<?> getOnItemMediaSelectedListener()
  {
    return this.tTq;
  }
  
  public final ArrayList<T> getSelectedList()
  {
    ArrayList localArrayList = this.heT;
    if (localArrayList == null) {
      p.bdF("selectedList");
    }
    return localArrayList;
  }
  
  public final HashSet<T> getSelectedSet()
  {
    HashSet localHashSet = this.tTr;
    if (localHashSet == null) {
      p.bdF("selectedSet");
    }
    return localHashSet;
  }
  
  public final void mR(boolean paramBoolean)
  {
    Object localObject = this.tUq;
    if (localObject == null) {
      p.bdF("holder");
    }
    localObject = (CheckBox)((b)localObject).GD(2131302204);
    p.g(localObject, "mediaSelectBox");
    if (((CheckBox)localObject).isEnabled()) {
      ((CheckBox)localObject).setChecked(paramBoolean);
    }
  }
  
  public final void setAdapter(a parama)
  {
    p.h(parama, "<set-?>");
    this.tSP = parama;
  }
  
  public final void setHolder(b paramb)
  {
    p.h(paramb, "<set-?>");
    this.tUq = paramb;
  }
  
  public final void setLoader(d<T> paramd)
  {
    p.h(paramd, "<set-?>");
    this.gkL = paramd;
  }
  
  public final void setOnItemMediaSelectedListener(b<?> paramb)
  {
    this.tTq = paramb;
  }
  
  public final void setSelectedList(ArrayList<T> paramArrayList)
  {
    p.h(paramArrayList, "<set-?>");
    this.heT = paramArrayList;
  }
  
  public final void setSelectedSet(HashSet<T> paramHashSet)
  {
    p.h(paramHashSet, "<set-?>");
    this.tTr = paramHashSet;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "E", "", "onMediaSelected", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;Ljava/lang/Object;)V", "onMediaUnSelected", "plugin-gallery_release"})
  public static abstract interface b<E>
  {
    public abstract void a(b paramb, E paramE);
    
    public abstract void b(b paramb, E paramE);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  public static final class e
    implements CompoundButton.OnCheckedChangeListener
  {
    public e(MediaItemView paramMediaItemView, HashSet paramHashSet, ArrayList paramArrayList, d paramd) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(164951);
      paramCompoundButton = (GalleryItem.MediaItem)this.tVC.getHolder().fUY();
      if (paramBoolean != this.tVD.contains(paramCompoundButton))
      {
        if (paramBoolean)
        {
          if (this.tVD.add(paramCompoundButton)) {
            this.tVE.add(paramCompoundButton);
          }
          localObject1 = this.tVC;
          localObject2 = this.tVC.getHolder();
          p.g(paramCompoundButton, "media");
          MediaItemView.a((MediaItemView)localObject1, (b)localObject2, paramCompoundButton, this.tVF);
          paramCompoundButton = this.tVC.getOnItemMediaSelectedListener();
          if (paramCompoundButton != null)
          {
            localObject1 = this.tVC.getHolder();
            localObject2 = this.tVC.getHolder().fUY();
            p.g(localObject2, "holder.getAssociatedObject()");
            paramCompoundButton.b((b)localObject1, localObject2);
            AppMethodBeat.o(164951);
            return;
          }
          AppMethodBeat.o(164951);
          return;
        }
        this.tVD.remove(paramCompoundButton);
        this.tVE.remove(paramCompoundButton);
        Object localObject1 = this.tVC;
        Object localObject2 = this.tVC.getHolder();
        p.g(paramCompoundButton, "media");
        MediaItemView.a((MediaItemView)localObject1, (b)localObject2, paramCompoundButton, this.tVF);
        paramCompoundButton = this.tVC.getOnItemMediaSelectedListener();
        if (paramCompoundButton != null)
        {
          localObject1 = this.tVC.getHolder();
          localObject2 = this.tVC.getHolder().fUY();
          p.g(localObject2, "holder.getAssociatedObject()");
          paramCompoundButton.a((b)localObject1, localObject2);
          AppMethodBeat.o(164951);
          return;
        }
      }
      AppMethodBeat.o(164951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MediaItemView
 * JD-Core Version:    0.7.0.1
 */