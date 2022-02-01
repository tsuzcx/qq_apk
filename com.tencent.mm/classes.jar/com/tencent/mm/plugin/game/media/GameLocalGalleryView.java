package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.game.widget.GameGridLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GameLocalGalleryView
  extends FrameLayout
{
  static final int xAV;
  static final int xAW;
  private boolean gOZ;
  private int xAD;
  private RecyclerView xAX;
  c xAY;
  private TextView xAZ;
  private Button xBa;
  private int xBb;
  private boolean xBc;
  private boolean xBd;
  
  static
  {
    AppMethodBeat.i(41027);
    xAV = "GameLocalGalleryView_REQUEST_CODE_VIDEO".hashCode() & 0xFFFF;
    xAW = "GameLocalGalleryView_REQUEST_CODE_IMAGE".hashCode() & 0xFFFF;
    AppMethodBeat.o(41027);
  }
  
  public GameLocalGalleryView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41016);
    this.xBc = false;
    this.xBd = false;
    this.xAD = 0;
    init();
    AppMethodBeat.o(41016);
  }
  
  public GameLocalGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41017);
    this.xBc = false;
    this.xBd = false;
    this.xAD = 0;
    init();
    AppMethodBeat.o(41017);
  }
  
  public GameLocalGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41018);
    this.xBc = false;
    this.xBd = false;
    this.xAD = 0;
    init();
    AppMethodBeat.o(41018);
  }
  
  static void dUn()
  {
    AppMethodBeat.i(41023);
    a.Od(2);
    AppMethodBeat.o(41023);
  }
  
  private void gK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41024);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8767, paramInt1, paramInt2, this.xAD, com.tencent.mm.game.report.b.a.c(7, localHashMap));
    AppMethodBeat.o(41024);
  }
  
  private void init()
  {
    AppMethodBeat.i(41019);
    View localView = LayoutInflater.from(getContext()).inflate(2131494934, this, false);
    this.xAX = ((RecyclerView)localView.findViewById(2131302029));
    GameGridLayoutManager localGameGridLayoutManager = new GameGridLayoutManager(getContext());
    this.xAX.setLayoutManager(localGameGridLayoutManager);
    this.xAX.a(new a());
    this.xAY = new c(getContext());
    this.xAX.setAdapter(this.xAY);
    this.xAZ = ((TextView)localView.findViewById(2131302033));
    this.xAZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40997);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameLocalGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = GameLocalGalleryView.a(GameLocalGalleryView.this);
        int i;
        if (paramAnonymousView.xnp != null)
        {
          i = paramAnonymousView.xnp.size();
          if (i <= 0) {
            break label175;
          }
          paramAnonymousView = new Intent(GameLocalGalleryView.this.getContext(), ImagePreviewUI.class);
          paramAnonymousView.putStringArrayListExtra("preview_image_list", GameLocalGalleryView.a(GameLocalGalleryView.this).dRL());
          paramAnonymousView.putParcelableArrayListExtra("preview_media_item_list", GameLocalGalleryView.c.a(GameLocalGalleryView.a(GameLocalGalleryView.this)));
          paramAnonymousView.putExtra("max_select_count", GameLocalGalleryView.b(GameLocalGalleryView.this));
          paramAnonymousView.putExtra("send_raw_img", false);
          c.b(GameLocalGalleryView.this.getContext(), "gallery", ".ui.ImagePreviewUI", paramAnonymousView, GameLocalGalleryView.xAW);
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
    this.xBa = ((Button)localView.findViewById(2131302031));
    this.xBa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40998);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameLocalGalleryView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = GameLocalGalleryView.a(GameLocalGalleryView.this).xnp;
        paramAnonymousView = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject).next();
          if ((localMediaItem.mMimeType.equals("edit")) && (!Util.isNullOrNil(localMediaItem.xiY))) {
            paramAnonymousView.add(localMediaItem.xiY);
          } else {
            paramAnonymousView.add(localMediaItem.xiW);
          }
        }
        if (!Util.isNullOrNil(paramAnonymousView)) {
          GameLocalGalleryView.dUo();
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImage_OutputPath_List", paramAnonymousView);
        ((Activity)GameLocalGalleryView.this.getContext()).setResult(-1, (Intent)localObject);
        ((Activity)GameLocalGalleryView.this.getContext()).finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(40998);
      }
    });
    this.xAY.xBf = new b()
    {
      public final void Ir(int paramAnonymousInt)
      {
        AppMethodBeat.i(40999);
        if (paramAnonymousInt > 0)
        {
          GameLocalGalleryView.c(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131761271, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(GameLocalGalleryView.b(GameLocalGalleryView.this)) }));
          GameLocalGalleryView.c(GameLocalGalleryView.this).setEnabled(true);
          GameLocalGalleryView.d(GameLocalGalleryView.this).setVisibility(0);
          GameLocalGalleryView.d(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131761273));
          AppMethodBeat.o(40999);
          return;
        }
        GameLocalGalleryView.c(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131761270));
        GameLocalGalleryView.c(GameLocalGalleryView.this).setEnabled(false);
        if (!GameLocalGalleryView.e(GameLocalGalleryView.this))
        {
          GameLocalGalleryView.d(GameLocalGalleryView.this).setVisibility(0);
          GameLocalGalleryView.d(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131761272));
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
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(204114);
    this.xBc = paramBoolean1;
    if ((this.xBc) && (this.xAZ != null)) {
      this.xAZ.setVisibility(8);
    }
    this.xBd = paramBoolean2;
    this.xAD = paramInt;
    AppMethodBeat.o(204114);
  }
  
  public final void dUl()
  {
    AppMethodBeat.i(41020);
    if (!this.gOZ) {
      gK(0, 1);
    }
    this.gOZ = true;
    AppMethodBeat.o(41020);
  }
  
  public final void dUm()
  {
    AppMethodBeat.i(41022);
    c localc = this.xAY;
    localc.xnp.clear();
    if (localc.xBf != null) {
      localc.xBf.Ir(localc.xnp.size());
    }
    localc.xBe.postDelayed(new GameLocalGalleryView.c.4(localc), 500L);
    AppMethodBeat.o(41022);
  }
  
  public void setQueryType(int paramInt)
  {
    AppMethodBeat.i(41021);
    this.xAY.xjo = paramInt;
    a.a(paramInt, new GameLocalGalleryView.4(this));
    AppMethodBeat.o(41021);
  }
  
  public void setSelectLimitCount(int paramInt)
  {
    this.xAY.xnn = paramInt;
    this.xBb = paramInt;
  }
  
  final class a
    extends RecyclerView.h
  {
    private int mSize;
    
    public a()
    {
      AppMethodBeat.i(41001);
      this.mSize = at.fromDPToPix(MMApplicationContext.getContext(), 3);
      AppMethodBeat.o(41001);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(41002);
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      params = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
      int i = paramRecyclerView.apM;
      int j = RecyclerView.bw(paramView);
      int k = params.apT;
      Log.i("MicroMsg.GameLocalMediaView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", new Object[] { Integer.valueOf(params.apU), Integer.valueOf(i), Integer.valueOf(k) });
      if (j < i)
      {
        if (k == 0)
        {
          paramRect.set(0, 0, 0, 0);
          AppMethodBeat.o(41002);
          return;
        }
        paramRect.set(this.mSize, 0, 0, 0);
        AppMethodBeat.o(41002);
        return;
      }
      if (k == 0)
      {
        paramRect.set(0, this.mSize, 0, 0);
        AppMethodBeat.o(41002);
        return;
      }
      paramRect.set(this.mSize, this.mSize, 0, 0);
      AppMethodBeat.o(41002);
    }
  }
  
  static abstract interface b
  {
    public abstract void Ir(int paramInt);
  }
  
  final class c
    extends RecyclerView.a<GameLocalGalleryView.d>
  {
    private Context mContext;
    GameLocalGalleryView.b xBf;
    int xjo;
    int xnn;
    private ArrayList<GalleryItem.MediaItem> xno;
    ArrayList<GalleryItem.MediaItem> xnp;
    private View.OnClickListener xnv;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(41009);
      this.xno = new ArrayList();
      this.xnp = new ArrayList();
      this.xnv = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41008);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          if (!(paramAnonymousView.getTag(2131304551) instanceof Integer))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          localObject = (Integer)paramAnonymousView.getTag(2131304551);
          if (localObject == null)
          {
            Log.e("MicroMsg.GameLocalMediaView", "[onClick] null == position!");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          localObject = (GalleryItem.MediaItem)GameLocalGalleryView.c.e(GameLocalGalleryView.c.this).get(((Integer)localObject).intValue());
          if ((localObject == null) || (Util.isNullOrNil(((GalleryItem.MediaItem)localObject).xiW)))
          {
            Log.e("MicroMsg.GameLocalMediaView", "[onClick] null == item!");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          Log.i("MicroMsg.GameLocalMediaView", "click Image path:" + ((GalleryItem.MediaItem)localObject).xiW);
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
                h.cD(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623950, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
              }
            }
            else
            {
              label291:
              if (1 != i) {
                break label647;
              }
              ((CheckBox)paramAnonymousView.getTag(2131304550)).setChecked(false);
              ((View)paramAnonymousView.getTag(2131304563)).setVisibility(0);
              ((View)paramAnonymousView.getTag(2131304563)).setBackgroundResource(2131100641);
            }
            for (;;)
            {
              if (GameLocalGalleryView.c.g(GameLocalGalleryView.c.this) != null) {
                GameLocalGalleryView.c.g(GameLocalGalleryView.c.this).Ir(GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).size());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(41008);
              return;
              if ((com.tencent.mm.plugin.gallery.model.e.dQK().mcq == 3) && (localObject != null) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")))
              {
                s.boW(((GalleryItem.MediaItem)localObject).xiW);
                if (!((d)com.tencent.mm.kernel.g.ah(d.class)).getProvider().amz(((GalleryItem.MediaItem)localObject).xiW))
                {
                  h.cD(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getString(2131761128));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(41008);
                  return;
                }
              }
              if (GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).size() >= GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) {
                break label701;
              }
              GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).add(localObject);
              i = 0;
              j = 0;
              break;
              if (GameLocalGalleryView.c.f(GameLocalGalleryView.c.this) == 2)
              {
                h.cD(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623952, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
                break label291;
              }
              h.cD(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623951, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
              break label291;
              label647:
              ((CheckBox)paramAnonymousView.getTag(2131304550)).setChecked(true);
              ((View)paramAnonymousView.getTag(2131304563)).setVisibility(0);
              ((View)paramAnonymousView.getTag(2131304563)).setBackgroundResource(2131099835);
              GameLocalGalleryView.a(GameLocalGalleryView.this, 1);
            }
            label701:
            i = 1;
            j = 1;
          }
        }
      };
      this.mContext = paramContext;
      this.xno.add(new GalleryItem.ImageMediaItem());
      Log.i("MicroMsg.GameLocalMediaView", "RecycleViewAdapter");
      AppMethodBeat.o(41009);
    }
    
    final ArrayList<GalleryItem.MediaItem> NJ(int paramInt)
    {
      AppMethodBeat.i(204113);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.xno.iterator();
      while (localIterator.hasNext())
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
        if (localMediaItem.getType() == paramInt) {
          localArrayList.add(localMediaItem);
        }
      }
      AppMethodBeat.o(204113);
      return localArrayList;
    }
    
    final void aq(ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(41012);
      Log.d("MicroMsg.GameLocalMediaView", "before set selected paths, selected[%s]", new Object[] { this.xnp });
      this.xnp.clear();
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(0, 0L, str, str, "");
          if (com.tencent.mm.plugin.gallery.model.e.dQM() != null)
          {
            int i = com.tencent.mm.plugin.gallery.model.e.dQM().indexOf(localMediaItem);
            if (i >= 0)
            {
              localMediaItem = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.dQM().get(i);
              if ((localMediaItem != null) && (localMediaItem.getType() == 2))
              {
                this.xnp.add(GalleryItem.MediaItem.a(2, 0L, str, "", ""));
                continue;
              }
            }
          }
          Log.d("MicroMsg.GameLocalMediaView", "media item no exist on preview items.");
          this.xnp.add(GalleryItem.MediaItem.a(1, 0L, str, "", ""));
        }
      }
      Log.d("MicroMsg.GameLocalMediaView", "after set selected paths, selected[%s]", new Object[] { this.xnp });
      if (this.xBf != null) {
        this.xBf.Ir(this.xnp.size());
      }
      MMHandlerThread.postToMainThread(new GameLocalGalleryView.c.5(this));
      AppMethodBeat.o(41012);
    }
    
    public final ArrayList<String> dRL()
    {
      AppMethodBeat.i(41011);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.xnp.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).xiW);
      }
      AppMethodBeat.o(41011);
      return localArrayList;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(41010);
      Log.i("MicroMsg.GameLocalMediaView", "getItemCount, count : %d", new Object[] { Integer.valueOf(this.xno.size()) });
      int i = this.xno.size();
      AppMethodBeat.o(41010);
      return i;
    }
  }
  
  final class d
    extends RecyclerView.v
  {
    CheckBox checkBox;
    View tkM;
    ImageView xdY;
    ImageView xnz;
    ImageView xrA;
    ImageView xrw;
    RelativeLayout xrx;
    TextView xry;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(41015);
      this.xrw = ((ImageView)paramView.findViewById(2131304568));
      this.xdY = ((ImageView)paramView.findViewById(2131304573));
      this.xrx = ((RelativeLayout)paramView.findViewById(2131309781));
      this.xry = ((TextView)paramView.findViewById(2131309783));
      this.checkBox = ((CheckBox)paramView.findViewById(2131304550));
      this.tkM = paramView.findViewById(2131304551);
      this.xnz = ((ImageView)paramView.findViewById(2131304563));
      this.tkM.setTag(2131304550, this.checkBox);
      this.tkM.setTag(2131304563, this.xnz);
      this.xrA = ((ImageView)paramView.findViewById(2131299834));
      AppMethodBeat.o(41015);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView
 * JD-Core Version:    0.7.0.1
 */