package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.l.c;
import com.tencent.mm.plugin.gallery.model.q;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.g;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.widget.GameGridLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLocalGalleryView
  extends FrameLayout
  implements l.c
{
  static final int IyZ;
  static final int Iza;
  private long HMR;
  private int IyH;
  private RecyclerView Izb;
  c Izc;
  private TextView Izd;
  private Button Ize;
  private int Izf;
  private boolean Izg;
  private boolean Izh;
  private boolean Izi;
  
  static
  {
    AppMethodBeat.i(41027);
    IyZ = "GameLocalGalleryView_REQUEST_CODE_VIDEO".hashCode() & 0xFFFF;
    Iza = "GameLocalGalleryView_REQUEST_CODE_IMAGE".hashCode() & 0xFFFF;
    AppMethodBeat.o(41027);
  }
  
  public GameLocalGalleryView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41016);
    this.Izh = false;
    this.Izi = false;
    this.IyH = 0;
    this.HMR = 0L;
    init();
    AppMethodBeat.o(41016);
  }
  
  public GameLocalGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41017);
    this.Izh = false;
    this.Izi = false;
    this.IyH = 0;
    this.HMR = 0L;
    init();
    AppMethodBeat.o(41017);
  }
  
  public GameLocalGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41018);
    this.Izh = false;
    this.Izi = false;
    this.IyH = 0;
    this.HMR = 0L;
    init();
    AppMethodBeat.o(41018);
  }
  
  static void fFq()
  {
    AppMethodBeat.i(41023);
    a.Xq(2);
    AppMethodBeat.o(41023);
  }
  
  private void init()
  {
    AppMethodBeat.i(41019);
    View localView = LayoutInflater.from(getContext()).inflate(h.f.Iae, this, false);
    this.Izb = ((RecyclerView)localView.findViewById(h.e.HVY));
    GameGridLayoutManager localGameGridLayoutManager = new GameGridLayoutManager(getContext());
    this.Izb.setLayoutManager(localGameGridLayoutManager);
    this.Izb.a(new GameLocalGalleryView.a(this));
    this.Izc = new c(getContext());
    this.Izb.setAdapter(this.Izc);
    this.Izd = ((TextView)localView.findViewById(h.e.HWc));
    this.Izd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40997);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GameLocalGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = GameLocalGalleryView.a(GameLocalGalleryView.this);
        int i;
        if (paramAnonymousView.HLB != null)
        {
          i = paramAnonymousView.HLB.size();
          if (i <= 0) {
            break label175;
          }
          paramAnonymousView = new Intent(GameLocalGalleryView.this.getContext(), ImagePreviewUI.class);
          paramAnonymousView.putStringArrayListExtra("preview_image_list", GameLocalGalleryView.a(GameLocalGalleryView.this).fBk());
          paramAnonymousView.putParcelableArrayListExtra("preview_media_item_list", GameLocalGalleryView.c.a(GameLocalGalleryView.a(GameLocalGalleryView.this)));
          paramAnonymousView.putExtra("max_select_count", GameLocalGalleryView.b(GameLocalGalleryView.this));
          paramAnonymousView.putExtra("send_raw_img", false);
          c.b(GameLocalGalleryView.this.getContext(), "gallery", ".ui.ImagePreviewUI", paramAnonymousView, GameLocalGalleryView.Iza);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(40997);
          return;
          i = 0;
          break;
          label175:
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_game_haowan_text", true);
          ((Activity)GameLocalGalleryView.this.getContext()).setResult(-1, paramAnonymousView);
          ((Activity)GameLocalGalleryView.this.getContext()).finish();
        }
      }
    });
    this.Ize = ((Button)localView.findViewById(h.e.HWa));
    this.Ize.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40998);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GameLocalGalleryView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        localObject = GameLocalGalleryView.a(GameLocalGalleryView.this).HLB;
        paramAnonymousView = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject).next();
          if ((localMediaItem.mMimeType.equals("edit")) && (!Util.isNullOrNil(localMediaItem.HHI))) {
            paramAnonymousView.add(localMediaItem.HHI);
          } else {
            paramAnonymousView.add(localMediaItem.Gcc);
          }
        }
        if (!Util.isNullOrNil(paramAnonymousView)) {
          GameLocalGalleryView.fFr();
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImage_OutputPath_List", paramAnonymousView);
        ((Activity)GameLocalGalleryView.this.getContext()).setResult(-1, (Intent)localObject);
        ((Activity)GameLocalGalleryView.this.getContext()).finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(40998);
      }
    });
    this.Izc.Izk = new GameLocalGalleryView.3(this);
    addView(localView, -1, -1);
    AppMethodBeat.o(41019);
  }
  
  private void jg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41024);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8767, paramInt1, paramInt2, this.IyH, com.tencent.mm.game.report.b.a.a(7, localHashMap));
    AppMethodBeat.o(41024);
  }
  
  public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(276859);
    if (this.HMR == paramLong)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramLinkedList != null) {
        localArrayList.addAll(paramLinkedList);
      }
      if (this.Izc != null) {
        MMHandlerThread.postToMainThread(new GameLocalGalleryView.c.3(this.Izc, localArrayList));
      }
    }
    AppMethodBeat.o(276859);
  }
  
  public final void d(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(276858);
    this.Izh = paramBoolean1;
    if ((this.Izh) && (this.Izd != null)) {
      this.Izd.setVisibility(8);
    }
    this.Izi = paramBoolean2;
    this.IyH = paramInt;
    AppMethodBeat.o(276858);
  }
  
  public final void fFo()
  {
    AppMethodBeat.i(41020);
    if (!this.Izg) {
      jg(0, 1);
    }
    this.Izg = true;
    AppMethodBeat.o(41020);
  }
  
  public final void fFp()
  {
    AppMethodBeat.i(41022);
    c localc = this.Izc;
    localc.HLB.clear();
    if (localc.Izk != null) {
      localc.Izk.Ng(localc.HLB.size());
    }
    localc.Izj.postDelayed(new GameLocalGalleryView.c.4(localc), 500L);
    AppMethodBeat.o(41022);
  }
  
  public void setQueryType(int paramInt)
  {
    AppMethodBeat.i(41021);
    this.Izc.HIa = paramInt;
    com.tencent.mm.plugin.gallery.model.e.fAn().setQueryType(paramInt);
    com.tencent.mm.plugin.gallery.model.e.fAn().sfB = 15;
    com.tencent.mm.plugin.gallery.model.e.fAn().a(this);
    this.HMR = System.currentTimeMillis();
    com.tencent.mm.plugin.gallery.model.e.fAn().aI("", this.HMR);
    AppMethodBeat.o(41021);
  }
  
  public void setSelectLimitCount(int paramInt)
  {
    this.Izc.HLz = paramInt;
    this.Izf = paramInt;
  }
  
  static abstract interface b
  {
    public abstract void Ng(int paramInt);
  }
  
  final class c
    extends RecyclerView.a<GameLocalGalleryView.d>
  {
    int HIa;
    private ArrayList<GalleryItem.MediaItem> HLA;
    ArrayList<GalleryItem.MediaItem> HLB;
    private View.OnClickListener HLI;
    int HLz;
    GameLocalGalleryView.b Izk;
    private Context mContext;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(41009);
      this.HLA = new ArrayList();
      this.HLB = new ArrayList();
      this.HLI = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41008);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          if (!(paramAnonymousView.getTag(h.e.media_cbx_clickarea) instanceof Integer))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          localObject = (Integer)paramAnonymousView.getTag(h.e.media_cbx_clickarea);
          if (localObject == null)
          {
            Log.e("MicroMsg.GameLocalMediaView", "[onClick] null == position!");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          localObject = (GalleryItem.MediaItem)GameLocalGalleryView.c.e(GameLocalGalleryView.c.this).get(((Integer)localObject).intValue());
          if ((localObject == null) || (Util.isNullOrNil(((GalleryItem.MediaItem)localObject).Gcc)))
          {
            Log.e("MicroMsg.GameLocalMediaView", "[onClick] null == item!");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          Log.i("MicroMsg.GameLocalMediaView", "click Image path:" + ((GalleryItem.MediaItem)localObject).Gcc);
          int i;
          int j;
          if (GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).contains(localObject))
          {
            GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).remove(localObject);
            i = 1;
            j = 0;
          }
          for (;;)
          {
            if (j != 0)
            {
              if (GameLocalGalleryView.c.f(GameLocalGalleryView.c.this) == 1) {
                k.cZ(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(h.g.gallery_pic_limit, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
              }
            }
            else
            {
              label294:
              if (1 != i) {
                break label657;
              }
              ((CheckBox)paramAnonymousView.getTag(h.e.media_cbx)).setChecked(false);
              ((View)paramAnonymousView.getTag(h.e.media_mask)).setVisibility(0);
              ((View)paramAnonymousView.getTag(h.e.media_mask)).setBackgroundResource(h.b.image_gallery_mask);
            }
            for (;;)
            {
              if (GameLocalGalleryView.c.g(GameLocalGalleryView.c.this) != null) {
                GameLocalGalleryView.c.g(GameLocalGalleryView.c.this).Ng(GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).size());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(41008);
              return;
              if ((com.tencent.mm.plugin.gallery.model.e.fAn().sfB == 3) && (localObject != null) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")))
              {
                y.bEl(((GalleryItem.MediaItem)localObject).Gcc);
                if (!((d)com.tencent.mm.kernel.h.az(d.class)).getProvider().aot(((GalleryItem.MediaItem)localObject).Gcc))
                {
                  k.cZ(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getString(h.i.gallery_select_gif_to_big));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(41008);
                  return;
                }
              }
              if (GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).size() >= GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) {
                break label715;
              }
              GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).add(localObject);
              i = 0;
              j = 0;
              break;
              if (GameLocalGalleryView.c.f(GameLocalGalleryView.c.this) == 2)
              {
                k.cZ(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(h.g.gallery_video_limit, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
                break label294;
              }
              k.cZ(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(h.g.gallery_pic_or_video_limit, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
              break label294;
              label657:
              ((CheckBox)paramAnonymousView.getTag(h.e.media_cbx)).setChecked(true);
              ((View)paramAnonymousView.getTag(h.e.media_mask)).setVisibility(0);
              ((View)paramAnonymousView.getTag(h.e.media_mask)).setBackgroundResource(h.b.UN_BW_0_Alpha_0_5);
              GameLocalGalleryView.a(GameLocalGalleryView.this, 1);
            }
            label715:
            i = 1;
            j = 1;
          }
        }
      };
      this.mContext = paramContext;
      this.HLA.add(new GalleryItem.ImageMediaItem());
      Log.i("MicroMsg.GameLocalMediaView", "RecycleViewAdapter");
      AppMethodBeat.o(41009);
    }
    
    final ArrayList<GalleryItem.MediaItem> WE(int paramInt)
    {
      AppMethodBeat.i(276860);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.HLA.iterator();
      while (localIterator.hasNext())
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
        if (localMediaItem.getType() == paramInt) {
          localArrayList.add(localMediaItem);
        }
      }
      AppMethodBeat.o(276860);
      return localArrayList;
    }
    
    final void aP(ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(41012);
      Log.d("MicroMsg.GameLocalMediaView", "before set selected paths, selected[%s]", new Object[] { this.HLB });
      this.HLB.clear();
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(0, 0L, str, str, "");
          if (com.tencent.mm.plugin.gallery.model.e.fAp() != null)
          {
            int i = com.tencent.mm.plugin.gallery.model.e.fAp().indexOf(localMediaItem);
            if (i >= 0)
            {
              localMediaItem = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.fAp().get(i);
              if ((localMediaItem != null) && (localMediaItem.getType() == 2))
              {
                this.HLB.add(GalleryItem.MediaItem.a(2, 0L, str, "", ""));
                continue;
              }
            }
          }
          Log.d("MicroMsg.GameLocalMediaView", "media item no exist on preview items.");
          this.HLB.add(GalleryItem.MediaItem.a(1, 0L, str, "", ""));
        }
      }
      Log.d("MicroMsg.GameLocalMediaView", "after set selected paths, selected[%s]", new Object[] { this.HLB });
      if (this.Izk != null) {
        this.Izk.Ng(this.HLB.size());
      }
      MMHandlerThread.postToMainThread(new GameLocalGalleryView.c.5(this));
      AppMethodBeat.o(41012);
    }
    
    public final ArrayList<String> fBk()
    {
      AppMethodBeat.i(41011);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.HLB.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).Gcc);
      }
      AppMethodBeat.o(41011);
      return localArrayList;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(41010);
      Log.i("MicroMsg.GameLocalMediaView", "getItemCount, count : %d", new Object[] { Integer.valueOf(this.HLA.size()) });
      int i = this.HLA.size();
      AppMethodBeat.o(41010);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView
 * JD-Core Version:    0.7.0.1
 */