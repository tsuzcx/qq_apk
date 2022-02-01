package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.gallery.b.b;
import com.tencent.mm.plugin.gallery.b.c;
import com.tencent.mm.plugin.gallery.b.d;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.s.a;
import com.tencent.mm.plugin.gallery.model.s.b;
import com.tencent.mm.plugin.gallery.model.s.c;
import com.tencent.mm.plugin.gallery.model.s.d;
import com.tencent.mm.plugin.gallery.model.s.f;
import com.tencent.mm.plugin.gallery.model.s.i;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class SmartGalleryUI
  extends MMActivity
{
  public static int Cer = 1;
  private String BVr;
  private RecyclerView Cef;
  private EditText Ceg;
  private b Ceh;
  private f Cei;
  private e Cej;
  private h Cek;
  private int Cel;
  private boolean Cem;
  i Cen;
  private boolean Ceo;
  c Cep;
  private boolean Ceq;
  private int pag;
  private ProgressDialog syZ;
  Button uOZ;
  
  public SmartGalleryUI()
  {
    AppMethodBeat.i(111703);
    this.Cem = false;
    this.Ceo = true;
    this.Cep = new c()
    {
      public final void a(s.a paramAnonymousa)
      {
        AppMethodBeat.i(111677);
        Log.i("MicroMsg.SmartGalleryUI", "onAlbumClick, albumId: %s, albumName: %s.", new Object[] { paramAnonymousa.BVZ, paramAnonymousa.albumName });
        Intent localIntent = new Intent(SmartGalleryUI.this, AlbumPreviewUI.class);
        localIntent.putExtras(SmartGalleryUI.this.getIntent());
        localIntent.putExtra("send_raw_img", SmartGalleryUI.b(SmartGalleryUI.this));
        if (SmartGalleryUI.h(SmartGalleryUI.this)) {
          if ((paramAnonymousa.BWd != null) && (paramAnonymousa.BWd.BWe)) {
            localIntent.putExtra("select_type_tag", 1);
          }
        }
        try
        {
          while ((paramAnonymousa.BVY != null) && (paramAnonymousa.BVY.BWk != null))
          {
            Object localObject = paramAnonymousa.BVY.BWk;
            String str2 = "";
            if (paramAnonymousa.albumName != null) {
              str2 = paramAnonymousa.albumName;
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(18269, new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(str2, "utf-8") });
            localIntent.putExtra("is_from_smart_gallery", true);
            str2 = paramAnonymousa.albumName;
            localObject = str2;
            if (Util.isNullOrNil(str2)) {
              localObject = paramAnonymousa.BVY.BWk;
            }
            localIntent.putExtra("title_from_smart_gallery", (String)localObject);
            localIntent.putExtra("album_id_from_smart_gallery", paramAnonymousa.BVZ);
            SmartGalleryUI.this.startActivityForResult(localIntent, 1);
            AppMethodBeat.o(111677);
            return;
            localIntent.putExtra("select_type_tag", 0);
            continue;
            localIntent.putExtra("select_type_tag", 2);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            continue;
            String str1 = "";
          }
        }
      }
    };
    this.Ceq = false;
    AppMethodBeat.o(111703);
  }
  
  private void euU()
  {
    AppMethodBeat.i(111706);
    int i = com.tencent.mm.plugin.gallery.model.s.etX().eub();
    if (i > 0) {
      this.uOZ.setEnabled(true);
    }
    for (;;)
    {
      this.uOZ.setText(com.tencent.mm.plugin.gallery.a.e.a(this, this.pag, i, this.Cel, this.BVr, null));
      AppMethodBeat.o(111706);
      return;
      this.uOZ.setEnabled(false);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.f.smart_gallery_layout;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(111707);
    Log.i("MicroMsg.SmartGalleryUI", "requestCode: %d, resultCode: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent != null)
    {
      this.Ceq = paramIntent.getBooleanExtra("send_raw_img", false);
      paramIntent.putExtra("send_raw_img", this.Ceq);
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle != null)
      {
        Iterator localIterator = localBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Log.i("MicroMsg.SmartGalleryUI", "key: %s, value: %s.", new Object[] { str, localBundle.get(str) });
        }
      }
    }
    if (1 == paramInt1)
    {
      if ((-2 == paramInt2) || (paramInt2 == 0))
      {
        Log.i("MicroMsg.SmartGalleryUI", "just back from AlbumPreviewUI.");
        euU();
        AppMethodBeat.o(111707);
        return;
      }
      setResult(paramInt2, paramIntent);
      finish();
    }
    AppMethodBeat.o(111707);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111704);
    super.onCreate(paramBundle);
    this.pag = getIntent().getIntExtra("query_source_type", 3);
    this.Cel = getIntent().getIntExtra("max_select_count", 9);
    this.BVr = getIntent().getStringExtra("album_business_tag");
    this.Ceq = getIntent().getBooleanExtra("send_raw_img", false);
    this.syZ = com.tencent.mm.ui.base.s.a(this, getString(b.i.app_waiting), true);
    this.syZ.show();
    setActionbarColor(getResources().getColor(b.b.gallery_dark_mode_color));
    setNavigationbarColor(getResources().getColor(b.b.gallery_dark_mode_color));
    paramBundle = LayoutInflater.from(this).inflate(b.f.action_bar_smart_gallery, new LinearLayout(this), false);
    paramBundle.findViewById(b.e.smart_gallery_back).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111671);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (Util.isNullOrNil(SmartGalleryUI.a(SmartGalleryUI.this).getText()))
        {
          SmartGalleryUI.this.setResult(-2, SmartGalleryUI.this.getIntent().putExtra("send_raw_img", SmartGalleryUI.b(SmartGalleryUI.this)));
          SmartGalleryUI.this.finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111671);
          return;
          SmartGalleryUI.a(SmartGalleryUI.this).setText("");
        }
      }
    });
    this.Ceg = ((EditText)paramBundle.findViewById(b.e.smart_gallery_search));
    this.Ceg.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(111672);
        if (!SmartGalleryUI.c(SmartGalleryUI.this)) {
          SmartGalleryUI.a(SmartGalleryUI.this, true);
        }
        AppMethodBeat.o(111672);
        return false;
      }
    });
    this.Ceg.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(111673);
        if (3 == paramAnonymousInt)
        {
          paramAnonymousTextView = paramAnonymousTextView.getText().toString();
          if (!Util.isNullOrNil(paramAnonymousTextView))
          {
            SmartGalleryUI.a(SmartGalleryUI.this, paramAnonymousTextView, true);
            AppMethodBeat.o(111673);
            return true;
          }
        }
        AppMethodBeat.o(111673);
        return false;
      }
    });
    this.Ceg.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(111674);
        paramAnonymousEditable = paramAnonymousEditable.toString();
        Log.d("MicroMsg.SmartGalleryUI", "cur txt: %s.", new Object[] { paramAnonymousEditable });
        SmartGalleryUI.d(SmartGalleryUI.this).CeE = paramAnonymousEditable;
        if (Util.isNullOrNil(paramAnonymousEditable))
        {
          SmartGalleryUI.e(SmartGalleryUI.this);
          SmartGalleryUI.g(SmartGalleryUI.this).setAdapter(SmartGalleryUI.f(SmartGalleryUI.this));
          SmartGalleryUI.g(SmartGalleryUI.this).a(SmartGalleryUI.this.Cen);
          SmartGalleryUI.f(SmartGalleryUI.this).alc.notifyChanged();
          AppMethodBeat.o(111674);
          return;
        }
        SmartGalleryUI.a(SmartGalleryUI.this, paramAnonymousEditable, false);
        AppMethodBeat.o(111674);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.uOZ = ((Button)paramBundle.findViewById(b.e.smart_gallery_send));
    euU();
    this.uOZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111675);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        SmartGalleryUI.this.setResult(SmartGalleryUI.Cer);
        SmartGalleryUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(111675);
      }
    });
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      localActionBar.setLogo(new ColorDrawable(getContext().getResources().getColor(17170445)));
      localActionBar.t(false);
      localActionBar.s(false);
      localActionBar.r(false);
      localActionBar.u(true);
      localActionBar.setCustomView(paramBundle);
    }
    for (;;)
    {
      this.Cen = new i(this, 1);
      this.Cen.t(getResources().getDrawable(b.d.smart_gallery_divider));
      this.Cef = ((RecyclerView)findViewById(b.e.smart_gallery_recycler_view));
      this.Cef.a(new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(240847);
          b localb = new b();
          localb.bn(paramAnonymousRecyclerView);
          localb.sg(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
          Log.d("MicroMsg.SmartGalleryUI", "onScrollStateChanged, newState: %d, mIsNeedReset: %s.", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(SmartGalleryUI.c(SmartGalleryUI.this)) });
          if ((1 == paramAnonymousInt) && (SmartGalleryUI.c(SmartGalleryUI.this)))
          {
            SmartGalleryUI.a(SmartGalleryUI.this, false);
            SmartGalleryUI.this.hideVKB();
            SmartGalleryUI.a(SmartGalleryUI.this).clearFocus();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(240847);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(240849);
          b localb = new b();
          localb.bn(paramAnonymousRecyclerView);
          localb.sg(paramAnonymousInt1);
          localb.sg(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(240849);
        }
      });
      this.Cef.a(this.Cen);
      this.Ceh = new b(this);
      this.Ceh.Cep = this.Cep;
      this.Cei = new f(this);
      this.Cei.Cep = this.Cep;
      this.Cef.setLayoutManager(new LinearLayoutManager());
      this.Cef.setAdapter(this.Ceh);
      this.Cek = new h(this.Cef, this.Cei);
      this.Cej = new e(this.Cek);
      com.tencent.mm.plugin.gallery.model.e.etm().aw(new d(this.Ceh, this.syZ, this.Ceg));
      AppMethodBeat.o(111704);
      return;
      Log.e("MicroMsg.SmartGalleryUI", "actionbar is null.");
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111710);
    super.onDestroy();
    com.tencent.mm.plugin.gallery.model.s.etX().eua();
    AppMethodBeat.o(111710);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111708);
    if ((4 == paramInt) && (paramKeyEvent.getRepeatCount() == 0))
    {
      if (Util.isNullOrNil(this.Ceg.getText()))
      {
        setResult(-2, getIntent().putExtra("send_raw_img", this.Ceq));
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(111708);
        return true;
        this.Ceg.setText("");
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(111708);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(111709);
    super.onPause();
    this.Ceg.clearFocus();
    AppMethodBeat.o(111709);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111705);
    super.onResume();
    euU();
    AppMethodBeat.o(111705);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends RecyclerView.a<a>
  {
    private View.OnLongClickListener BZM;
    SmartGalleryUI.c Cep;
    List<s.a> Cet;
    private int Ceu;
    View.OnClickListener bwV;
    private Context mContext;
    
    a(Context paramContext)
    {
      AppMethodBeat.i(111681);
      this.bwV = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111678);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = paramAnonymousView.getTag();
          if (((paramAnonymousView instanceof s.a)) && (SmartGalleryUI.a.a(SmartGalleryUI.a.this) != null)) {
            SmartGalleryUI.a.a(SmartGalleryUI.a.this).a((s.a)paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111678);
        }
      };
      this.BZM = new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111679);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
          paramAnonymousView = paramAnonymousView.getTag();
          if ((paramAnonymousView instanceof s.a))
          {
            paramAnonymousView = (s.a)paramAnonymousView;
            ClipboardHelper.setText(SmartGalleryUI.a.b(SmartGalleryUI.a.this), "media info", paramAnonymousView.toString());
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(111679);
          return true;
        }
      };
      this.mContext = paramContext;
      this.Cet = new ArrayList();
      this.Ceu = ((this.mContext.getResources().getDisplayMetrics().widthPixels - aw.aZ(this.mContext, b.c.Edge_2A) - aw.aZ(this.mContext, b.c.Edge_A) * 4) / 9 * 2);
      Log.d("MicroMsg.SmartGalleryUI", "mThumbSize: %d.", new Object[] { Integer.valueOf(this.Ceu) });
      AppMethodBeat.o(111681);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111682);
      int i = this.Cet.size();
      AppMethodBeat.o(111682);
      return i;
    }
    
    static final class a
      extends RecyclerView.v
    {
      ImageView Cew;
      TextView Cex;
      TextView Cey;
      
      a(View paramView, int paramInt)
      {
        super();
        AppMethodBeat.i(111680);
        this.Cew = ((ImageView)paramView.findViewById(b.e.album_cover));
        ViewGroup.LayoutParams localLayoutParams = this.Cew.getLayoutParams();
        localLayoutParams.width = paramInt;
        localLayoutParams.height = paramInt;
        this.Cew.setLayoutParams(localLayoutParams);
        this.Cex = ((TextView)paramView.findViewById(b.e.album_name));
        this.Cey = ((TextView)paramView.findViewById(b.e.album_capacity));
        AppMethodBeat.o(111680);
      }
    }
  }
  
  static final class b
    extends RecyclerView.a<a>
  {
    SmartGalleryUI.c Cep;
    s.c Cez;
    private Context mContext;
    
    b(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111686);
      if (this.Cez == null)
      {
        AppMethodBeat.o(111686);
        return 0;
      }
      int i = this.Cez.BWi.size();
      AppMethodBeat.o(111686);
      return i;
    }
    
    static final class a
      extends RecyclerView.v
    {
      RecyclerView CeA;
      TextView tud;
      
      a(View paramView)
      {
        super();
        AppMethodBeat.i(111685);
        this.tud = ((TextView)paramView.findViewById(b.e.category_title));
        ar.a(this.tud.getPaint(), 0.8F);
        this.CeA = ((RecyclerView)paramView.findViewById(b.e.category_detail));
        AppMethodBeat.o(111685);
      }
    }
  }
  
  static abstract interface c
  {
    public abstract void a(s.a parama);
  }
  
  static final class d
    implements Runnable
  {
    WeakReference<SmartGalleryUI.b> CeB;
    WeakReference<ProgressDialog> CeC;
    WeakReference<EditText> CeD;
    
    d(SmartGalleryUI.b paramb, ProgressDialog paramProgressDialog, EditText paramEditText)
    {
      AppMethodBeat.i(111689);
      this.CeB = new WeakReference(paramb);
      this.CeC = new WeakReference(paramProgressDialog);
      this.CeD = new WeakReference(paramEditText);
      AppMethodBeat.o(111689);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111690);
      long l1 = System.currentTimeMillis();
      Log.i("MicroMsg.SmartGalleryUI", "start query category album.");
      Object localObject2 = com.tencent.mm.plugin.gallery.model.s.etX();
      Object localObject1 = new ArrayList();
      Object localObject3 = com.tencent.mm.plugin.gallery.model.s.BVU.buildUpon().appendEncodedPath("albums").build();
      localObject2 = ((com.tencent.mm.plugin.gallery.model.s)localObject2).kiH.query((Uri)localObject3, com.tencent.mm.plugin.gallery.model.s.etY(), null, null, null);
      if (localObject2 != null)
      {
        int i = ((Cursor)localObject2).getColumnIndex("categoryID");
        int j = ((Cursor)localObject2).getColumnIndex("categoryName");
        int k = ((Cursor)localObject2).getColumnIndex("albumID");
        int m = ((Cursor)localObject2).getColumnIndex("albumName");
        int n = ((Cursor)localObject2).getColumnIndex("albumCapacity");
        int i1 = ((Cursor)localObject2).getColumnIndex("coverID");
        int i2 = ((Cursor)localObject2).getColumnIndex("coverData");
        int i3 = ((Cursor)localObject2).getColumnIndex("albumTag");
        while (((Cursor)localObject2).moveToNext())
        {
          localObject3 = new s.a();
          ((s.a)localObject3).hK(((Cursor)localObject2).getString(i), ((Cursor)localObject2).getString(j));
          ((s.a)localObject3).BVZ = ((Cursor)localObject2).getString(k);
          ((s.a)localObject3).albumName = ((Cursor)localObject2).getString(m);
          ((s.a)localObject3).BWa = Util.safeParseInt(((Cursor)localObject2).getString(n));
          ((s.a)localObject3).BWb = Util.safeParseLong(((Cursor)localObject2).getString(i1));
          ((s.a)localObject3).BWc = ((Cursor)localObject2).getString(i2);
          String str = ((Cursor)localObject2).getString(i3);
          if (!Util.isNullOrNil(str)) {
            ((s.a)localObject3).BWd = com.tencent.mm.plugin.gallery.model.s.hJ(str, ((s.a)localObject3).BVZ);
          }
          ((List)localObject1).add(localObject3);
        }
        ((Cursor)localObject2).close();
      }
      localObject1 = com.tencent.mm.plugin.gallery.model.s.fl((List)localObject1);
      Log.i("MicroMsg.SmartGalleryUI", "finish query category album.");
      long l2 = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.IzE.a(19165, new Object[] { "", Long.valueOf(l2 - l1) });
      localObject1 = new SmartGalleryUI.g(this.CeB, (s.c)localObject1);
      ((SmartGalleryUI.g)localObject1).CeC = this.CeC;
      ((SmartGalleryUI.g)localObject1).CeD = this.CeD;
      com.tencent.mm.plugin.gallery.model.e.etm().postToMainThread((Runnable)localObject1);
      AppMethodBeat.o(111690);
    }
  }
  
  static final class e
    implements Runnable
  {
    String CeE;
    SmartGalleryUI.h CeF;
    
    e(SmartGalleryUI.h paramh)
    {
      this.CeF = paramh;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111691);
      if (Util.isNullOrNil(this.CeE))
      {
        Log.e("MicroMsg.SmartGalleryUI", "keyword is invalid.");
        AppMethodBeat.o(111691);
        return;
      }
      Log.i("MicroMsg.SmartGalleryUI", "query search start.");
      Object localObject3 = com.tencent.mm.plugin.gallery.model.s.etX();
      Object localObject1 = this.CeE;
      Object localObject2 = new ArrayList();
      Object localObject4 = com.tencent.mm.plugin.gallery.model.s.BVU.buildUpon().appendEncodedPath("search").build();
      localObject3 = ((com.tencent.mm.plugin.gallery.model.s)localObject3).kiH.query((Uri)localObject4, new String[] { "categoryID", "categoryName", "albumID", "albumName", "albumCapacity", "coverID", "coverData", "albumTag" }, "keyword=?", new String[] { localObject1 }, null);
      int i;
      if (localObject3 != null)
      {
        i = ((Cursor)localObject3).getColumnIndex("categoryID");
        int j = ((Cursor)localObject3).getColumnIndex("categoryName");
        int k = ((Cursor)localObject3).getColumnIndex("albumID");
        int m = ((Cursor)localObject3).getColumnIndex("albumName");
        int n = ((Cursor)localObject3).getColumnIndex("albumCapacity");
        int i1 = ((Cursor)localObject3).getColumnIndex("coverID");
        int i2 = ((Cursor)localObject3).getColumnIndex("coverData");
        int i3 = ((Cursor)localObject3).getColumnIndex("albumTag");
        while (((Cursor)localObject3).moveToNext())
        {
          localObject4 = new s.a();
          ((s.a)localObject4).hK(((Cursor)localObject3).getString(i), ((Cursor)localObject3).getString(j));
          ((s.a)localObject4).BVZ = ((Cursor)localObject3).getString(k);
          ((s.a)localObject4).albumName = ((Cursor)localObject3).getString(m);
          ((s.a)localObject4).BWa = Util.safeParseInt(((Cursor)localObject3).getString(n));
          ((s.a)localObject4).BWb = Util.safeParseLong(((Cursor)localObject3).getString(i1));
          ((s.a)localObject4).BWc = ((Cursor)localObject3).getString(i2);
          String str = ((Cursor)localObject3).getString(i3);
          if (!Util.isNullOrNil(str)) {
            ((s.a)localObject4).BWd = com.tencent.mm.plugin.gallery.model.s.hJ(str, ((s.a)localObject4).BVZ);
          }
          ((List)localObject2).add(localObject4);
        }
        ((Cursor)localObject3).close();
      }
      localObject1 = com.tencent.mm.plugin.gallery.model.s.p((List)localObject2, (String)localObject1);
      Log.i("MicroMsg.SmartGalleryUI", "query search finish.");
      for (;;)
      {
        try
        {
          localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
          localObject3 = URLEncoder.encode(this.CeE, "utf-8");
          if (((List)localObject1).size() != 0) {
            continue;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject2).a(18270, new Object[] { localObject3, Integer.valueOf(i) });
        }
        catch (Exception localException)
        {
          continue;
        }
        if ((!Util.isNullOrNil(this.CeF.CeE)) && (this.CeF.CeE.equals(this.CeE))) {
          continue;
        }
        Log.i("MicroMsg.SmartGalleryUI", "mKeyword: %s, cur: %s.", new Object[] { this.CeE, this.CeF.CeE });
        AppMethodBeat.o(111691);
        return;
        i = 1;
      }
      localObject2 = this.CeF;
      ((SmartGalleryUI.h)localObject2).uAd.clear();
      ((SmartGalleryUI.h)localObject2).uAd.addAll((Collection)localObject1);
      com.tencent.mm.plugin.gallery.model.e.etm().postToMainThread(this.CeF);
      AppMethodBeat.o(111691);
    }
  }
  
  static final class f
    extends RecyclerView.a<RecyclerView.v>
  {
    String CeE;
    SmartGalleryUI.c Cep;
    private View.OnClickListener bwV;
    private Context mContext;
    List<s.i> uAd;
    
    f(Context paramContext)
    {
      AppMethodBeat.i(111695);
      this.bwV = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111692);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$SearchAlbumAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = paramAnonymousView.getTag();
          if (((paramAnonymousView instanceof s.a)) && (SmartGalleryUI.f.a(SmartGalleryUI.f.this) != null)) {
            SmartGalleryUI.f.a(SmartGalleryUI.f.this).a((s.a)paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$SearchAlbumAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111692);
        }
      };
      this.mContext = paramContext;
      this.uAd = new ArrayList();
      AppMethodBeat.o(111695);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(241336);
      if (paramInt == 0)
      {
        paramViewGroup = new b(LayoutInflater.from(this.mContext).inflate(b.f.smart_gallery_search_category_item_layout, paramViewGroup, false));
        AppMethodBeat.o(241336);
        return paramViewGroup;
      }
      if (1 == paramInt)
      {
        paramViewGroup = new a(LayoutInflater.from(this.mContext).inflate(b.f.smart_gallery_search_album_item_layout, paramViewGroup, false));
        AppMethodBeat.o(241336);
        return paramViewGroup;
      }
      paramViewGroup = new SmartGalleryUI.f.c(LayoutInflater.from(this.mContext).inflate(b.f.smart_gallery_search_empty_item_layout, paramViewGroup, false));
      AppMethodBeat.o(241336);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(241339);
      Object localObject1;
      if ((paramv instanceof b))
      {
        localObject1 = (s.d)this.uAd.get(paramInt);
        b.a((b)paramv).setText(((s.d)localObject1).BWk);
        AppMethodBeat.o(241339);
        return;
      }
      if ((paramv instanceof a))
      {
        localObject1 = (s.a)this.uAd.get(paramInt);
        paramv.amk.setOnClickListener(this.bwV);
        paramv.amk.setTag(localObject1);
        Object localObject2 = ((s.a)localObject1).BWd;
        paramInt = i;
        ImageView localImageView;
        String str1;
        String str2;
        long l;
        if (localObject2 != null)
        {
          if (((s.b)localObject2).BWf) {
            paramInt = 2;
          }
        }
        else
        {
          localObject2 = (a)paramv;
          localImageView = a.a((a)localObject2);
          str1 = ((s.a)localObject1).BWc;
          str2 = ((s.a)localObject1).BWc;
          l = ((s.a)localObject1).BWb;
          if (((s.a)localObject1).BWd != null) {
            break label220;
          }
        }
        label220:
        for (paramv = null;; paramv = ((s.a)localObject1).BWd.BUm)
        {
          h.a(localImageView, paramInt, str1, str2, l, paramv);
          a.b((a)localObject2).setText(f.b(((s.a)localObject1).albumName, this.CeE));
          a.c((a)localObject2).setText(String.valueOf(((s.a)localObject1).BWa));
          AppMethodBeat.o(241339);
          return;
          paramInt = 1;
          break;
        }
      }
      if ((paramv instanceof SmartGalleryUI.f.c)) {
        Log.i("MicroMsg.SmartGalleryUI", "no search result.");
      }
      AppMethodBeat.o(241339);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111698);
      if (this.uAd.size() == 0)
      {
        s.f localf = new s.f();
        this.uAd.add(localf);
      }
      int i = this.uAd.size();
      AppMethodBeat.o(111698);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(111699);
      paramInt = ((s.i)this.uAd.get(paramInt)).mType;
      AppMethodBeat.o(111699);
      return paramInt;
    }
    
    static final class a
      extends RecyclerView.v
    {
      private ImageView Cew;
      private TextView Cex;
      private TextView Cey;
      
      a(View paramView)
      {
        super();
        AppMethodBeat.i(111693);
        this.Cew = ((ImageView)paramView.findViewById(b.e.album_cover));
        this.Cex = ((TextView)paramView.findViewById(b.e.album_name));
        this.Cey = ((TextView)paramView.findViewById(b.e.album_capacity));
        AppMethodBeat.o(111693);
      }
    }
    
    static final class b
      extends RecyclerView.v
    {
      private TextView tud;
      
      b(View paramView)
      {
        super();
        AppMethodBeat.i(111694);
        this.tud = ((TextView)paramView.findViewById(b.e.category_title));
        ar.a(this.tud.getPaint(), 0.8F);
        AppMethodBeat.o(111694);
      }
    }
  }
  
  static final class g
    implements Runnable
  {
    WeakReference<SmartGalleryUI.b> CeB;
    WeakReference<ProgressDialog> CeC;
    WeakReference<EditText> CeD;
    s.c Cez;
    
    g(WeakReference<SmartGalleryUI.b> paramWeakReference, s.c paramc)
    {
      this.CeB = paramWeakReference;
      this.Cez = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111700);
      if ((this.CeB != null) && (this.Cez != null))
      {
        Object localObject = (SmartGalleryUI.b)this.CeB.get();
        if (localObject != null)
        {
          Log.i("MicroMsg.SmartGalleryUI", "show category.");
          ((SmartGalleryUI.b)localObject).Cez = this.Cez;
          ((RecyclerView.a)localObject).alc.notifyChanged();
        }
        if (this.CeC != null)
        {
          localObject = (ProgressDialog)this.CeC.get();
          if (localObject != null)
          {
            Log.i("MicroMsg.SmartGalleryUI", "tipDialog dismiss.");
            ((ProgressDialog)localObject).dismiss();
          }
        }
        if (this.CeD != null)
        {
          localObject = (EditText)this.CeD.get();
          if (localObject != null)
          {
            Log.i("MicroMsg.SmartGalleryUI", "show keyboard.");
            ((EditText)localObject).requestFocus();
            ((InputMethodManager)((EditText)localObject).getContext().getSystemService("input_method")).showSoftInput((View)localObject, 0);
          }
        }
      }
      AppMethodBeat.o(111700);
    }
  }
  
  static final class h
    implements Runnable
  {
    String CeE;
    WeakReference<RecyclerView> CeH;
    WeakReference<SmartGalleryUI.f> CeI;
    List<s.i> uAd;
    
    h(RecyclerView paramRecyclerView, SmartGalleryUI.f paramf)
    {
      AppMethodBeat.i(243387);
      this.uAd = new ArrayList();
      this.CeH = new WeakReference(paramRecyclerView);
      this.CeI = new WeakReference(paramf);
      AppMethodBeat.o(243387);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111702);
      if ((this.CeH == null) || (this.CeI == null))
      {
        Log.e("MicroMsg.SmartGalleryUI", "update search ui, ref is null, return.");
        AppMethodBeat.o(111702);
        return;
      }
      if (this.uAd != null)
      {
        Object localObject = (RecyclerView)this.CeH.get();
        if (localObject != null)
        {
          SmartGalleryUI.f localf = (SmartGalleryUI.f)this.CeI.get();
          if (localf != null)
          {
            ((RecyclerView)localObject).setAdapter(localf);
            localf.CeE = this.CeE;
            localObject = this.uAd;
            localf.uAd.clear();
            localf.uAd.addAll((Collection)localObject);
            localf.alc.notifyChanged();
          }
        }
        AppMethodBeat.o(111702);
        return;
      }
      Log.e("MicroMsg.SmartGalleryUI", "update search ui, data is null.");
      AppMethodBeat.o(111702);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI
 * JD-Core Version:    0.7.0.1
 */