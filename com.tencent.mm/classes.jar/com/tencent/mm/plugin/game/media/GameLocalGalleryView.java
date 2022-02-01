package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.g;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.widget.GameGridLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLocalGalleryView
  extends FrameLayout
  implements i.c
{
  static final int CEW;
  static final int CEX;
  private int CEE;
  private RecyclerView CEY;
  c CEZ;
  private TextView CFa;
  private Button CFb;
  private int CFc;
  private boolean CFd;
  private boolean CFe;
  private long CaP;
  private boolean jzt;
  
  static
  {
    AppMethodBeat.i(41027);
    CEW = "GameLocalGalleryView_REQUEST_CODE_VIDEO".hashCode() & 0xFFFF;
    CEX = "GameLocalGalleryView_REQUEST_CODE_IMAGE".hashCode() & 0xFFFF;
    AppMethodBeat.o(41027);
  }
  
  public GameLocalGalleryView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41016);
    this.CFd = false;
    this.CFe = false;
    this.CEE = 0;
    this.CaP = 0L;
    init();
    AppMethodBeat.o(41016);
  }
  
  public GameLocalGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41017);
    this.CFd = false;
    this.CFe = false;
    this.CEE = 0;
    this.CaP = 0L;
    init();
    AppMethodBeat.o(41017);
  }
  
  public GameLocalGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41018);
    this.CFd = false;
    this.CFe = false;
    this.CEE = 0;
    this.CaP = 0L;
    init();
    AppMethodBeat.o(41018);
  }
  
  static void exu()
  {
    AppMethodBeat.i(41023);
    a.Tw(2);
    AppMethodBeat.o(41023);
  }
  
  private void hD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41024);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8767, paramInt1, paramInt2, this.CEE, com.tencent.mm.game.report.b.a.b(7, localHashMap));
    AppMethodBeat.o(41024);
  }
  
  private void init()
  {
    AppMethodBeat.i(41019);
    View localView = LayoutInflater.from(getContext()).inflate(g.f.CnW, this, false);
    this.CEY = ((RecyclerView)localView.findViewById(g.e.CjQ));
    GameGridLayoutManager localGameGridLayoutManager = new GameGridLayoutManager(getContext());
    this.CEY.setLayoutManager(localGameGridLayoutManager);
    this.CEY.a(new a());
    this.CEZ = new c(getContext());
    this.CEY.setAdapter(this.CEZ);
    this.CFa = ((TextView)localView.findViewById(g.e.CjU));
    this.CFa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40997);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GameLocalGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = GameLocalGalleryView.a(GameLocalGalleryView.this);
        int i;
        if (paramAnonymousView.BZH != null)
        {
          i = paramAnonymousView.BZH.size();
          if (i <= 0) {
            break label175;
          }
          paramAnonymousView = new Intent(GameLocalGalleryView.this.getContext(), ImagePreviewUI.class);
          paramAnonymousView.putStringArrayListExtra("preview_image_list", GameLocalGalleryView.a(GameLocalGalleryView.this).eun());
          paramAnonymousView.putParcelableArrayListExtra("preview_media_item_list", GameLocalGalleryView.c.a(GameLocalGalleryView.a(GameLocalGalleryView.this)));
          paramAnonymousView.putExtra("max_select_count", GameLocalGalleryView.b(GameLocalGalleryView.this));
          paramAnonymousView.putExtra("send_raw_img", false);
          c.b(GameLocalGalleryView.this.getContext(), "gallery", ".ui.ImagePreviewUI", paramAnonymousView, GameLocalGalleryView.CEX);
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
    this.CFb = ((Button)localView.findViewById(g.e.CjS));
    this.CFb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40998);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GameLocalGalleryView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        localObject = GameLocalGalleryView.a(GameLocalGalleryView.this).BZH;
        paramAnonymousView = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject).next();
          if ((localMediaItem.mMimeType.equals("edit")) && (!Util.isNullOrNil(localMediaItem.BVk))) {
            paramAnonymousView.add(localMediaItem.BVk);
          } else {
            paramAnonymousView.add(localMediaItem.AAz);
          }
        }
        if (!Util.isNullOrNil(paramAnonymousView)) {
          GameLocalGalleryView.exv();
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImage_OutputPath_List", paramAnonymousView);
        ((Activity)GameLocalGalleryView.this.getContext()).setResult(-1, (Intent)localObject);
        ((Activity)GameLocalGalleryView.this.getContext()).finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(40998);
      }
    });
    this.CEZ.CFg = new b()
    {
      public final void Mc(int paramAnonymousInt)
      {
        AppMethodBeat.i(40999);
        if (paramAnonymousInt > 0)
        {
          GameLocalGalleryView.c(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(g.i.Cph, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(GameLocalGalleryView.b(GameLocalGalleryView.this)) }));
          GameLocalGalleryView.c(GameLocalGalleryView.this).setEnabled(true);
          GameLocalGalleryView.d(GameLocalGalleryView.this).setVisibility(0);
          GameLocalGalleryView.d(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(g.i.CjU));
          AppMethodBeat.o(40999);
          return;
        }
        GameLocalGalleryView.c(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(g.i.CjS));
        GameLocalGalleryView.c(GameLocalGalleryView.this).setEnabled(false);
        if (!GameLocalGalleryView.e(GameLocalGalleryView.this))
        {
          GameLocalGalleryView.d(GameLocalGalleryView.this).setVisibility(0);
          GameLocalGalleryView.d(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(g.i.CjT));
          AppMethodBeat.o(40999);
          return;
        }
        GameLocalGalleryView.d(GameLocalGalleryView.this).setVisibility(8);
        AppMethodBeat.o(40999);
      }
    };
    addView(localView, -1, -1);
    AppMethodBeat.o(41019);
  }
  
  public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(292933);
    if (this.CaP == paramLong)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramLinkedList != null) {
        localArrayList.addAll(paramLinkedList);
      }
      if (this.CEZ != null) {
        MMHandlerThread.postToMainThread(new GameLocalGalleryView.c.3(this.CEZ, localArrayList));
      }
    }
    AppMethodBeat.o(292933);
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(200131);
    this.CFd = paramBoolean1;
    if ((this.CFd) && (this.CFa != null)) {
      this.CFa.setVisibility(8);
    }
    this.CFe = paramBoolean2;
    this.CEE = paramInt;
    AppMethodBeat.o(200131);
  }
  
  public final void exs()
  {
    AppMethodBeat.i(41020);
    if (!this.jzt) {
      hD(0, 1);
    }
    this.jzt = true;
    AppMethodBeat.o(41020);
  }
  
  public final void ext()
  {
    AppMethodBeat.i(41022);
    c localc = this.CEZ;
    localc.BZH.clear();
    if (localc.CFg != null) {
      localc.CFg.Mc(localc.BZH.size());
    }
    localc.CFf.postDelayed(new GameLocalGalleryView.c.4(localc), 500L);
    AppMethodBeat.o(41022);
  }
  
  public void setQueryType(int paramInt)
  {
    AppMethodBeat.i(41021);
    this.CEZ.BVD = paramInt;
    com.tencent.mm.plugin.gallery.model.e.etl().setQueryType(paramInt);
    com.tencent.mm.plugin.gallery.model.e.etl().pag = 15;
    com.tencent.mm.plugin.gallery.model.e.etl().a(this);
    this.CaP = System.currentTimeMillis();
    com.tencent.mm.plugin.gallery.model.e.etl().ax("", this.CaP);
    AppMethodBeat.o(41021);
  }
  
  public void setSelectLimitCount(int paramInt)
  {
    this.CEZ.BZF = paramInt;
    this.CFc = paramInt;
  }
  
  final class a
    extends RecyclerView.h
  {
    private int mSize;
    
    public a()
    {
      AppMethodBeat.i(41001);
      this.mSize = aw.fromDPToPix(MMApplicationContext.getContext(), 3);
      AppMethodBeat.o(41001);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(204998);
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      params = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
      int i = paramRecyclerView.ahF;
      int j = RecyclerView.bh(paramView);
      int k = params.ahM;
      Log.i("MicroMsg.GameLocalMediaView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", new Object[] { Integer.valueOf(params.ahN), Integer.valueOf(i), Integer.valueOf(k) });
      if (j < i)
      {
        if (k == 0)
        {
          paramRect.set(0, 0, 0, 0);
          AppMethodBeat.o(204998);
          return;
        }
        paramRect.set(this.mSize, 0, 0, 0);
        AppMethodBeat.o(204998);
        return;
      }
      if (k == 0)
      {
        paramRect.set(0, this.mSize, 0, 0);
        AppMethodBeat.o(204998);
        return;
      }
      paramRect.set(this.mSize, this.mSize, 0, 0);
      AppMethodBeat.o(204998);
    }
  }
  
  static abstract interface b
  {
    public abstract void Mc(int paramInt);
  }
  
  final class c
    extends RecyclerView.a<GameLocalGalleryView.d>
  {
    int BVD;
    int BZF;
    private ArrayList<GalleryItem.MediaItem> BZG;
    ArrayList<GalleryItem.MediaItem> BZH;
    private View.OnClickListener BZN;
    GameLocalGalleryView.b CFg;
    private Context mContext;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(41009);
      this.BZG = new ArrayList();
      this.BZH = new ArrayList();
      this.BZN = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41008);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          if (!(paramAnonymousView.getTag(g.e.media_cbx_clickarea) instanceof Integer))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          localObject = (Integer)paramAnonymousView.getTag(g.e.media_cbx_clickarea);
          if (localObject == null)
          {
            Log.e("MicroMsg.GameLocalMediaView", "[onClick] null == position!");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          localObject = (GalleryItem.MediaItem)GameLocalGalleryView.c.e(GameLocalGalleryView.c.this).get(((Integer)localObject).intValue());
          if ((localObject == null) || (Util.isNullOrNil(((GalleryItem.MediaItem)localObject).AAz)))
          {
            Log.e("MicroMsg.GameLocalMediaView", "[onClick] null == item!");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          Log.i("MicroMsg.GameLocalMediaView", "click Image path:" + ((GalleryItem.MediaItem)localObject).AAz);
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
                com.tencent.mm.ui.base.h.cO(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(g.g.gallery_pic_limit, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
              }
            }
            else
            {
              label294:
              if (1 != i) {
                break label657;
              }
              ((CheckBox)paramAnonymousView.getTag(g.e.media_cbx)).setChecked(false);
              ((View)paramAnonymousView.getTag(g.e.media_mask)).setVisibility(0);
              ((View)paramAnonymousView.getTag(g.e.media_mask)).setBackgroundResource(g.b.image_gallery_mask);
            }
            for (;;)
            {
              if (GameLocalGalleryView.c.g(GameLocalGalleryView.c.this) != null) {
                GameLocalGalleryView.c.g(GameLocalGalleryView.c.this).Mc(GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).size());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(41008);
              return;
              if ((com.tencent.mm.plugin.gallery.model.e.etl().pag == 3) && (localObject != null) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")))
              {
                u.bBQ(((GalleryItem.MediaItem)localObject).AAz);
                if (!((d)com.tencent.mm.kernel.h.ag(d.class)).getProvider().aus(((GalleryItem.MediaItem)localObject).AAz))
                {
                  com.tencent.mm.ui.base.h.cO(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getString(g.i.gallery_select_gif_to_big));
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
                com.tencent.mm.ui.base.h.cO(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(g.g.gallery_video_limit, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
                break label294;
              }
              com.tencent.mm.ui.base.h.cO(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(g.g.gallery_pic_or_video_limit, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
              break label294;
              label657:
              ((CheckBox)paramAnonymousView.getTag(g.e.media_cbx)).setChecked(true);
              ((View)paramAnonymousView.getTag(g.e.media_mask)).setVisibility(0);
              ((View)paramAnonymousView.getTag(g.e.media_mask)).setBackgroundResource(g.b.UN_BW_0_Alpha_0_5);
              GameLocalGalleryView.a(GameLocalGalleryView.this, 1);
            }
            label715:
            i = 1;
            j = 1;
          }
        }
      };
      this.mContext = paramContext;
      this.BZG.add(new GalleryItem.ImageMediaItem());
      Log.i("MicroMsg.GameLocalMediaView", "RecycleViewAdapter");
      AppMethodBeat.o(41009);
    }
    
    final ArrayList<GalleryItem.MediaItem> SX(int paramInt)
    {
      AppMethodBeat.i(190346);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.BZG.iterator();
      while (localIterator.hasNext())
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
        if (localMediaItem.getType() == paramInt) {
          localArrayList.add(localMediaItem);
        }
      }
      AppMethodBeat.o(190346);
      return localArrayList;
    }
    
    final void aw(ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(41012);
      Log.d("MicroMsg.GameLocalMediaView", "before set selected paths, selected[%s]", new Object[] { this.BZH });
      this.BZH.clear();
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(0, 0L, str, str, "");
          if (com.tencent.mm.plugin.gallery.model.e.etn() != null)
          {
            int i = com.tencent.mm.plugin.gallery.model.e.etn().indexOf(localMediaItem);
            if (i >= 0)
            {
              localMediaItem = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.etn().get(i);
              if ((localMediaItem != null) && (localMediaItem.getType() == 2))
              {
                this.BZH.add(GalleryItem.MediaItem.a(2, 0L, str, "", ""));
                continue;
              }
            }
          }
          Log.d("MicroMsg.GameLocalMediaView", "media item no exist on preview items.");
          this.BZH.add(GalleryItem.MediaItem.a(1, 0L, str, "", ""));
        }
      }
      Log.d("MicroMsg.GameLocalMediaView", "after set selected paths, selected[%s]", new Object[] { this.BZH });
      if (this.CFg != null) {
        this.CFg.Mc(this.BZH.size());
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41007);
          GameLocalGalleryView.c.this.alc.notifyChanged();
          AppMethodBeat.o(41007);
        }
      });
      AppMethodBeat.o(41012);
    }
    
    public final ArrayList<String> eun()
    {
      AppMethodBeat.i(41011);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.BZH.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).AAz);
      }
      AppMethodBeat.o(41011);
      return localArrayList;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(41010);
      Log.i("MicroMsg.GameLocalMediaView", "getItemCount, count : %d", new Object[] { Integer.valueOf(this.BZG.size()) });
      int i = this.BZG.size();
      AppMethodBeat.o(41010);
      return i;
    }
  }
  
  final class d
    extends RecyclerView.v
  {
    ImageView BPW;
    ImageView BZR;
    ImageView CdR;
    RelativeLayout CdS;
    TextView CdT;
    ImageView CdV;
    CheckBox checkBox;
    View wRk;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(41015);
      this.CdR = ((ImageView)paramView.findViewById(g.e.media_placeholder));
      this.BPW = ((ImageView)paramView.findViewById(g.e.media_thumb));
      this.CdS = ((RelativeLayout)paramView.findViewById(g.e.video_mask));
      this.CdT = ((TextView)paramView.findViewById(g.e.video_mask_tv));
      this.checkBox = ((CheckBox)paramView.findViewById(g.e.media_cbx));
      this.wRk = paramView.findViewById(g.e.media_cbx_clickarea);
      this.BZR = ((ImageView)paramView.findViewById(g.e.media_mask));
      this.wRk.setTag(g.e.media_cbx, this.checkBox);
      this.wRk.setTag(g.e.media_mask, this.BZR);
      this.CdV = ((ImageView)paramView.findViewById(g.e.edit_mark_iv));
      AppMethodBeat.o(41015);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView
 * JD-Core Version:    0.7.0.1
 */