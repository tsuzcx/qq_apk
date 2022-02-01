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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;)V", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "getHolder", "()Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "setHolder", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;)V", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "setLoader", "(Lcom/tencent/mm/loader/Loader;)V", "onItemMediaSelectedListener", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "getOnItemMediaSelectedListener", "()Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "setOnItemMediaSelectedListener", "(Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;)V", "selectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "selectedSet", "Ljava/util/HashSet;", "getSelectedSet", "()Ljava/util/HashSet;", "setSelectedSet", "(Ljava/util/HashSet;)V", "animVisible", "", "v", "Landroid/view/View;", "targetVisibility", "isAnim", "", "disableSelected", "enableSelected", "getLayoutId", "isSelectedEnable", "media", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)Z", "onCovert", "covertType", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;Lcom/tencent/mm/loader/Loader;I)V", "onCreateView", "onSelectItem", "isSelected", "Companion", "OnItemMediaSelectedListener", "plugin-gallery_release"})
public abstract class MediaItemView<T extends GalleryItem.MediaItem>
  extends FrameLayout
{
  public static final a xmM = new a((byte)0);
  public d<T> gVG;
  public ArrayList<T> hXI;
  private b<?> xkD;
  public HashSet<T> xkE;
  public a xkc;
  public b xlC;
  
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
  
  private static void c(View paramView, final int paramInt, boolean paramBoolean)
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
    p.h(paramb, "holder");
    p.h(paramT, "media");
    p.h(paramd, "loader");
    this.xlC = paramb;
    paramb.et(paramT);
    if ((paramInt == 0) || (paramInt == 1))
    {
      paramd = (CheckBox)paramb.Mn(2131304550);
      p.g(paramd, "mediaSelectBox");
      paramb = this.xkE;
      if (paramb == null) {
        p.btv("selectedSet");
      }
      paramd.setChecked(paramb.contains(paramT));
      if ((paramT.getType() == 1) && (paramd.isChecked()))
      {
        bool1 = true;
        paramd.setSelected(bool1);
        paramb = this.xkc;
        if (paramb == null) {
          p.btv("adapter");
        }
        if (!paramb.xkm) {
          break label384;
        }
        paramb = this.hXI;
        if (paramb == null) {
          p.btv("selectedList");
        }
        if ((paramb.size() <= 0) || (!paramd.isChecked()) || (paramT.getType() != 1)) {
          break label384;
        }
        paramb = this.hXI;
        if (paramb == null) {
          p.btv("selectedList");
        }
        paramb = (CharSequence)String.valueOf(paramb.indexOf(paramT) + 1);
        label193:
        paramd.setText(paramb);
      }
    }
    else
    {
      p.h(paramT, "media");
      paramb = this.xkE;
      if (paramb == null) {
        p.btv("selectedSet");
      }
      if (paramb.size() < 9) {
        break label394;
      }
      paramb = this.xkE;
      if (paramb == null) {
        p.btv("selectedSet");
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
      paramb = this.xlC;
      if (paramb == null) {
        p.btv("holder");
      }
      paramb = paramb.Mn(2131304572);
      paramT = this.xlC;
      if (paramT == null) {
        p.btv("holder");
      }
      paramT = (CheckBox)paramT.Mn(2131304550);
      paramd = this.xlC;
      if (paramd == null) {
        p.btv("holder");
      }
      paramd = paramd.Mn(2131304564);
      p.g(paramT, "mediaSelectBox");
      c((View)paramT, 0, bool1);
      p.g(paramd, "mediaMaskArea");
      c(paramd, 4, bool1);
      paramT.setEnabled(true);
      p.g(paramb, "mediaSelectArea");
      paramb.setEnabled(true);
      return;
      bool1 = false;
      break;
      paramb = (CharSequence)"";
      break label193;
      paramb = this.hXI;
      if (paramb == null) {
        p.btv("selectedList");
      }
      paramb = (GalleryItem.MediaItem)j.kt((List)paramb);
      if (paramb != null)
      {
        if ((paramb.getType() == 2) && (paramb.xiZ != paramT.xiZ) && (paramT.getType() != 2))
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
      paramb = this.xlC;
      if (paramb == null) {
        p.btv("holder");
      }
      paramb = paramb.Mn(2131304572);
      paramT = this.xlC;
      if (paramT == null) {
        p.btv("holder");
      }
      paramT = (CheckBox)paramT.Mn(2131304550);
      paramd = this.xlC;
      if (paramd == null) {
        p.btv("holder");
      }
      paramd = paramd.Mn(2131304564);
      p.g(paramT, "mediaSelectBox");
      c((View)paramT, 4, bool1);
      p.g(paramd, "mediaGrepArea");
      c(paramd, 0, bool1);
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
    a locala = this.xkc;
    if (locala == null) {
      p.btv("adapter");
    }
    return locala;
  }
  
  public final b getHolder()
  {
    b localb = this.xlC;
    if (localb == null) {
      p.btv("holder");
    }
    return localb;
  }
  
  public abstract int getLayoutId();
  
  public final d<T> getLoader()
  {
    d locald = this.gVG;
    if (locald == null) {
      p.btv("loader");
    }
    return locald;
  }
  
  public final b<?> getOnItemMediaSelectedListener()
  {
    return this.xkD;
  }
  
  public final ArrayList<T> getSelectedList()
  {
    ArrayList localArrayList = this.hXI;
    if (localArrayList == null) {
      p.btv("selectedList");
    }
    return localArrayList;
  }
  
  public final HashSet<T> getSelectedSet()
  {
    HashSet localHashSet = this.xkE;
    if (localHashSet == null) {
      p.btv("selectedSet");
    }
    return localHashSet;
  }
  
  public final void py(boolean paramBoolean)
  {
    Object localObject = this.xlC;
    if (localObject == null) {
      p.btv("holder");
    }
    localObject = (CheckBox)((b)localObject).Mn(2131304550);
    p.g(localObject, "mediaSelectBox");
    if (((CheckBox)localObject).isEnabled()) {
      ((CheckBox)localObject).setChecked(paramBoolean);
    }
  }
  
  public final void setAdapter(a parama)
  {
    p.h(parama, "<set-?>");
    this.xkc = parama;
  }
  
  public final void setHolder(b paramb)
  {
    p.h(paramb, "<set-?>");
    this.xlC = paramb;
  }
  
  public final void setLoader(d<T> paramd)
  {
    p.h(paramd, "<set-?>");
    this.gVG = paramd;
  }
  
  public final void setOnItemMediaSelectedListener(b<?> paramb)
  {
    this.xkD = paramb;
  }
  
  public final void setSelectedList(ArrayList<T> paramArrayList)
  {
    p.h(paramArrayList, "<set-?>");
    this.hXI = paramArrayList;
  }
  
  public final void setSelectedSet(HashSet<T> paramHashSet)
  {
    p.h(paramHashSet, "<set-?>");
    this.xkE = paramHashSet;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$Companion;", "", "()V", "TAG", "", "plugin-gallery_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "E", "", "onMediaSelected", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;Ljava/lang/Object;)V", "onMediaUnSelected", "plugin-gallery_release"})
  public static abstract interface b<E>
  {
    public abstract void a(b paramb, E paramE);
    
    public abstract void b(b paramb, E paramE);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "run"})
  static final class c
    implements Runnable
  {
    c(View paramView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(164949);
      this.haw.setVisibility(0);
      View localView = this.haw;
      if ((paramInt == 4) || (paramInt == 8)) {}
      for (float f = 1.0F;; f = 0.0F)
      {
        localView.setAlpha(f);
        AppMethodBeat.o(164949);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "run"})
  static final class d
    implements Runnable
  {
    d(View paramView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(164950);
      this.haw.setVisibility(paramInt);
      this.haw.setAlpha(1.0F);
      AppMethodBeat.o(164950);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  public static final class e
    implements CompoundButton.OnCheckedChangeListener
  {
    public e(MediaItemView paramMediaItemView, HashSet paramHashSet, ArrayList paramArrayList, d paramd) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(164951);
      paramCompoundButton = (GalleryItem.MediaItem)this.xmO.getHolder().hgv();
      if (paramBoolean != this.xmP.contains(paramCompoundButton))
      {
        if (paramBoolean)
        {
          if (this.xmP.add(paramCompoundButton)) {
            this.xmQ.add(paramCompoundButton);
          }
          localObject1 = this.xmO;
          localObject2 = this.xmO.getHolder();
          p.g(paramCompoundButton, "media");
          MediaItemView.a((MediaItemView)localObject1, (b)localObject2, paramCompoundButton, this.xmR);
          paramCompoundButton = this.xmO.getOnItemMediaSelectedListener();
          if (paramCompoundButton != null)
          {
            localObject1 = this.xmO.getHolder();
            localObject2 = this.xmO.getHolder().hgv();
            p.g(localObject2, "holder.getAssociatedObject()");
            paramCompoundButton.b((b)localObject1, localObject2);
            AppMethodBeat.o(164951);
            return;
          }
          AppMethodBeat.o(164951);
          return;
        }
        this.xmP.remove(paramCompoundButton);
        this.xmQ.remove(paramCompoundButton);
        Object localObject1 = this.xmO;
        Object localObject2 = this.xmO.getHolder();
        p.g(paramCompoundButton, "media");
        MediaItemView.a((MediaItemView)localObject1, (b)localObject2, paramCompoundButton, this.xmR);
        paramCompoundButton = this.xmO.getOnItemMediaSelectedListener();
        if (paramCompoundButton != null)
        {
          localObject1 = this.xmO.getHolder();
          localObject2 = this.xmO.getHolder().hgv();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MediaItemView
 * JD-Core Version:    0.7.0.1
 */