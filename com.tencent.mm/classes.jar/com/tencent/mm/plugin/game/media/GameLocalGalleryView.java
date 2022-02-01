package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.game.widget.GameGridLayoutManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLocalGalleryView
  extends FrameLayout
{
  static final int tXB;
  static final int tXC;
  private RecyclerView tXD;
  c tXE;
  private TextView tXF;
  private Button tXG;
  private int tXH;
  private boolean tXI;
  
  static
  {
    AppMethodBeat.i(41027);
    tXB = "GameLocalGalleryView_REQUEST_CODE_VIDEO".hashCode() & 0xFFFF;
    tXC = "GameLocalGalleryView_REQUEST_CODE_IMAGE".hashCode() & 0xFFFF;
    AppMethodBeat.o(41027);
  }
  
  public GameLocalGalleryView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41016);
    init();
    AppMethodBeat.o(41016);
  }
  
  public GameLocalGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41017);
    init();
    AppMethodBeat.o(41017);
  }
  
  public GameLocalGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41018);
    init();
    AppMethodBeat.o(41018);
  }
  
  static void cXV()
  {
    AppMethodBeat.i(41023);
    a.HD(2);
    AppMethodBeat.o(41023);
  }
  
  private static void gl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41024);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.game.report.b.a.a(aj.getContext(), 8767, paramInt1, paramInt2, com.tencent.mm.game.report.b.a.a(7, localHashMap));
    AppMethodBeat.o(41024);
  }
  
  private void init()
  {
    AppMethodBeat.i(41019);
    View localView = LayoutInflater.from(getContext()).inflate(2131494368, this, false);
    this.tXD = ((RecyclerView)localView.findViewById(2131300504));
    getContext();
    GameGridLayoutManager localGameGridLayoutManager = new GameGridLayoutManager((byte)0);
    this.tXD.setLayoutManager(localGameGridLayoutManager);
    this.tXD.a(new a());
    this.tXE = new c(getContext());
    this.tXD.setAdapter(this.tXE);
    this.tXF = ((TextView)localView.findViewById(2131300507));
    this.tXF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40997);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameLocalGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = GameLocalGalleryView.a(GameLocalGalleryView.this);
        int i;
        if (paramAnonymousView.tLo != null)
        {
          i = paramAnonymousView.tLo.size();
          if (i <= 0) {
            break label175;
          }
          paramAnonymousView = new Intent(GameLocalGalleryView.this.getContext(), ImagePreviewUI.class);
          paramAnonymousView.putStringArrayListExtra("preview_image_list", GameLocalGalleryView.a(GameLocalGalleryView.this).cVN());
          paramAnonymousView.putParcelableArrayListExtra("preview_media_item_list", GameLocalGalleryView.c.a(GameLocalGalleryView.a(GameLocalGalleryView.this)));
          paramAnonymousView.putExtra("max_select_count", GameLocalGalleryView.b(GameLocalGalleryView.this));
          paramAnonymousView.putExtra("send_raw_img", false);
          com.tencent.mm.bs.d.b(GameLocalGalleryView.this.getContext(), "gallery", ".ui.ImagePreviewUI", paramAnonymousView, GameLocalGalleryView.tXC);
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
    this.tXG = ((Button)localView.findViewById(2131300506));
    this.tXG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40998);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameLocalGalleryView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        localObject = GameLocalGalleryView.a(GameLocalGalleryView.this).tLo;
        paramAnonymousView = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject).next();
          if ((localMediaItem.mMimeType.equals("edit")) && (!bt.isNullOrNil(localMediaItem.tGU))) {
            paramAnonymousView.add(localMediaItem.tGU);
          } else {
            paramAnonymousView.add(localMediaItem.tGS);
          }
        }
        if (!bt.hj(paramAnonymousView)) {
          GameLocalGalleryView.cXW();
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImage_OutputPath_List", paramAnonymousView);
        ((Activity)GameLocalGalleryView.this.getContext()).setResult(-1, (Intent)localObject);
        ((Activity)GameLocalGalleryView.this.getContext()).finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(40998);
      }
    });
    this.tXE.tXK = new b()
    {
      public final void HI(int paramAnonymousInt)
      {
        AppMethodBeat.i(40999);
        if (paramAnonymousInt > 0)
        {
          GameLocalGalleryView.c(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131759923, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(GameLocalGalleryView.b(GameLocalGalleryView.this)) }));
          GameLocalGalleryView.c(GameLocalGalleryView.this).setEnabled(true);
          GameLocalGalleryView.d(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131759924));
          AppMethodBeat.o(40999);
          return;
        }
        GameLocalGalleryView.c(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131759922));
        GameLocalGalleryView.c(GameLocalGalleryView.this).setEnabled(false);
        GameLocalGalleryView.d(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131766521));
        AppMethodBeat.o(40999);
      }
    };
    addView(localView, -1, -1);
    AppMethodBeat.o(41019);
  }
  
  public final void cXT()
  {
    AppMethodBeat.i(41020);
    if (!this.tXI) {
      gl(0, 1);
    }
    this.tXI = true;
    AppMethodBeat.o(41020);
  }
  
  public final void cXU()
  {
    AppMethodBeat.i(41022);
    c localc = this.tXE;
    localc.tLo.clear();
    if (localc.tXK != null) {
      localc.tXK.HI(localc.tLo.size());
    }
    localc.tXJ.postDelayed(new GameLocalGalleryView.c.4(localc), 500L);
    AppMethodBeat.o(41022);
  }
  
  public void setQueryType(int paramInt)
  {
    AppMethodBeat.i(41021);
    this.tXE.tHk = paramInt;
    a.a(paramInt, new a.c()
    {
      public final void au(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(41000);
        ArrayList localArrayList = new ArrayList();
        if (paramAnonymousLinkedList != null) {
          localArrayList.addAll(paramAnonymousLinkedList);
        }
        com.tencent.mm.sdk.platformtools.aq.f(new GameLocalGalleryView.c.3(GameLocalGalleryView.a(GameLocalGalleryView.this), localArrayList));
        AppMethodBeat.o(41000);
      }
    });
    AppMethodBeat.o(41021);
  }
  
  public void setSelectLimitCount(int paramInt)
  {
    this.tXE.tLm = paramInt;
    this.tXH = paramInt;
  }
  
  final class a
    extends RecyclerView.h
  {
    private int mSize;
    
    public a()
    {
      AppMethodBeat.i(41001);
      this.mSize = com.tencent.mm.ui.aq.fromDPToPix(aj.getContext(), 3);
      AppMethodBeat.o(41001);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(41002);
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      paramt = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
      int i = paramRecyclerView.apA;
      int j = RecyclerView.bw(paramView);
      int k = paramt.apH;
      ad.i("MicroMsg.GameLocalMediaView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", new Object[] { Integer.valueOf(paramt.apI), Integer.valueOf(i), Integer.valueOf(k) });
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
    public abstract void HI(int paramInt);
  }
  
  final class c
    extends RecyclerView.a<GameLocalGalleryView.d>
  {
    private Context mContext;
    int tHk;
    int tLm;
    ArrayList<GalleryItem.MediaItem> tLn;
    ArrayList<GalleryItem.MediaItem> tLo;
    private View.OnClickListener tLu;
    GameLocalGalleryView.b tXK;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(41009);
      this.tLn = new ArrayList();
      this.tLo = new ArrayList();
      this.tLu = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41008);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          if (!(paramAnonymousView.getTag(2131302205) instanceof Integer))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          localObject = (Integer)paramAnonymousView.getTag(2131302205);
          if (localObject == null)
          {
            ad.e("MicroMsg.GameLocalMediaView", "[onClick] null == position!");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          localObject = (GalleryItem.MediaItem)GameLocalGalleryView.c.e(GameLocalGalleryView.c.this).get(((Integer)localObject).intValue());
          if ((localObject == null) || (bt.isNullOrNil(((GalleryItem.MediaItem)localObject).tGS)))
          {
            ad.e("MicroMsg.GameLocalMediaView", "[onClick] null == item!");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          ad.i("MicroMsg.GameLocalMediaView", "click Image path:" + ((GalleryItem.MediaItem)localObject).tGS);
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
                h.cl(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623950, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
              }
            }
            else
            {
              label291:
              if (1 != i) {
                break label647;
              }
              ((CheckBox)paramAnonymousView.getTag(2131302204)).setChecked(false);
              ((View)paramAnonymousView.getTag(2131302212)).setVisibility(0);
              ((View)paramAnonymousView.getTag(2131302212)).setBackgroundResource(2131100506);
            }
            for (;;)
            {
              if (GameLocalGalleryView.c.g(GameLocalGalleryView.c.this) != null) {
                GameLocalGalleryView.c.g(GameLocalGalleryView.c.this).HI(GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).size());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(41008);
              return;
              if ((com.tencent.mm.plugin.gallery.model.e.cUM().kTx == 3) && (localObject != null) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")))
              {
                i.aYo(((GalleryItem.MediaItem)localObject).tGS);
                if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().abE(((GalleryItem.MediaItem)localObject).tGS))
                {
                  h.cl(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getString(2131759800));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(41008);
                  return;
                }
              }
              if (GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).size() >= GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) {
                break label694;
              }
              GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).add(localObject);
              i = 0;
              j = 0;
              break;
              if (GameLocalGalleryView.c.f(GameLocalGalleryView.c.this) == 2)
              {
                h.cl(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623952, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
                break label291;
              }
              h.cl(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623951, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
              break label291;
              label647:
              ((CheckBox)paramAnonymousView.getTag(2131302204)).setChecked(true);
              ((View)paramAnonymousView.getTag(2131302212)).setVisibility(0);
              ((View)paramAnonymousView.getTag(2131302212)).setBackgroundResource(2131099819);
              GameLocalGalleryView.HH(1);
            }
            label694:
            i = 1;
            j = 1;
          }
        }
      };
      this.mContext = paramContext;
      this.tLn.add(new GalleryItem.ImageMediaItem());
      ad.i("MicroMsg.GameLocalMediaView", "RecycleViewAdapter");
      AppMethodBeat.o(41009);
    }
    
    final void ac(ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(41012);
      ad.d("MicroMsg.GameLocalMediaView", "before set selected paths, selected[%s]", new Object[] { this.tLo });
      this.tLo.clear();
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(0, 0L, str, str, "");
          if (com.tencent.mm.plugin.gallery.model.e.cUO() != null)
          {
            int i = com.tencent.mm.plugin.gallery.model.e.cUO().indexOf(localMediaItem);
            if (i >= 0)
            {
              localMediaItem = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.cUO().get(i);
              if ((localMediaItem != null) && (localMediaItem.getType() == 2))
              {
                this.tLo.add(GalleryItem.MediaItem.a(2, 0L, str, "", ""));
                continue;
              }
            }
          }
          ad.d("MicroMsg.GameLocalMediaView", "media item no exist on preview items.");
          this.tLo.add(GalleryItem.MediaItem.a(1, 0L, str, "", ""));
        }
      }
      ad.d("MicroMsg.GameLocalMediaView", "after set selected paths, selected[%s]", new Object[] { this.tLo });
      if (this.tXK != null) {
        this.tXK.HI(this.tLo.size());
      }
      com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41007);
          GameLocalGalleryView.c.this.asY.notifyChanged();
          AppMethodBeat.o(41007);
        }
      });
      AppMethodBeat.o(41012);
    }
    
    public final ArrayList<String> cVN()
    {
      AppMethodBeat.i(41011);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.tLo.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).tGS);
      }
      AppMethodBeat.o(41011);
      return localArrayList;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(41010);
      ad.i("MicroMsg.GameLocalMediaView", "getItemCount, count : %d", new Object[] { Integer.valueOf(this.tLn.size()) });
      int i = this.tLn.size();
      AppMethodBeat.o(41010);
      return i;
    }
  }
  
  final class d
    extends RecyclerView.w
  {
    CheckBox iCK;
    View rCP;
    ImageView tCh;
    ImageView tLy;
    ImageView tPq;
    RelativeLayout tPr;
    TextView tPs;
    ImageView tPu;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(41015);
      this.tPq = ((ImageView)paramView.findViewById(2131302216));
      this.tCh = ((ImageView)paramView.findViewById(2131302221));
      this.tPr = ((RelativeLayout)paramView.findViewById(2131306355));
      this.tPs = ((TextView)paramView.findViewById(2131306357));
      this.iCK = ((CheckBox)paramView.findViewById(2131302204));
      this.rCP = paramView.findViewById(2131302205);
      this.tLy = ((ImageView)paramView.findViewById(2131302212));
      this.rCP.setTag(2131302204, this.iCK);
      this.rCP.setTag(2131302212, this.tLy);
      this.tPu = ((ImageView)paramView.findViewById(2131299258));
      AppMethodBeat.o(41015);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView
 * JD-Core Version:    0.7.0.1
 */