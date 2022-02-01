package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.widget.GameGridLayoutManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
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
  static final int rRU;
  static final int rRV;
  private RecyclerView rRW;
  c rRX;
  private TextView rRY;
  private Button rRZ;
  private int rSa;
  private boolean rSb;
  
  static
  {
    AppMethodBeat.i(41027);
    rRU = "GameLocalGalleryView_REQUEST_CODE_VIDEO".hashCode() & 0xFFFF;
    rRV = "GameLocalGalleryView_REQUEST_CODE_IMAGE".hashCode() & 0xFFFF;
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
  
  static void cCf()
  {
    AppMethodBeat.i(41023);
    a.En(2);
    AppMethodBeat.o(41023);
  }
  
  private static void fO(int paramInt1, int paramInt2)
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
    this.rRW = ((RecyclerView)localView.findViewById(2131300504));
    getContext();
    GameGridLayoutManager localGameGridLayoutManager = new GameGridLayoutManager((byte)0);
    this.rRW.setLayoutManager(localGameGridLayoutManager);
    this.rRW.a(new GameLocalGalleryView.a(this));
    this.rRX = new c(getContext());
    this.rRW.setAdapter(this.rRX);
    this.rRY = ((TextView)localView.findViewById(2131300507));
    this.rRY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40997);
        paramAnonymousView = new Intent(GameLocalGalleryView.this.getContext(), ImagePreviewUI.class);
        paramAnonymousView.putStringArrayListExtra("preview_image_list", GameLocalGalleryView.a(GameLocalGalleryView.this).cAm());
        paramAnonymousView.putParcelableArrayListExtra("preview_media_item_list", GameLocalGalleryView.c.a(GameLocalGalleryView.a(GameLocalGalleryView.this)));
        paramAnonymousView.putExtra("max_select_count", GameLocalGalleryView.b(GameLocalGalleryView.this));
        paramAnonymousView.putExtra("send_raw_img", false);
        com.tencent.mm.bs.d.b(GameLocalGalleryView.this.getContext(), "gallery", ".ui.ImagePreviewUI", paramAnonymousView, GameLocalGalleryView.rRV);
        AppMethodBeat.o(40997);
      }
    });
    this.rRZ = ((Button)localView.findViewById(2131300506));
    this.rRZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40998);
        Object localObject = GameLocalGalleryView.a(GameLocalGalleryView.this).rGV;
        paramAnonymousView = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject).next();
          if ((localMediaItem.mMimeType.equals("edit")) && (!bt.isNullOrNil(localMediaItem.rBr))) {
            paramAnonymousView.add(localMediaItem.rBr);
          } else {
            paramAnonymousView.add(localMediaItem.rBp);
          }
        }
        if (!bt.gL(paramAnonymousView)) {
          GameLocalGalleryView.cCg();
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImage_OutputPath_List", paramAnonymousView);
        ((Activity)GameLocalGalleryView.this.getContext()).setResult(-1, (Intent)localObject);
        ((Activity)GameLocalGalleryView.this.getContext()).finish();
        AppMethodBeat.o(40998);
      }
    });
    this.rRX.rSd = new b()
    {
      public final void Es(int paramAnonymousInt)
      {
        AppMethodBeat.i(40999);
        if (paramAnonymousInt > 0)
        {
          GameLocalGalleryView.c(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131759923, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(GameLocalGalleryView.b(GameLocalGalleryView.this)) }));
          GameLocalGalleryView.d(GameLocalGalleryView.this).setEnabled(true);
          AppMethodBeat.o(40999);
          return;
        }
        GameLocalGalleryView.c(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131759922));
        GameLocalGalleryView.d(GameLocalGalleryView.this).setEnabled(false);
        AppMethodBeat.o(40999);
      }
    };
    addView(localView, -1, -1);
    AppMethodBeat.o(41019);
  }
  
  public final void cCd()
  {
    AppMethodBeat.i(41020);
    if (!this.rSb) {
      fO(0, 1);
    }
    this.rSb = true;
    AppMethodBeat.o(41020);
  }
  
  public final void cCe()
  {
    AppMethodBeat.i(41022);
    c localc = this.rRX;
    localc.rGV.clear();
    if (localc.rSd != null) {
      localc.rSd.Es(localc.rGV.size());
    }
    localc.rSc.postDelayed(new GameLocalGalleryView.c.4(localc), 500L);
    AppMethodBeat.o(41022);
  }
  
  public void setQueryType(int paramInt)
  {
    AppMethodBeat.i(41021);
    this.rRX.rBG = paramInt;
    a.a(paramInt, new a.c()
    {
      public final void al(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(41000);
        ArrayList localArrayList = new ArrayList();
        if (paramAnonymousLinkedList != null) {
          localArrayList.addAll(paramAnonymousLinkedList);
        }
        aq.f(new GameLocalGalleryView.c.3(GameLocalGalleryView.a(GameLocalGalleryView.this), localArrayList));
        AppMethodBeat.o(41000);
      }
    });
    AppMethodBeat.o(41021);
  }
  
  public void setSelectLimitCount(int paramInt)
  {
    this.rRX.rGT = paramInt;
    this.rSa = paramInt;
  }
  
  static abstract interface b
  {
    public abstract void Es(int paramInt);
  }
  
  final class c
    extends RecyclerView.a<GameLocalGalleryView.d>
  {
    private Context mContext;
    int rBG;
    int rGT;
    ArrayList<GalleryItem.MediaItem> rGU;
    ArrayList<GalleryItem.MediaItem> rGV;
    private View.OnClickListener rHb;
    GameLocalGalleryView.b rSd;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(41009);
      this.rGU = new ArrayList();
      this.rGV = new ArrayList();
      this.rHb = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41008);
          if (!(paramAnonymousView.getTag(2131302205) instanceof Integer))
          {
            AppMethodBeat.o(41008);
            return;
          }
          Object localObject = (Integer)paramAnonymousView.getTag(2131302205);
          if (localObject == null)
          {
            ad.e("MicroMsg.GameLocalMediaView", "[onClick] null == position!");
            AppMethodBeat.o(41008);
            return;
          }
          localObject = (GalleryItem.MediaItem)GameLocalGalleryView.c.e(GameLocalGalleryView.c.this).get(((Integer)localObject).intValue());
          if ((localObject == null) || (bt.isNullOrNil(((GalleryItem.MediaItem)localObject).rBp)))
          {
            ad.e("MicroMsg.GameLocalMediaView", "[onClick] null == item!");
            AppMethodBeat.o(41008);
            return;
          }
          ad.i("MicroMsg.GameLocalMediaView", "click Image path:" + ((GalleryItem.MediaItem)localObject).rBp);
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
                h.cf(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623950, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
              }
            }
            else
            {
              label223:
              if (1 != i) {
                break label555;
              }
              ((CheckBox)paramAnonymousView.getTag(2131302204)).setChecked(false);
              ((View)paramAnonymousView.getTag(2131302212)).setVisibility(0);
              ((View)paramAnonymousView.getTag(2131302212)).setBackgroundResource(2131100506);
            }
            for (;;)
            {
              if (GameLocalGalleryView.c.g(GameLocalGalleryView.c.this) != null) {
                GameLocalGalleryView.c.g(GameLocalGalleryView.c.this).Es(GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).size());
              }
              AppMethodBeat.o(41008);
              return;
              if ((com.tencent.mm.plugin.gallery.model.e.czh().jWF == 3) && (localObject != null) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")))
              {
                i.aMN(((GalleryItem.MediaItem)localObject).rBp);
                if (!((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().TM(((GalleryItem.MediaItem)localObject).rBp))
                {
                  h.cf(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getString(2131759800));
                  AppMethodBeat.o(41008);
                  return;
                }
              }
              if (GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).size() >= GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) {
                break label602;
              }
              GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).add(localObject);
              i = 0;
              j = 0;
              break;
              if (GameLocalGalleryView.c.f(GameLocalGalleryView.c.this) == 2)
              {
                h.cf(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623952, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
                break label223;
              }
              h.cf(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623951, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
              break label223;
              label555:
              ((CheckBox)paramAnonymousView.getTag(2131302204)).setChecked(true);
              ((View)paramAnonymousView.getTag(2131302212)).setVisibility(0);
              ((View)paramAnonymousView.getTag(2131302212)).setBackgroundResource(2131099819);
              GameLocalGalleryView.Er(1);
            }
            label602:
            i = 1;
            j = 1;
          }
        }
      };
      this.mContext = paramContext;
      this.rGU.add(new GalleryItem.ImageMediaItem());
      ad.i("MicroMsg.GameLocalMediaView", "RecycleViewAdapter");
      AppMethodBeat.o(41009);
    }
    
    final void S(ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(41012);
      ad.d("MicroMsg.GameLocalMediaView", "before set selected paths, selected[%s]", new Object[] { this.rGV });
      this.rGV.clear();
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(0, 0L, str, str, "");
          if (com.tencent.mm.plugin.gallery.model.e.czj() != null)
          {
            int i = com.tencent.mm.plugin.gallery.model.e.czj().indexOf(localMediaItem);
            if (i >= 0)
            {
              localMediaItem = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.czj().get(i);
              if ((localMediaItem != null) && (localMediaItem.getType() == 2))
              {
                this.rGV.add(GalleryItem.MediaItem.a(2, 0L, str, "", ""));
                continue;
              }
            }
          }
          ad.d("MicroMsg.GameLocalMediaView", "media item no exist on preview items.");
          this.rGV.add(GalleryItem.MediaItem.a(1, 0L, str, "", ""));
        }
      }
      ad.d("MicroMsg.GameLocalMediaView", "after set selected paths, selected[%s]", new Object[] { this.rGV });
      if (this.rSd != null) {
        this.rSd.Es(this.rGV.size());
      }
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41007);
          GameLocalGalleryView.c.this.aql.notifyChanged();
          AppMethodBeat.o(41007);
        }
      });
      AppMethodBeat.o(41012);
    }
    
    public final ArrayList<String> cAm()
    {
      AppMethodBeat.i(41011);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.rGV.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).rBp);
      }
      AppMethodBeat.o(41011);
      return localArrayList;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(41010);
      ad.i("MicroMsg.GameLocalMediaView", "getItemCount, count : %d", new Object[] { Integer.valueOf(this.rGU.size()) });
      int i = this.rGU.size();
      AppMethodBeat.o(41010);
      return i;
    }
  }
  
  final class d
    extends RecyclerView.v
  {
    CheckBox hIS;
    View qkk;
    ImageView rHf;
    ImageView rKX;
    RelativeLayout rKY;
    TextView rKZ;
    ImageView rLb;
    ImageView rww;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(41015);
      this.rKX = ((ImageView)paramView.findViewById(2131302216));
      this.rww = ((ImageView)paramView.findViewById(2131302221));
      this.rKY = ((RelativeLayout)paramView.findViewById(2131306355));
      this.rKZ = ((TextView)paramView.findViewById(2131306357));
      this.hIS = ((CheckBox)paramView.findViewById(2131302204));
      this.qkk = paramView.findViewById(2131302205);
      this.rHf = ((ImageView)paramView.findViewById(2131302212));
      this.qkk.setTag(2131302204, this.hIS);
      this.qkk.setTag(2131302212, this.rHf);
      this.rLb = ((ImageView)paramView.findViewById(2131299258));
      AppMethodBeat.o(41015);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView
 * JD-Core Version:    0.7.0.1
 */