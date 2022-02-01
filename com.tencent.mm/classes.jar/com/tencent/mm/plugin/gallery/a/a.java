package com.tencent.mm.plugin.gallery.a;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.mj_template.api.d;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI;
import com.tencent.mm.protocal.protobuf.ffv;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/mjtemplate/AlbumTemplateUI;", "Landroid/view/View$OnClickListener;", "uiHolder", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumPreviewUI;", "videoTemplateInfo", "Lcom/tencent/mm/protocal/protobuf/SnsVideoTemplate;", "(Ljava/lang/ref/WeakReference;Lcom/tencent/mm/protocal/protobuf/SnsVideoTemplate;)V", "_selectTemplateType", "Landroidx/lifecycle/MutableLiveData;", "", "checkCanSelect", "Lkotlin/Function0;", "", "getCheckCanSelect", "()Lkotlin/jvm/functions/Function0;", "setCheckCanSelect", "(Lkotlin/jvm/functions/Function0;)V", "mLlRaw", "Landroid/widget/LinearLayout;", "radioBtn", "Landroid/widget/ImageButton;", "radioLayout", "radioText", "Landroid/widget/TextView;", "selectTemplateType", "Landroidx/lifecycle/LiveData;", "templateEnable", "getTemplateEnable", "()Z", "templateHintLayout", "templateHintText", "getUiHolder", "()Ljava/lang/ref/WeakReference;", "setUiHolder", "(Ljava/lang/ref/WeakReference;)V", "getVideoTemplateInfo", "()Lcom/tencent/mm/protocal/protobuf/SnsVideoTemplate;", "getSelectTemplateLiveData", "initView", "", "isCutSame", "isSelectNoEnableChange", "isSelectTemplate", "onClick", "p0", "Landroid/view/View;", "selectTemplate", "select", "updateAlbumTemplateState", "selectMediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "updatePreviewStatus", "updateTemplateView", "visibility", "toInstance", "Companion", "TemplateSelectType", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements View.OnClickListener
{
  public static final a.a HFG;
  public WeakReference<AlbumPreviewUI> HFH;
  private final ffv HFI;
  public final boolean HFJ;
  x<Integer> HFK;
  LiveData<Integer> HFL;
  private LinearLayout HFM;
  private ImageButton HFN;
  private TextView HFO;
  private LinearLayout HFP;
  private TextView HFQ;
  private LinearLayout HFR;
  kotlin.g.a.a<Boolean> HFS;
  
  static
  {
    AppMethodBeat.i(289280);
    HFG = new a.a((byte)0);
    AppMethodBeat.o(289280);
  }
  
  public a(WeakReference<AlbumPreviewUI> paramWeakReference, ffv paramffv)
  {
    AppMethodBeat.i(289266);
    this.HFH = paramWeakReference;
    this.HFI = paramffv;
    paramWeakReference = this.HFH;
    boolean bool;
    if (paramWeakReference == null) {
      bool = false;
    }
    for (;;)
    {
      this.HFJ = bool;
      this.HFK = new x(Integer.valueOf(a.b.HFT.value));
      this.HFL = ((LiveData)this.HFK);
      this.HFS = ((kotlin.g.a.a)a.c.HFX);
      paramWeakReference = this.HFH;
      if (paramWeakReference != null)
      {
        paramWeakReference = g(paramWeakReference);
        if (paramWeakReference != null)
        {
          this.HFR = ((LinearLayout)paramWeakReference.findViewById(b.e.original_ll));
          this.HFM = ((LinearLayout)paramWeakReference.findViewById(b.e.template_ll));
          this.HFN = ((ImageButton)paramWeakReference.findViewById(b.e.template_ibn));
          this.HFO = ((TextView)paramWeakReference.findViewById(b.e.template_tip));
          this.HFP = ((LinearLayout)paramWeakReference.findViewById(b.e.template_hint_ll));
          this.HFQ = ((TextView)paramWeakReference.findViewById(b.e.template_hint_tv));
        }
      }
      paramWeakReference = this.HFN;
      if (paramWeakReference != null) {
        paramWeakReference.setOnClickListener((View.OnClickListener)this);
      }
      paramWeakReference = this.HFO;
      if (paramWeakReference != null) {
        paramWeakReference.setOnClickListener((View.OnClickListener)this);
      }
      if (this.HFJ)
      {
        paramWeakReference = this.HFM;
        if (paramWeakReference != null) {
          paramWeakReference.setVisibility(0);
        }
      }
      if (fzL())
      {
        ((d)h.az(d.class)).preloadMaas();
        Wv(0);
      }
      AppMethodBeat.o(289266);
      return;
      paramWeakReference = g(paramWeakReference);
      if (paramWeakReference == null)
      {
        bool = false;
      }
      else
      {
        paramWeakReference = paramWeakReference.getIntent();
        if (paramWeakReference == null) {
          bool = false;
        } else {
          bool = paramWeakReference.getBooleanExtra("key_sns_publish_template", false);
        }
      }
    }
  }
  
  private final void Wv(int paramInt)
  {
    AppMethodBeat.i(289273);
    Object localObject;
    if (paramInt == 0)
    {
      localObject = this.HFN;
      if (localObject != null) {
        ((ImageButton)localObject).setSelected(true);
      }
      localObject = this.HFN;
      if (localObject != null) {
        ((ImageButton)localObject).setEnabled(false);
      }
      localObject = this.HFO;
      if (localObject != null) {
        ((TextView)localObject).setClickable(false);
      }
      this.HFK.setValue(Integer.valueOf(a.b.HFV.value));
    }
    for (;;)
    {
      if (fzK()) {
        ((d)h.az(d.class)).preloadMaas();
      }
      AppMethodBeat.o(289273);
      return;
      if (fzK())
      {
        localObject = this.HFN;
        if (localObject != null) {
          ((ImageButton)localObject).setSelected(true);
        }
        localObject = this.HFN;
        if (localObject != null) {
          ((ImageButton)localObject).setEnabled(true);
        }
        localObject = this.HFO;
        if (localObject != null) {
          ((TextView)localObject).setClickable(true);
        }
        this.HFK.setValue(Integer.valueOf(a.b.HFU.value));
      }
    }
  }
  
  private boolean fzL()
  {
    Object localObject = this.HFI;
    if (localObject == null) {}
    for (localObject = null; localObject != null; localObject = ((ffv)localObject).nSg) {
      return true;
    }
    return false;
  }
  
  private static AlbumPreviewUI g(WeakReference<AlbumPreviewUI> paramWeakReference)
  {
    AppMethodBeat.i(289276);
    s.u(paramWeakReference, "<this>");
    paramWeakReference = (AlbumPreviewUI)paramWeakReference.get();
    AppMethodBeat.o(289276);
    return paramWeakReference;
  }
  
  public final void aH(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    int k = 0;
    AppMethodBeat.i(289293);
    if (!this.HFJ)
    {
      AppMethodBeat.o(289293);
      return;
    }
    if (fzL())
    {
      AppMethodBeat.o(289293);
      return;
    }
    Object localObject = this.HFH;
    if (localObject != null)
    {
      localObject = g((WeakReference)localObject);
      if (localObject != null)
      {
        ((AlbumPreviewUI)localObject).HMe.setClickable(true);
        ((AlbumPreviewUI)localObject).HMe.setEnabled(true);
      }
    }
    paramArrayList = b.hY((List)paramArrayList);
    if (((CharSequence)paramArrayList).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label171;
      }
    }
    label171:
    for (int i = 8;; i = 0)
    {
      localObject = this.HFQ;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramArrayList);
      }
      paramArrayList = this.HFP;
      int j = k;
      if (paramArrayList != null)
      {
        j = k;
        if (paramArrayList.getVisibility() == 0) {
          j = 1;
        }
      }
      if ((j == 0) || (i != 0)) {
        break label176;
      }
      AppMethodBeat.o(289293);
      return;
      i = 0;
      break;
    }
    label176:
    paramArrayList = this.HFP;
    if (paramArrayList != null) {
      paramArrayList.setVisibility(i);
    }
    Wv(i);
    AppMethodBeat.o(289293);
  }
  
  public final boolean fzK()
  {
    AppMethodBeat.i(289288);
    Integer localInteger = (Integer)this.HFL.getValue();
    int i = a.b.HFT.value;
    if (localInteger == null) {}
    while (localInteger.intValue() != i)
    {
      AppMethodBeat.o(289288);
      return true;
    }
    AppMethodBeat.o(289288);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(289301);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/mjtemplate/AlbumTemplateUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = b.e.template_ibn;
      if (paramView != null) {
        break label135;
      }
      label53:
      i = b.e.template_tip;
      if (paramView != null) {
        break label148;
      }
      label61:
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        if ((!fzK()) && (!((Boolean)this.HFS.invoke()).booleanValue()))
        {
          Log.w("MicroMsg.GalleryTemplateUI", "not enable to select");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/mjtemplate/AlbumTemplateUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(289301);
          return;
          paramView = Integer.valueOf(paramView.getId());
          break;
          label135:
          if (paramView.intValue() != i) {
            break label53;
          }
          i = 1;
          continue;
          label148:
          if (paramView.intValue() != i) {
            break label61;
          }
          i = 1;
          continue;
        }
        localObject = this.HFK;
        if (!fzK()) {
          break label248;
        }
      }
    }
    label248:
    for (paramView = Integer.valueOf(a.b.HFT.value);; paramView = Integer.valueOf(a.b.HFU.value))
    {
      ((x)localObject).setValue(paramView);
      paramView = this.HFN;
      if (paramView != null) {
        paramView.setSelected(fzK());
      }
      if (fzK()) {
        ((d)h.az(d.class)).preloadMaas();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/mjtemplate/AlbumTemplateUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289301);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a.a
 * JD-Core Version:    0.7.0.1
 */