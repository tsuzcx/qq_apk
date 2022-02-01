package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
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
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.game.widget.GameGridLayoutManager;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLocalGalleryView
  extends FrameLayout
{
  static final int uiB;
  static final int uiC;
  private RecyclerView uiD;
  c uiE;
  TextView uiF;
  private Button uiG;
  private int uiH;
  private boolean uiI;
  boolean uiJ;
  boolean uiK;
  
  static
  {
    AppMethodBeat.i(41027);
    uiB = "GameLocalGalleryView_REQUEST_CODE_VIDEO".hashCode() & 0xFFFF;
    uiC = "GameLocalGalleryView_REQUEST_CODE_IMAGE".hashCode() & 0xFFFF;
    AppMethodBeat.o(41027);
  }
  
  public GameLocalGalleryView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41016);
    this.uiJ = false;
    this.uiK = false;
    init();
    AppMethodBeat.o(41016);
  }
  
  public GameLocalGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41017);
    this.uiJ = false;
    this.uiK = false;
    init();
    AppMethodBeat.o(41017);
  }
  
  public GameLocalGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41018);
    this.uiJ = false;
    this.uiK = false;
    init();
    AppMethodBeat.o(41018);
  }
  
  static void daF()
  {
    AppMethodBeat.i(41023);
    a.Ia(2);
    AppMethodBeat.o(41023);
  }
  
  private static void gl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41024);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.game.report.b.a.a(ak.getContext(), 8767, paramInt1, paramInt2, com.tencent.mm.game.report.b.a.b(7, localHashMap));
    AppMethodBeat.o(41024);
  }
  
  private void init()
  {
    AppMethodBeat.i(41019);
    View localView = LayoutInflater.from(getContext()).inflate(2131494368, this, false);
    this.uiD = ((RecyclerView)localView.findViewById(2131300504));
    getContext();
    GameGridLayoutManager localGameGridLayoutManager = new GameGridLayoutManager((byte)0);
    this.uiD.setLayoutManager(localGameGridLayoutManager);
    this.uiD.a(new GameLocalGalleryView.a(this));
    this.uiE = new c(getContext());
    this.uiD.setAdapter(this.uiE);
    this.uiF = ((TextView)localView.findViewById(2131300507));
    this.uiF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40997);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameLocalGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = GameLocalGalleryView.a(GameLocalGalleryView.this);
        int i;
        if (paramAnonymousView.tWf != null)
        {
          i = paramAnonymousView.tWf.size();
          if (i <= 0) {
            break label175;
          }
          paramAnonymousView = new Intent(GameLocalGalleryView.this.getContext(), ImagePreviewUI.class);
          paramAnonymousView.putStringArrayListExtra("preview_image_list", GameLocalGalleryView.a(GameLocalGalleryView.this).cYs());
          paramAnonymousView.putParcelableArrayListExtra("preview_media_item_list", GameLocalGalleryView.c.a(GameLocalGalleryView.a(GameLocalGalleryView.this)));
          paramAnonymousView.putExtra("max_select_count", GameLocalGalleryView.b(GameLocalGalleryView.this));
          paramAnonymousView.putExtra("send_raw_img", false);
          com.tencent.mm.br.d.b(GameLocalGalleryView.this.getContext(), "gallery", ".ui.ImagePreviewUI", paramAnonymousView, GameLocalGalleryView.uiC);
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
    this.uiG = ((Button)localView.findViewById(2131300506));
    this.uiG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40998);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameLocalGalleryView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        localObject = GameLocalGalleryView.a(GameLocalGalleryView.this).tWf;
        paramAnonymousView = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject).next();
          if ((localMediaItem.mMimeType.equals("edit")) && (!bu.isNullOrNil(localMediaItem.tRL))) {
            paramAnonymousView.add(localMediaItem.tRL);
          } else {
            paramAnonymousView.add(localMediaItem.tRJ);
          }
        }
        if (!bu.ht(paramAnonymousView)) {
          GameLocalGalleryView.daG();
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImage_OutputPath_List", paramAnonymousView);
        ((Activity)GameLocalGalleryView.this.getContext()).setResult(-1, (Intent)localObject);
        ((Activity)GameLocalGalleryView.this.getContext()).finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(40998);
      }
    });
    this.uiE.uiM = new b()
    {
      public final void If(int paramAnonymousInt)
      {
        AppMethodBeat.i(40999);
        if (paramAnonymousInt > 0)
        {
          GameLocalGalleryView.c(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131759923, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(GameLocalGalleryView.b(GameLocalGalleryView.this)) }));
          GameLocalGalleryView.c(GameLocalGalleryView.this).setEnabled(true);
          GameLocalGalleryView.d(GameLocalGalleryView.this).setVisibility(0);
          GameLocalGalleryView.d(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131759924));
          AppMethodBeat.o(40999);
          return;
        }
        GameLocalGalleryView.c(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131759922));
        GameLocalGalleryView.c(GameLocalGalleryView.this).setEnabled(false);
        if (!GameLocalGalleryView.e(GameLocalGalleryView.this))
        {
          GameLocalGalleryView.d(GameLocalGalleryView.this).setVisibility(0);
          GameLocalGalleryView.d(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131766521));
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
  
  public final void daD()
  {
    AppMethodBeat.i(41020);
    if (!this.uiI) {
      gl(0, 1);
    }
    this.uiI = true;
    AppMethodBeat.o(41020);
  }
  
  public final void daE()
  {
    AppMethodBeat.i(41022);
    c localc = this.uiE;
    localc.tWf.clear();
    if (localc.uiM != null) {
      localc.uiM.If(localc.tWf.size());
    }
    localc.uiL.postDelayed(new GameLocalGalleryView.c.4(localc), 500L);
    AppMethodBeat.o(41022);
  }
  
  public void setQueryType(int paramInt)
  {
    AppMethodBeat.i(41021);
    this.uiE.tSb = paramInt;
    a.a(paramInt, new a.c()
    {
      public final void au(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(41000);
        ArrayList localArrayList = new ArrayList();
        if (paramAnonymousLinkedList != null) {
          localArrayList.addAll(paramAnonymousLinkedList);
        }
        ar.f(new GameLocalGalleryView.c.3(GameLocalGalleryView.a(GameLocalGalleryView.this), localArrayList));
        AppMethodBeat.o(41000);
      }
    });
    AppMethodBeat.o(41021);
  }
  
  public void setSelectLimitCount(int paramInt)
  {
    this.uiE.tWd = paramInt;
    this.uiH = paramInt;
  }
  
  static abstract interface b
  {
    public abstract void If(int paramInt);
  }
  
  final class c
    extends RecyclerView.a<GameLocalGalleryView.d>
  {
    private Context mContext;
    int tSb;
    int tWd;
    private ArrayList<GalleryItem.MediaItem> tWe;
    ArrayList<GalleryItem.MediaItem> tWf;
    private View.OnClickListener tWl;
    GameLocalGalleryView.b uiM;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(41009);
      this.tWe = new ArrayList();
      this.tWf = new ArrayList();
      this.tWl = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41008);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          if (!(paramAnonymousView.getTag(2131302205) instanceof Integer))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          localObject = (Integer)paramAnonymousView.getTag(2131302205);
          if (localObject == null)
          {
            ae.e("MicroMsg.GameLocalMediaView", "[onClick] null == position!");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          localObject = (GalleryItem.MediaItem)GameLocalGalleryView.c.e(GameLocalGalleryView.c.this).get(((Integer)localObject).intValue());
          if ((localObject == null) || (bu.isNullOrNil(((GalleryItem.MediaItem)localObject).tRJ)))
          {
            ae.e("MicroMsg.GameLocalMediaView", "[onClick] null == item!");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(41008);
            return;
          }
          ae.i("MicroMsg.GameLocalMediaView", "click Image path:" + ((GalleryItem.MediaItem)localObject).tRJ);
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
                h.cm(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623950, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
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
                GameLocalGalleryView.c.g(GameLocalGalleryView.c.this).If(GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).size());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameLocalGalleryView$RecycleViewAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(41008);
              return;
              if ((com.tencent.mm.plugin.gallery.model.e.cXr().kXg == 3) && (localObject != null) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")))
              {
                com.tencent.mm.vfs.o.aZR(((GalleryItem.MediaItem)localObject).tRJ);
                if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().acv(((GalleryItem.MediaItem)localObject).tRJ))
                {
                  h.cm(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getString(2131759800));
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
                h.cm(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623952, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
                break label291;
              }
              h.cm(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623951, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
              break label291;
              label647:
              ((CheckBox)paramAnonymousView.getTag(2131302204)).setChecked(true);
              ((View)paramAnonymousView.getTag(2131302212)).setVisibility(0);
              ((View)paramAnonymousView.getTag(2131302212)).setBackgroundResource(2131099819);
              GameLocalGalleryView.Ie(1);
            }
            label694:
            i = 1;
            j = 1;
          }
        }
      };
      this.mContext = paramContext;
      this.tWe.add(new GalleryItem.ImageMediaItem());
      ae.i("MicroMsg.GameLocalMediaView", "RecycleViewAdapter");
      AppMethodBeat.o(41009);
    }
    
    final ArrayList<GalleryItem.MediaItem> HI(int paramInt)
    {
      AppMethodBeat.i(195613);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.tWe.iterator();
      while (localIterator.hasNext())
      {
        GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
        if (localMediaItem.getType() == paramInt) {
          localArrayList.add(localMediaItem);
        }
      }
      AppMethodBeat.o(195613);
      return localArrayList;
    }
    
    final void ac(ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(41012);
      ae.d("MicroMsg.GameLocalMediaView", "before set selected paths, selected[%s]", new Object[] { this.tWf });
      this.tWf.clear();
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(0, 0L, str, str, "");
          if (com.tencent.mm.plugin.gallery.model.e.cXt() != null)
          {
            int i = com.tencent.mm.plugin.gallery.model.e.cXt().indexOf(localMediaItem);
            if (i >= 0)
            {
              localMediaItem = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.cXt().get(i);
              if ((localMediaItem != null) && (localMediaItem.getType() == 2))
              {
                this.tWf.add(GalleryItem.MediaItem.a(2, 0L, str, "", ""));
                continue;
              }
            }
          }
          ae.d("MicroMsg.GameLocalMediaView", "media item no exist on preview items.");
          this.tWf.add(GalleryItem.MediaItem.a(1, 0L, str, "", ""));
        }
      }
      ae.d("MicroMsg.GameLocalMediaView", "after set selected paths, selected[%s]", new Object[] { this.tWf });
      if (this.uiM != null) {
        this.uiM.If(this.tWf.size());
      }
      ar.f(new Runnable()
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
    
    public final ArrayList<String> cYs()
    {
      AppMethodBeat.i(41011);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.tWf.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).tRJ);
      }
      AppMethodBeat.o(41011);
      return localArrayList;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(41010);
      ae.i("MicroMsg.GameLocalMediaView", "getItemCount, count : %d", new Object[] { Integer.valueOf(this.tWe.size()) });
      int i = this.tWe.size();
      AppMethodBeat.o(41010);
      return i;
    }
  }
  
  final class d
    extends RecyclerView.w
  {
    CheckBox iFD;
    View rLa;
    ImageView tMY;
    ImageView tWp;
    ImageView uah;
    RelativeLayout uai;
    TextView uaj;
    ImageView ual;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(41015);
      this.uah = ((ImageView)paramView.findViewById(2131302216));
      this.tMY = ((ImageView)paramView.findViewById(2131302221));
      this.uai = ((RelativeLayout)paramView.findViewById(2131306355));
      this.uaj = ((TextView)paramView.findViewById(2131306357));
      this.iFD = ((CheckBox)paramView.findViewById(2131302204));
      this.rLa = paramView.findViewById(2131302205);
      this.tWp = ((ImageView)paramView.findViewById(2131302212));
      this.rLa.setTag(2131302204, this.iFD);
      this.rLa.setTag(2131302212, this.tWp);
      this.ual = ((ImageView)paramView.findViewById(2131299258));
      AppMethodBeat.o(41015);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView
 * JD-Core Version:    0.7.0.1
 */