package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.upload.e;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/widget/post/PostImageWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "postType", "", "(Landroid/content/Context;I)V", "imgFileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "multiImgIcon", "Landroid/widget/ImageView;", "reprintIv", "Landroid/view/View;", "rootView", "thumbFileList", "thumbIv", "checkData", "", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "jumpToPreviewMediaUI", "", "onCreate", "onDestroy", "refresh", "Companion", "plugin-finder_release"})
public final class d
  extends a
{
  private static final String TAG = "Finder.PostImageWidget";
  private static final String sis = "image_file_list";
  private static final String sit = "image_thumb_list";
  public static final a siu;
  private View khe;
  private ImageView sil;
  private ImageView sin;
  private View sio;
  private ArrayList<String> sip;
  private ArrayList<String> siq;
  private int sir;
  
  static
  {
    AppMethodBeat.i(168598);
    siu = new a((byte)0);
    sis = "image_file_list";
    sit = "image_thumb_list";
    TAG = "Finder.PostImageWidget";
    AppMethodBeat.o(168598);
  }
  
  private d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168597);
    this.sir = 2;
    this.siq = new ArrayList();
    AppMethodBeat.o(168597);
  }
  
  public final View cGA()
  {
    AppMethodBeat.i(168594);
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(168594);
      throw ((Throwable)localObject);
    }
    this.khe = ((Activity)localObject).getLayoutInflater().inflate(2131494084, null);
    localObject = this.khe;
    if (localObject == null) {
      k.fOy();
    }
    this.sil = ((ImageView)((View)localObject).findViewById(2131305801));
    localObject = this.khe;
    if (localObject == null) {
      k.fOy();
    }
    this.sin = ((ImageView)((View)localObject).findViewById(2131300941));
    localObject = this.khe;
    if (localObject == null) {
      k.fOy();
    }
    localObject = ((View)localObject).findViewById(2131304092);
    k.g(localObject, "rootView!!.findViewById(R.id.reprint_iv)");
    this.sio = ((View)localObject);
    localObject = this.khe;
    AppMethodBeat.o(168594);
    return localObject;
  }
  
  public final h cGB()
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(204870);
    if ((this.shV != null) && (this.shW != null))
    {
      localObject1 = new h(true, 2, this.shW);
      AppMethodBeat.o(204870);
      return localObject1;
    }
    Object localObject1 = (Collection)this.sip;
    int i;
    Object localObject2;
    Object localObject3;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label320;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder("img list ");
      localObject3 = this.sip;
      if (localObject3 == null) {
        k.fOy();
      }
      ac.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.siq.size());
      localObject1 = this.sip;
      if (localObject1 == null) {
        k.fOy();
      }
      if (((ArrayList)localObject1).size() != this.siq.size()) {
        break label315;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = new bqr();
        LinkedList localLinkedList;
        Object localObject4;
        if (this.sir == 7)
        {
          localObject2 = this.sip;
          if (localObject2 == null) {
            k.fOy();
          }
          localObject2 = ((Iterable)localObject2).iterator();
          i = j;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (i < 0) {
              j.fOc();
            }
            localObject3 = (String)localObject3;
            localLinkedList = ((bqr)localObject1).mediaList;
            localObject4 = com.tencent.mm.plugin.finder.upload.h.rNr;
            localObject4 = this.siq.get(i);
            k.g(localObject4, "thumbFileList[index]");
            localLinkedList.add(com.tencent.mm.plugin.finder.upload.h.gk((String)localObject3, (String)localObject4));
            i += 1;
          }
          i = 0;
          break;
          label315:
          i = 0;
          continue;
          label320:
          ac.i(TAG, "img list null");
          i = 0;
          continue;
        }
        localObject2 = this.sip;
        if (localObject2 == null) {
          k.fOy();
        }
        localObject2 = ((Iterable)localObject2).iterator();
        i = k;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            j.fOc();
          }
          localObject3 = (String)localObject3;
          localLinkedList = ((bqr)localObject1).mediaList;
          localObject4 = com.tencent.mm.plugin.finder.upload.h.rNr;
          localObject4 = this.siq.get(i);
          k.g(localObject4, "thumbFileList[index]");
          localLinkedList.add(com.tencent.mm.plugin.finder.upload.h.gj((String)localObject3, (String)localObject4));
          i += 1;
        }
        if (this.sir == 7)
        {
          localObject1 = new h(true, 7, (bqr)localObject1);
          AppMethodBeat.o(204870);
          return localObject1;
        }
        localObject1 = new h(true, 2, (bqr)localObject1);
        AppMethodBeat.o(204870);
        return localObject1;
      }
    }
    localObject1 = new h(false, 0, null);
    AppMethodBeat.o(204870);
    return localObject1;
  }
  
  public final void refresh()
  {
    Object localObject2 = null;
    AppMethodBeat.i(168596);
    Object localObject3;
    if (this.shW != null)
    {
      localObject1 = this.shW;
      if (localObject1 == null) {
        k.fOy();
      }
      if (!bs.gY((List)((bqr)localObject1).mediaList))
      {
        localObject1 = this.sio;
        if (localObject1 == null) {
          k.aVY("reprintIv");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.sin;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = this.shW;
        if (localObject1 == null) {
          k.fOy();
        }
        localObject1 = ((bqr)localObject1).mediaList;
        k.g(localObject1, "refFeedContent!!.mediaList");
        localObject1 = (bqs)((LinkedList)localObject1).getFirst();
        localObject2 = n.rPN;
        localObject2 = n.fF((int)((bqs)localObject1).width, (int)((bqs)localObject1).height);
        localObject3 = this.sil;
        if (localObject3 == null) {
          k.fOy();
        }
        ((ImageView)localObject3).getLayoutParams().width = ((Bundle)localObject2).getInt("media_layout_width", (int)((bqs)localObject1).width);
        localObject3 = this.sil;
        if (localObject3 == null) {
          k.fOy();
        }
        ((ImageView)localObject3).getLayoutParams().height = ((Bundle)localObject2).getInt("media_layout_height", (int)((bqs)localObject1).height);
        localObject3 = this.sil;
        if (localObject3 == null) {
          k.fOy();
        }
        ((ImageView)localObject3).setScaleType(android.widget.ImageView.ScaleType.values()[localObject2.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
        localObject2 = this.sil;
        if (localObject2 == null) {
          k.fOy();
        }
        ((ImageView)localObject2).requestLayout();
        k.g(localObject1, "mediaObj");
        localObject1 = new com.tencent.mm.plugin.finder.loader.f((bqs)localObject1, m.rDR);
        localObject2 = com.tencent.mm.plugin.finder.loader.h.rtK;
        localObject2 = com.tencent.mm.plugin.finder.loader.h.cwn();
        localObject3 = this.sil;
        if (localObject3 == null) {
          k.fOy();
        }
        com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.rtK;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtL));
        localObject1 = this.sil;
        if (localObject1 == null) {
          k.fOy();
        }
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = this.sil;
        if (localObject1 == null) {
          k.fOy();
        }
        ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new b(this));
        AppMethodBeat.o(168596);
        return;
      }
    }
    Object localObject1 = this.dmf;
    if (localObject1 != null) {}
    for (localObject1 = ((Bundle)localObject1).getStringArrayList(sis);; localObject1 = null)
    {
      this.sip = ((ArrayList)localObject1);
      localObject3 = this.dmf;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((Bundle)localObject3).getStringArrayList(sit);
      }
      if (this.sip != null)
      {
        localObject2 = this.sip;
        if (localObject2 == null) {
          k.fOy();
        }
        if (((ArrayList)localObject2).size() > 0)
        {
          localObject2 = this.sin;
          if (localObject2 != null) {
            ((ImageView)localObject2).setVisibility(0);
          }
          com.tencent.e.h.JZN.f((Runnable)new c(this, (ArrayList)localObject1), "Finder_Post_Create_Image_Thumb");
        }
      }
      AppMethodBeat.o(168596);
      return;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/widget/post/PostImageWidget$Companion;", "", "()V", "IMAGE_FILE_LIST", "", "getIMAGE_FILE_LIST", "()Ljava/lang/String;", "IMAGE_THUMB_LIST", "getIMAGE_THUMB_LIST", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168590);
      d.a(this.siv);
      AppMethodBeat.o(168590);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168593);
      Object localObject1 = d.b(this.siv);
      if (localObject1 == null) {
        k.fOy();
      }
      Iterator localIterator = ((Iterable)localObject1).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          j.fOc();
        }
        localObject1 = (String)localObject1;
        boolean bool;
        if (i == 0)
        {
          bool = true;
          label79:
          if ((this.siw == null) || (this.siw.size() <= i) || (bs.isNullOrNil((String)this.siw.get(i)))) {
            break label179;
          }
        }
        for (localObject1 = (String)this.siw.get(i);; localObject1 = e.aer((String)localObject1))
        {
          if (bs.isNullOrNil((String)localObject1)) {
            break label194;
          }
          Object localObject2 = com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject1);
          if (localObject2 == null) {
            break label194;
          }
          ap.f((Runnable)new d.c.a((Bitmap)localObject2, (String)localObject1, i, bool, (Bitmap)localObject2, this));
          i = j;
          break;
          bool = false;
          break label79;
          label179:
          localObject2 = e.rMX;
        }
        label194:
        i = j;
      }
      AppMethodBeat.o(168593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.d
 * JD-Core Version:    0.7.0.1
 */